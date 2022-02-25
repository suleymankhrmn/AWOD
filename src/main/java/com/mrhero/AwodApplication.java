package com.mrhero;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AwodApplication {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) {
        /*final Runnable beeper = new Runnable() {
            public void run() {
                System.out.println("start");
                DownloadUtil.downloadImage();
                System.out.println("finish");
            }
        };

        scheduler.scheduleAtFixedRate(beeper,20,20, TimeUnit.SECONDS);*/

        AwodApplication awodApplication = new AwodApplication();
        awodApplication.waitMethod();
    }

    private synchronized void waitMethod() {
        while (true) {
            try {
                String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
                System.out.println(rootPath);
               /* new Thread(()->{
                    DownloadUtil.downloadImage();
                }).start();*/
                DownloadUtil.downloadImage();

                this.wait(1200000);
                System.out.println("try");

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }
}
