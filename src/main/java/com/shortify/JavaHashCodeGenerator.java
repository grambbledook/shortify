package com.shortify;

import org.springframework.stereotype.Component;

@Component
public class JavaHashCodeGenerator implements HashCodeGenerator {
    @Override
    public long generateHashCode(String string) {
        return string.hashCode();
    }
}
