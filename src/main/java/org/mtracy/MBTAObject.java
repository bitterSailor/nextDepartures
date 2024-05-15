package org.mtracy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MBTAObject {
    private final JSONArray OBJECT;

    // Constructor
    public MBTAObject (String url) throws Exception {
        // Retrieves API call from url
        URL api = new URL(url);
        HttpURLConnection con = (HttpURLConnection) api.openConnection();
        if (con.getResponseCode() != 200) { // Checks for valid response and throws exception if rate limit is exceeded
            throw new RuntimeException("Rate Limit Exceeded");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // Saves JSON array to object
        OBJECT = new JSONObject(response.toString()).getJSONArray("data");
    }

    // Retrieves Object at index i
    public JSONObject getObject() {
        return OBJECT.getJSONObject(0);
    }
    public JSONObject getObject (int index) {
        return OBJECT.getJSONObject(index);
    }

    // Retrieves attribute at index i
    public Object getAttribute(String attribute) {
        return OBJECT.getJSONObject(0).getJSONObject("attributes").get(attribute);
    }
    public Object getAttribute(String attribute, int index) {
        return OBJECT.getJSONObject(index).getJSONObject("attributes").get(attribute);
    }

    // Retrieves an array of attribute
    public Object[] getAttributeArray(String attribute) {
        Object[] output = new Object[OBJECT.length()];
        for (int i = 0; i < OBJECT.length(); i++) {
            output[i] = getAttribute(attribute, i);
        }
        return output;
    }

    // Returns length of array
    public int length () {
        return OBJECT.length();
    }
}
