package com.iancaffey.magtrack;

/**
 * CardTokenizer
 * <p>
 * An object which breaks up an entire magnetic stripe card read into each trac segment.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface CardTokenizer {
    public static final CardTokenizer CREDIT_CARD = new DelimitedCardTokenizer('%', '?', ';', '?', ';', '?');

    /**
     * Constructs a new {@code CardTokenizer} with delimiters '%', '?', ';', '?', ';', '?', which are used in pairs to
     * denote the start and end of each track segment for credit cards.
     *
     * @return a new {@code CardTokenizer} designed to parse credit card data
     */
    public static CardTokenizer creditCardTokenizer() {
        return CREDIT_CARD;
    }

    /**
     * Parses raw magnetic stripe card data into each track segment.
     *
     * @param data the raw magnetic stripe card data
     * @return a {@code String[]} representing each track segment
     * @throws TrackParseException if the card data is malformed or unsupported
     */
    public String[] tokenize(String data) throws TrackParseException;
}
