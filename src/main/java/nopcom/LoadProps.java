package nopcom;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProps {
    static Properties props;
    static FileInputStream inputStream;
    public String getproperty(String key){
        props = new Properties();
        try{
            inputStream = new FileInputStream("src\\main\\Resources\\textdataconfig.properties");
            props.load(inputStream);
            inputStream.close();
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
        return props.getProperty(key);
    }


}
