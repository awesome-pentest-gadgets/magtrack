package com.iancaffey.magtrack;

/**
 * Track
 * <p>
 * A representation of a single line of information on a magnetic stripe card.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Track {
    private final String data;

    /**
     * Constructs a new {@code Track} with specified data.
     *
     * @param data the data of the track
     */
    public Track(String data) {
        if (data == null)
            throw new IllegalArgumentException();
        this.data = data;
    }

    /**
     * Returns the track data.
     *
     * @return the track data
     */
    public String data() {
        return data;
    }

    /**
     * Returns the length of the track.
     *
     * @return the track length
     */
    public int length() {
        return data.length();
    }
}
