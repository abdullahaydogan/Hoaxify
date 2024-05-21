package com.kou.muhtas2.demo.auth.exception;

import com.kou.muhtas2.demo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super(Messages.getMessageForLocale("muhtas2.auth.invalid.credentials", LocaleContextHolder.getLocale()));
    }

}
