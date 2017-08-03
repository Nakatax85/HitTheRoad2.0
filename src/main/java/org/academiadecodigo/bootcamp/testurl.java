package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.TravelDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by codecadet on 28/07/2017.
 */
public class testurl {

    public static void main(String[] args) throws IOException {

        TravelDistance travelDistance = new TravelDistance();

        while (true) {


            Scanner bla = new Scanner(System.in);
            String origem = bla.nextLine();
            String line, outputString = "";


            Scanner blabla = new Scanner(System.in);
            String destino = blabla.nextLine();

            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origem + "&destinations=" + destino + "&mode=walking");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }

            System.out.println(outputString);
        }

    }


}
