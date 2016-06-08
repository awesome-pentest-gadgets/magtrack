package com.iancaffey.magtrack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Card
 * <p>
 * A representation of a magnetic stripe card which consists of tracks of data.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Card implements Iterable<String> {
    private final String[] tracks;

    /**
     * Constructs a new {@code Card} with a group of tracks.
     *
     * @param tracks the tracks representing the entire magnetic stripe card
     */
    public Card(String... tracks) {
        if (tracks == null || tracks.length == 0)
            throw new IllegalArgumentException();
        this.tracks = tracks;
    }

    /**
     * Returns a specific track within the magnetic stripe card.
     *
     * @param index the index of the track
     * @return the track at the specified index
     */
    public String track(int index) {
        return tracks[index];
    }

    /**
     * Returns all tracks which represent the magnetic stripe card.
     *
     * @return all magnetic stripe card tracks
     */
    public String[] tracks() {
        return Arrays.copyOf(tracks, tracks.length);
    }

    /**
     * Returns the number of tracks representing the magnetic stripe card.
     *
     * @return the number of magnetic stripe card tracks
     */
    public int size() {
        return tracks.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < tracks.length;
            }

            @Override
            public String next() {
                return tracks[index++];
            }
        };
    }
}
