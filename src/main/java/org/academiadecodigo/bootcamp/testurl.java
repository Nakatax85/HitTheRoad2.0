package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.utils.GoogleAPIs;
import java.io.IOException;
import java.util.Scanner;

public class testurl {

    public static void main(String[] args) throws IOException {

        while (true) {


            Scanner bla = new Scanner(System.in);
            String origem = bla.nextLine();
            String line, outputString = "";

            Scanner blabla = new Scanner(System.in);
            String destino = blabla.nextLine();

            String result = GoogleAPIs.mapsTravel(origem,destino, GoogleAPIs.TravelMode.CAR);

            System.out.println(result);
        }

    }


}
