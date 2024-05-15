package org.mtracy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MBTAObject {
    private final JSONArray OBJECT;

    public MBTAObject (String url) throws Exception {
        URL api = new URL(url);
        HttpURLConnection con = (HttpURLConnection) api.openConnection();
        if (con.getResponseCode() != 200) {
            throw new RuntimeException("Rate Limit Exceeded");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        OBJECT = new JSONObject(response.toString()).getJSONArray("data");
    }

    public JSONObject getObject() {
        return OBJECT.getJSONObject(0);
    }

    public JSONObject getObject (int index) {
        return OBJECT.getJSONObject(index);
    }

    public Object getAttribute(String attribute) {
        return OBJECT.getJSONObject(0).getJSONObject("attributes").get(attribute);
    }

    public Object getAttribute(String attribute, int index) {
        return OBJECT.getJSONObject(index).getJSONObject("attributes").get(attribute);
    }

    public Object[] getAttributeArray(String attribute) {
        Object[] output = new Object[OBJECT.length()];
        for (int i = 0; i < OBJECT.length(); i++) {
            output[i] = getAttribute(attribute, i);
        }
        return output;
    }

    public int length () {
        return OBJECT.length();
    }
}
