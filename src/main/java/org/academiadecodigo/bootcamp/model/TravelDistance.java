package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.persistence.SuppliesCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TravelDistance {

    private static String originDestiny;
    private static String finalOrigin;
    private static String finalDestiny;
    private static int numberOfDays;
    private static int kilometres;

    public static void distance(String origin, String destiny) {

        try {

            originDestiny = origin + destiny;

            String line, outputString= "";
            String commaRemove = "";

            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destiny + "&mode=walking");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }

            System.out.println(outputString);

            String[] result = outputString.split("\"text\" : \"");

            String endResult[] = result[1].split(" ");

            if(endResult[0].length() > 3) {
                commaRemove = endResult[0].replace(",", "");
            } else {
                commaRemove = endResult[0];
            }

            Double km = Double.parseDouble(commaRemove);
            kilometres = km.intValue();
            km = Math.ceil(km / 30);

            int numOfDays = km.intValue();

            SuppliesCalculator.setNumberOfDays(numOfDays);

            finalOrigin = origin;
            finalDestiny = destiny;

            numberOfDays = numOfDays;

            SuppliesCalculator.setNumberOfDays(numberOfDays);


        } catch (IOException err) {
        } catch (ArrayIndexOutOfBoundsException err) {
        }
    }

    public static String getOriginDestiny() {
        return originDestiny;
    }


    public static String getFinalOrigin() {
        return finalOrigin;
    }

    public static String getFinalDestiny() {
        return finalDestiny;
    }

    public static int getNumberOfDays() {
        return numberOfDays;
    }

    public static int getKilometres() {
        return kilometres;
    }

    public static void setFinalOrigin(String finalOrigin) {
        TravelDistance.finalOrigin = finalOrigin;
    }

    public static void setFinalDestiny(String finalDestiny) {
        TravelDistance.finalDestiny = finalDestiny;
    }
    public static void setOriginDestiny() {
        originDestiny = "";
    }

}
