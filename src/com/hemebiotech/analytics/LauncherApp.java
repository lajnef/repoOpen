package com.hemebiotech.analytics;

import com.hemebiotech.analytics.service.AnalyticsCounterService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Main Class allows to launch application
 */
public class LauncherApp {
    private static String fileInPath;
    private static String fileOutPath;

    public static void main(String[] args) throws Exception {
        loadConfig();
        AnalyticsCounterService analyticsCounterService = new AnalyticsCounterService(fileInPath,fileOutPath);
        List<String> symptoms = analyticsCounterService.readSymptoms();
        analyticsCounterService.calculateNbreOfSymptoms(symptoms);
        analyticsCounterService.writeSymptomsOut();

    }

    /**
     * load  input and output file path
     * @throws IOException
     */
    private static void loadConfig() throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = LauncherApp.class.getClassLoader().getResourceAsStream(propFileName);

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