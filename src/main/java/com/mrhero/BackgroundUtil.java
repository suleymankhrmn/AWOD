package com.mrhero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackgroundUtil {
    public static void changeBackground(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        String file = "file:////home/mrhero/Downloads/HOOClassicBinned_ps2048.jpg";
        String command = "gsettings set org.gnome.desktop.background picture-uri " + file;

        processBuilder.command("bash", "-c", command);
        try {
            Process process = processBuilder.start();
            getOutput(process);
            process.waitFor();



            System.out.println("Complete");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void getOutput(Process process) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        String result = builder.toString();
        System.out.println("result" + result);
    }
}
