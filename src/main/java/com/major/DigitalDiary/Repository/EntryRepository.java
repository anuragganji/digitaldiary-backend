package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.Entry;
import com.major.DigitalDiary.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EntryRepository extends JpaRepository<Entry,Long> {
    Entry findEntryByEntryId(Long entryId);
    List<Entry> findEntryByUserId(User user);
    Entry findEntryByUserIdAndEntryDate(User user, LocalDate date);
    Entry findEntryByEntryDate(LocalDate date);
}
