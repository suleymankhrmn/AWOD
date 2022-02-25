package com.mrhero;

import com.google.gson.Gson;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DownloadUtil {
    public static void downloadImage(){
        URL url = null;
        try {
            /*url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            int status = con.getResponseCode();
            System.out.println("status=> " + status);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }*/

            String content = "{\"date\":\"2022-01-21\",\"explanation\":\"Laser guide stars and adaptive optics sharpened this stunning ground-based image of stellar jets from the Gemini South Observatory, Chilean Andes, planet Earth. These twin outflows of MHO 2147 are from a young star in formation. It lies toward the central Milky Way and the boundary of the constellations Sagittarius and Ophiuchus at an estimated distance of some 10,000 light-years. At center, the star itself is obscured by a dense region of cold dust. But the infrared image still traces the sinuous jets across a frame that would span about 5 light-years at the system's estimated distance. Driven outward by the young rotating star, the apparent wandering direction of the jets is likely due to precession. Part of a multiple star system, the young star's rotational axis would slowly precess or wobble like a top under the gravitation influence of its nearby companions.\",\"hdurl\":\"https://apod.nasa.gov/apod/image/2201/noirlab2204a.jpg\",\"media_type\":\"image\",\"service_version\":\"v1\",\"title\":\"Young Star Jet MHO 2147\",\"url\":\"https://apod.nasa.gov/apod/image/2201/noirlab2204a_1024.jpg\"}";

            Gson gson = new Gson();
            ImageContent imageContent = gson.fromJson(content.toString(), ImageContent.class);

            writeImage(imageContent.getHd_url());


            /*System.out.println("response body=> " + content.toString());
            in.close();*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeImage(String imageUrl) throws IOException {
        String[] strings = imageUrl.split("/");
        String path = strings[strings.length - 1];
        String[] filenames = path.split("\\.");
        String type = filenames[filenames.length-1];

        URL url = new URL(imageUrl);
        BufferedImage read = ImageIO.read(url);
        ImageIO.write(read, type, new File("/home/mrhero/Desktop/test/"+path));
    }
}
