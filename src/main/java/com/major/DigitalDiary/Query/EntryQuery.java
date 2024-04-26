package com.major.DigitalDiary.Query;

public class EntryQuery {
    public static final String SELECT_YESTERDAY_ENTRY_QUERY="SELECT * FROM entries WHERE user_id = :userId AND entry_date = DATE_SUB(CURDATE(), INTERVAL 1 DAY)";
    public static final String FIND_CHILD_USER_ID="SELECT user_id FROM users WHERE parent_user_id = :userId";
}
