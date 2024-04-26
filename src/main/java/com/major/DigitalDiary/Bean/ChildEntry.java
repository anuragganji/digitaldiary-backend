package com.major.DigitalDiary.Bean;

public class ChildEntry {
    private String message;

    public ChildEntry(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChildEntry{" +
                "message='" + message + '\'' +
                '}';
    }
}
