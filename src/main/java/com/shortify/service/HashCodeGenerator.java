package com.shortify.service;

import org.springframework.stereotype.Component;

@Component
public class HashCodeGenerator {
    public long generateHashCode(String string) {
        return string.hashCode();
    }
}
