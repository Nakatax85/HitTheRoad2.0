package org.academiadecodigo.bootcamp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleAPIs {

    public static String mapsTravel(String origin, String destiny, TravelMode mode) {

        String line;
        String outputString= "";

        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destiny + "&mode=" + mode);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }

        return outputString;
    }

    public enum TravelMode{
        BICYCLE("bicycling"),
        WALKING("walking"),
        CAR("driving");

        String mode;

        TravelMode(String mode) {
            this.mode = mode;
        }
    }
}
