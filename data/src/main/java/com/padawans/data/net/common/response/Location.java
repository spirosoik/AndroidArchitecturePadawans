package com.padawans.data.net.common.response;

import java.io.Serializable;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public class Location implements Serializable {

    public String address;
    public float lat;
    public float lng;
    public int distance;
    public String city;
    public String country;

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("address='").append(address).append('\'');
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", distance=").append(distance);
        sb.append(", city='").append(city).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
