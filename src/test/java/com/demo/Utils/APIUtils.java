package com.demo.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class APIUtils {

    public String ExecuteGetRequest(String URL) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String result = "";

        try {

            HttpGet request = new HttpGet(URL);
            CloseableHttpResponse response = httpClient.execute(request);

            try {
                // Get HttpResponse Status
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    result = EntityUtils.toString(entity);
                    System.out.println(result);
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }

        return result;
    }

    public JSONObject convertHTTPResponseToJSON(String response) {
        //Convert String to JSON
        JSONObject jo = new JSONObject(response);

        return jo;
    }
}
