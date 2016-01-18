package com.shortify;

import org.springframework.stereotype.Component;

@Component
public class JavaHashCodeGenerator implements HashCodeGenerator {
    @Override
    public long generateHashCode(String string) {
        long hash = 0;

        for (int i = 0; i < string.length(); i++) {
            hash = 31 * hash + string.charAt(i);
        }

        return hash;
    }
}
