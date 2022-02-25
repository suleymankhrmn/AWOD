package com.mrhero;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class Try1 {
    public static void main(String[] args) {
        try {
            BackgroundUtil.changeBackground();
            /*ReadProperties readProperties = ReadProperties.getInstance();
            String version = readProperties.getValue("version");

            System.out.println(version);


            URL url = new URL("https://apod.nasa.gov/apod/image/2201/noirlab2204a.jpg");*/
           /* HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }*/


          /*  String path = "noirlab2204a.jpg";
            BufferedImage read = ImageIO.read(url);
            ImageIO.write(read, "jpg", new File(path));*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
