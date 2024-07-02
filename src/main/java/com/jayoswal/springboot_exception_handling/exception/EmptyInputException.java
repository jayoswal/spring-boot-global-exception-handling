package com.jayoswal.springboot_exception_handling.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmptyInputException extends RuntimeException{

    private int code;
    private String message;

    public EmptyInputException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public  EmptyInputException(){

    }


}
