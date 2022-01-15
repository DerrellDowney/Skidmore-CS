package edu.skidmore.cs226.patterns.facade;

import java.io.InputStream;

/**
 * Facade: Translated and fabricated book example (page 189)
 * <p>
 * Takes a stream of characters and produces a stream of tokens, one token at a
 * time. Functionality is not dealt with in the book example.
 * </p>
 * 
 * @author readda
 */
public class Scanner {
    @SuppressWarnings("unused")
    private InputStream inputStream;

    public Scanner(InputStream istream) {
        inputStream = istream;
    }

    public Token scan() {
        return Token.BEGIN;
    }
}
