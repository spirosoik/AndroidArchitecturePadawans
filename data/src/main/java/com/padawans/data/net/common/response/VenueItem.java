package com.padawans.data.net.common.response;

import java.io.Serializable;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public class VenueItem implements Serializable {

    public Venue venue;

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("venue=").append(venue);
        sb.append('}');
        return sb.toString();
    }
}
