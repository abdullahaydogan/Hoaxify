package com.kou.muhtas2.demo.user.exceptions;

import com.kou.muhtas2.demo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;


public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super(Messages.getMessageForLocale("Muhtas2.activate.user.invalid.token", LocaleContextHolder.getLocale()));
    }

}
