package com.github.chaoswang.work.java.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesOperator {
    
    private final String filePath;
    private final Properties properties;

    public PropertiesOperator(String filePath) {
        this.filePath = filePath;
        this.properties = load(filePath);
    }

    private Properties load(String filePath) {
        Properties props = new Properties();
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
        } catch (Exception e) {
//            log.warn("failed to load file: " + filePath, e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
//                    log.warn("failed to close file: " + filePath, e);
                }
            }
        }

        return props;
    }

    public Properties getProperties() {
        return properties;
    }

    public String read(String parameterName) {
        return properties.getProperty(parameterName);
    }

    public void store(String parameterName, String parameterValue) {
        ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>(
                1);
        Pair<String, String> pair = new Pair<String, String>(parameterName,
                parameterValue);
        pairs.add(pair);
        store(pairs);
    }

    public void store(List<Pair<String, String>> pairs) {
        for (Pair<String, String> pair : pairs) {
            properties.setProperty(pair.getKey(), pair.getValue());
        }

        try {
            properties.store(new FileOutputStream(filePath), "update");
        } catch (Exception ex) {
//            log.warn("failed to update properties file, filePath: "
//                    + filePath, ex);
        }
    }

    public void clearKeys(String... keys) {
        for (String key : keys) {
            properties.remove(key);
        }

        try {
            properties.store(new FileOutputStream(filePath), "clear");
        } catch (Exception ex) {
//            log.warn("failed to clear properties keys, filePath: "
//                    + filePath, ex);
        }
    }
}
