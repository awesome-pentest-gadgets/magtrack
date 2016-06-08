package com.iancaffey.magtrack;

/**
 * CardReader
 * <p>
 * An object capable of parsing raw magnetic stripe card data into a {@code Card}.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class CardReader {
    private final CardTokenizer tokenizer;
    public static final CardReader CREDIT_CARD = new CardReader(CardTokenizer.CREDIT_CARD);

    /**
     * Constructs a new {@code CardReader} for parsing and reading in raw credit card data.
     *
     * @return a new {@code CardReader} which parses and reads credit cards
     */
    public static CardReader creditCardReader() {
        return CREDIT_CARD;
    }

    /**
     * Constructs a new {@code CardReader} with a specified {@code CardTokenizer}.
     *
     * @param tokenizer the tokenizer to use when reading in card data to break up into each track segment
     */
    public CardReader(CardTokenizer tokenizer) {
        if (tokenizer == null)
            throw new IllegalArgumentException();
        this.tokenizer = tokenizer;
    }

    /**
     * Returns the tokenizer used when reading in card data to break it up into each track segment.
     *
     * @return the tokenizer used during reading
     */
    public CardTokenizer tokenizer() {
        return tokenizer;
    }

    /**
     * Reads in an entire magnetic stripe card data and parses it into a {@code Card}.
     *
     * @param data the string representing the entire magnetic stripe card data
     * @return a new {@code Card} if reading and parsing succeeds
     * @throws TrackParseException if parsing the track data fails
     */
    public Card read(String data) throws TrackParseException {
        return new Card(tokenizer.tokenize(data));
    }
}
