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
public class Card implements Iterable<Track> {
    private final Track[] tracks;

    /**
     * Constructs a new {@code Card} with a group of tracks.
     *
     * @param tracks the tracks representing the entire magnetic stripe card
     */
    public Card(Track... tracks) {
        if (tracks == null || tracks.length == 0)
            throw new IllegalArgumentException();
        this.tracks = tracks;
    }

    /**
     * Constructs a new {@code Card} with a group of strings representing track data.
     *
     * @param tracks the strings to use in representing magnetic stripe card tracks
     * @return a {@code Card} consisting of the specified tracks
     */
    public static Card valueOf(String... tracks) {
        if (tracks == null || tracks.length == 0)
            throw new IllegalArgumentException();
        Track[] t = new Track[tracks.length];
        for (int i = 0; i < tracks.length; i++)
            t[i] = new Track(tracks[i]);
        return new Card(t);
    }

    /**
     * Returns a specific track within the magnetic stripe card.
     *
     * @param index the index of the track
     * @return the track at the specified index
     */
    public Track track(int index) {
        return tracks[index];
    }

    /**
     * Returns all tracks which represent the magnetic stripe card.
     *
     * @return all magnetic stripe card tracks
     */
    public Track[] tracks() {
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
    public Iterator<Track> iterator() {
        return new Iterator<Track>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < tracks.length;
            }

            @Override
            public Track next() {
                return tracks[index++];
            }
        };
    }
}
