package com.bridgelabz.indiancensusanalyser;

public class CustomException extends Exception{
    ExceptionType type;
    public CustomException(String message,ExceptionType type) {
        super(message);
        this.type=type;
    }

    enum ExceptionType{
        Parse_Error,File_Not_Found
    }
}
