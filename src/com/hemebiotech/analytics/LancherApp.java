package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class LancherApp {
    private static String fileInPath;
    private static String fileOutPath;

    public static void main(String[] args) throws Exception {
        loadConfig();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(fileInPath,fileOutPath);
        List<String> symptoms = analyticsCounter.readSymptoms();
        analyticsCounter.calculateNbreOfSymptoms(symptoms);
        analyticsCounter.writeSymptomsOut();

    }

    private static void loadConfig() throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = LancherApp.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            fileInPath = prop.getProperty("file.name.in.path");
            fileOutPath = prop.getProperty("file.name.out.path");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }


}