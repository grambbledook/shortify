package com.shortify;

import org.springframework.stereotype.Component;

@Component
public class ShortUrlGenerator {

    private final String host;
    private final String alphabet;

    public ShortUrlGenerator(String host, String alphabet) {
        this.host = host;
        this.alphabet = alphabet;
    }

    public String generateId(long hashCode) {
        StringBuilder sb = new StringBuilder();
        while (hashCode != 0) {
            char nextCharacter = alphabet.charAt(Math.abs((int) (hashCode % alphabet.length())));
            sb.append(nextCharacter);
            hashCode = hashCode / 62;
        }
        return sb.toString();
    }

    public String fromId(String id) {
        return host + "/" + id;
    }
}
