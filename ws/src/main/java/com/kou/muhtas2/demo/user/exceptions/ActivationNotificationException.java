package com.kou.muhtas2.demo.user.exceptions;

import com.kou.muhtas2.demo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class ActivationNotificationException extends RuntimeException {
    public ActivationNotificationException() {
        super(Messages.getMessageForLocale("MuhTas2.create.user.email.failure", LocaleContextHolder.getLocale()));
    }

}
