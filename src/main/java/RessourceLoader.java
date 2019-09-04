import com.relevantcodes.extentreports.model.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

//herausfinden wie ich daten von den properties auslesen kann ohne den ganzen classpath anzugeben !
public class RessourceLoader {
    public static void main(String args[]) {
        URL resourceURL = Test.class.getResource("properties/browserData.properties");
        Properties x = new Properties();
        try {
            x.load(resourceURL.openStream());
            System.out.println(x.getProperty("browser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
