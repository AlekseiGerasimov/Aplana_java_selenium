package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static Properties properties = new Properties();
    private static TestProperties testProperties = null;
    private TestProperties() {
        try {
            properties.load(new FileInputStream(new File("./application.properties")));
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static TestProperties getinstance(){
        if(testProperties==null){
            testProperties = new TestProperties();
        }
        return testProperties;
    }

    public Properties getProperties(){
        return properties;
    }
}
