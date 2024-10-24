package OOP.Sprint3.Uppgift14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class URLReader {
    private final String urlString;

    public URLReader(String urlString) {
        this.urlString = urlString;
    }

    public void readURL() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URI(urlString).toURL().openStream()))) {
            Map<Integer,Integer> map = new HashMap<>();
            String line = reader.readLine();
            while (line != null) {
                map.put(line.length(), map.getOrDefault(line.length(), 0) + 1);
                line = reader.readLine();
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println("Words with " + entry.getKey() + " letters: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
