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
        final String URL = "https://reqres.in/api/users?id=";
	    String url = URL + idNum;

        Parser parser = new Parser(url);

        String json = parser.getJSON(url);

        try {
            JSONObject obj = new JSONObject(Objects.requireNonNull(json));
            String lastName1 = obj.getJSONObject("data").getString("last_name");
            String firstName1 = obj.getJSONObject("data").getString("first_name");
            Person person = new Person(firstName1, lastName1);
            System.out.println(person.getFirstName() + " " + person.getLastName());

        } catch (JSONException e) {
            System.out.println("Error on parse data in JSONParser.java");
        } catch (NullPointerException e) {
            System.out.println("Null pointer");
        }

    }
}
