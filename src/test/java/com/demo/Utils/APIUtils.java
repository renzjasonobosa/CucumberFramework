package com.demo.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class APIUtils {

    public void ExecuteGetRequest(String URL) throws IOException {
        //Setting up the Registration POST Request
        URL getRequestUrl = new URL(URL);
        HttpURLConnection getRequest = (HttpURLConnection) getRequestUrl.openConnection();
        getRequest.setRequestMethod("GET");

        //Get and print the response code of the Registration POST Request
        int responseCode = getRequest.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);

        BufferedReader input = new BufferedReader(new InputStreamReader(getRequest.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = input.readLine()) != null){
            response.append(inputLine);
        }
        input.close();
        // Print Registration POST Response
        System.out.println(response.toString());
    }
}
