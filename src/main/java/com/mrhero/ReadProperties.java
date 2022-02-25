package com.mrhero;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadProperties {
    private static ReadProperties readProperties;
    private List<Properties> propertiesList;

    private ReadProperties() {
        propertiesList = new ArrayList<>();
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File file = new File(rootPath);
        File[] files = file.listFiles();
        for (File f:files) {
            Properties props = new Properties();
            try {
                props.load(new FileInputStream(f.getPath()));
                propertiesList.add(props);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ReadProperties getInstance(){
        if(readProperties == null){
            readProperties = new ReadProperties();
        }
        return readProperties;
    }

    public String getValue(String key){
        String value = "";
        for (Properties properties: propertiesList) {
           // todo add contains
            String property = properties.getProperty(key);
            if (property != null){
                value = property;
                break;
            }
        }
        return value;
    }
}
