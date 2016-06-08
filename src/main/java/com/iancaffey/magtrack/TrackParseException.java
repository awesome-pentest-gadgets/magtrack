package com.iancaffey.magtrack;

/**
 * TrackParseException
 * <p>
 * An exception signifying track data that is malformed or the lack thereof.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TrackParseException extends Exception {
    /**
     * Constructs a new {@code TrackParseException} with no message.
     */
    public TrackParseException() {
    }

    /**
     * Constructs a new {@code TrackParseException} with a specified message.
     *
     * @param message the message of the exception
     */
    public TrackParseException(String message) {
        super(message);
    }
}
