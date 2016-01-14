package com.shortify.service;

import org.springframework.stereotype.Component;

@Component
public class Shortifier {

    private final String host;
    private final String alphabet;

    public Shortifier(String host, String alphabet) {
        this.host = host;
        this.alphabet = alphabet;
    }

    public String generateShortenUrl(long hashCode) {
        StringBuilder sb = new StringBuilder(host);
        sb.append("/");

        while (hashCode != 0) {
            char nextCharacter = alphabet.charAt(Math.abs((int) (hashCode % alphabet.length())));
            sb.append(nextCharacter);
            hashCode = hashCode / 62;
        }
        return sb.toString();
    }
}
