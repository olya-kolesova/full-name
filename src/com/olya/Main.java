package com.olya;

import java.util.Objects;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;


public class Main {

    public static void main(String[] args) {
        System.out.println("Insert the number of person id from 1 to 12, please.");
        Scanner scanner = new Scanner(System.in);
        String idNum = scanner.next();
        static final String URL = "https://reqres.in/api/users?id=";
    	String url = URL + idNum;

        Parser parser = new Parser(url);

        String json = parser.getJSON(url);

        PersonGetter personGetter = new PersonGetter(json);

        String firstName = personGetter.parsePerson(json).getFirstName();
        String lastName = personGetter.parsePerson(json).getLastName();

        System.out.println(firstName + " " + lastName);

    }
}
