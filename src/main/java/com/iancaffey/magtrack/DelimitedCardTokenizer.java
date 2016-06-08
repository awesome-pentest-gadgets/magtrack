package com.iancaffey.magtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DelimitedCardTokenizer
 * <p>
 * An implementation of {@code CardTokenizer} which uses pairs of delimiters surrounding each track to break up the track segments.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DelimitedCardTokenizer implements CardTokenizer {
    private final char[] delimiters;

    /**
     * Constructs a new {@code DelimitedCardTokenizer} with specified pairs of delimiters.
     *
     * @param delimiters the pairs of delimiters to use during parsing
     */
    public DelimitedCardTokenizer(char... delimiters) {
        if (delimiters == null || delimiters.length % 2 != 0)
            throw new IllegalArgumentException();
        this.delimiters = delimiters;
    }

    /**
     * Returns the pairs of delimiters used during parsing.
     *
     * @return the parsing delimiter pairs
     */
    public char[] delimiters() {
        return Arrays.copyOf(delimiters, delimiters.length);
    }

    /**
     * Parses raw magnetic stripe card data into each track segment using each pair of delimiters to separate each track.
     * The delimiters are not included in the output.
     *
     * @param data the raw magnetic stripe card data
     * @return a {@code String[]} representing each track segment
     * @throws TrackParseException if the card data is malformed or unsupported
     */
    @Override
    public String[] tokenize(String data) throws TrackParseException {
        if (data == null || data.length() == 0)
            throw new IllegalArgumentException();
        char[] chars = data.toCharArray();
        if (delimiters.length == 0)
            return new String[]{data};
        List<String> tracks = new ArrayList<>(delimiters.length / 2);
        for (int i = 0, last = 0; last < chars.length && i < delimiters.length - 1; i += 2) {
            char start = delimiters[i];
            char end = delimiters[i + 1];
            int startIndex = data.indexOf(start, last);
            if (startIndex == -1)
                break;
            int endIndex = data.indexOf(end, startIndex + 1);
            if (endIndex == -1)
                endIndex = chars.length;
            if (endIndex - startIndex == 1)
                throw new TrackParseException("Empty track found between " + start + " and " + end + ".");
            char[] buffer = new char[endIndex - startIndex - 1];
            System.arraycopy(chars, startIndex + 1, buffer, 0, buffer.length);
            tracks.add(String.valueOf(buffer));
            last = endIndex;
        }
        if (tracks.isEmpty())
            throw new TrackParseException("No valid tracks found.");
        return tracks.toArray(new String[tracks.size()]);
    }
}
