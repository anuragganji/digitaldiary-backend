package com.major.DigitalDiary.Exception;

public class NotAParentException extends RuntimeException{
    public NotAParentException(String message){
        super(message);
    }
    public NotAParentException(){}
}
