package com.jayoswal.springboot_exception_handling.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class ControllerException extends RuntimeException {

    private String code;
    private String message;

    public ControllerException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
