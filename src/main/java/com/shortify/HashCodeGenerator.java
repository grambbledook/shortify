package com.shortify;

import org.springframework.stereotype.Component;

@Component
public class HashCodeGenerator {
    public long generateHashCode(String string) {
        return string.hashCode();
    }
}
