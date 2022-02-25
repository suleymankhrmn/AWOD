package com.mrhero;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestUtil {
    public static <T> T request(RequestParams requestParams){
        try {
           URL url = new URL(requestParams.getUrl());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestParams.getMethod());
            con.setRequestProperty("Content-Type", "application/json");
            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
