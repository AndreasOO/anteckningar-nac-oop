package OOP.Sprint3.Uppgift14;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
            Properties properties = new Properties();
            try {
                properties.load(new FileReader("src/OOP/Sprint3/Uppgift14/url-settings.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String url = properties.getProperty("url","");
            URLReader urlReader = new URLReader(url);
            urlReader.readURL();

    }

}
