package com.major.DigitalDiary.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "entries", uniqueConstraints = @UniqueConstraint(columnNames = {"entry_date", "user_id"}))
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    // Constructors, getters, and setters

    @PrePersist
    protected void onCreate() {
        this.entryDate = LocalDate.now();
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryId=" + entryId +
                ", entryDate=" + entryDate +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }
}

