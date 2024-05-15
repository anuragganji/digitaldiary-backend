package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Exception.EntryNotFoundException;
import com.major.DigitalDiary.Exception.NotAParentException;
import com.major.DigitalDiary.Exception.UserNotFoundException;
import com.major.DigitalDiary.Model.Entry;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserRelation;
import com.major.DigitalDiary.Repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static com.major.DigitalDiary.Query.EntryQuery.SELECT_YESTERDAY_ENTRY_QUERY;


@Service
public class EntryService {
    private final NamedParameterJdbcTemplate jdbc;
    private final UserService userService;

    private final EntryRepository entryRepository;

    @Autowired
    public UserRelationService userRelationService;

    @Autowired
    public EntryService(UserService userService, NamedParameterJdbcTemplate jdbc, EntryRepository entryRepository) {
        this.userService = userService;
        this.jdbc = jdbc;
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry, String username) {
        User user = userService.findUserByUsername(username);
        Entry oldEntry = entryRepository.findEntryByUserIdAndEntryDate(user, entry.getEntryDate());

        if (oldEntry != null) {
            oldEntry.setUserId(user);
            oldEntry.setContent(oldEntry.getContent() + "     " + entry.getContent());
            return entryRepository.save(oldEntry);
        } else {
            entry.setUserId(user);
            return entryRepository.save(entry);
        }
    }


    private Long findChildUserId(Long parentUserId) {
        User parentUser = userService.findUserByUserId(parentUserId);
        UserRelation userRelation = userRelationService.findChildUser(parentUser);

        if (userRelation == null) {
            throw new NotAParentException("You do not have parent access to any user!!");
        }
        return userRelation.getUserId().getUserId();

    }


    private Entry findYesterdayEntryByUserId(Long userId) {
        try {
            System.out.println(userId);
            SqlParameterSource parameters = getSqlParameterSource(userId);
            RowMapper<Entry> mapper = new RowMapper<Entry>() {
                @Override
                public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Entry entry = new Entry();
                    entry.setEntryId(rs.getLong("entry_id"));
                    entry.setEntryDate(rs.getDate("entry_date").toLocalDate());
                    entry.setContent(rs.getString("content"));
                    System.out.println(entry);
                    entry.setUserId(userService.findUserByUserId(rs.getLong("user_id")));
                    System.out.println(entry.getUserId());
                    return entry;
                }
            };
            List<Entry> entries = jdbc.query(SELECT_YESTERDAY_ENTRY_QUERY, parameters, mapper);
            return entries.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new EntryNotFoundException("No data was recorded yesterday!! Sorry");
        } catch (Exception e) {
            throw e;
        }
    }

    public Entry findChildYesterdayEntryByUserId(Long userId) {
        Long childUserId = findChildUserId(userId);
        System.out.println(childUserId);
        return findYesterdayEntryByUserId(childUserId);
    }

    public Entry findChildYesterdayEntryByUsername(String username) {
        User user = userService.findUserByUsername(username);
        Long childUserId = findChildUserId(user.getUserId());
        System.out.println(childUserId);
        return findYesterdayEntryByUserId(childUserId);
    }

    public List<Entry> findEntriesByUserId(Long userId) {
        User user = userService.findUserByUserId(userId);
        System.out.println(user);
        return entryRepository.findEntryByUserId(user);
    }

    public Entry findEntryByUsernameAndDate(String username, LocalDate date) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("No user found with username " + username);
        }
        System.out.println(user);
        return entryRepository.findEntryByUserIdAndEntryDate(user, date);
    }

    public List<Entry> findAllEntriesByUsername(String username) {
        User user = userService.findUserByUsername(username);
        return entryRepository.findEntryByUserId(user);
    }


    private SqlParameterSource getSqlParameterSource(Long userId) {
        return new MapSqlParameterSource()
                .addValue("userId", userId);
    }
}
