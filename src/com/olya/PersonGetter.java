package com.olya;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class PersonGetter {

        
    static final String DATA = "data";
    static final String LAST = "last_name";
    static final String FIRST = "first_name";
    
    private String json;

    PersonGetter(String json) {
        this.json = json;
    }

    public Person parsePerson(String json) {

        Person person = null;

        try {
            JSONObject obj = new JSONObject(Objects.requireNonNull(json));
            String lastName1 = obj.getJSONObject(DATA).getString(LAST);
            String firstName1 = obj.getJSONObject(DATA).getString(FIRST);
            person = new Person(firstName1, lastName1);

        } catch (JSONException e) {
            System.out.println("Error on parse data in JSONParser.java");
        } catch (NullPointerException e) {
            System.out.println("Null pointer");
        }
        return person;
    }
}
