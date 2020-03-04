package dockerTests;

import org.testng.annotations.*;
import resources.BaseClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;
import java.lang.IllegalArgumentException;

public class SetupDockerGrid extends BaseClass {
    @BeforeSuite
    void startDockerGrid() throws IOException, InterruptedException {
        Process proc =  Runtime.getRuntime().exec("./start_dockerGrid.sh");
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));
        String hubAddress = "";
        String s;
        while ((s = stdInput.readLine()) != null) {
            hubAddress = hubAddress + s;
            System.out.println("start_dockerGrid output: " + s);
        }
        String IPADDRESS_PATTERN =
                "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(hubAddress);
        if (matcher.find()) {
            hubAddress = matcher.group();
        } else {
            throw new IllegalArgumentException("No ip-address for selenium-hub found. Is it running properly?");
        }

        System.out.println("Selenium-hub running at: " + hubAddress);
        BaseClass.hubAddress = hubAddress;
        Process test = Runtime.getRuntime().exec("ping host.docker.internal");
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(test.getInputStream()));
        String j;
        while ((j = reader.readLine()) != null) {
            System.out.println(j);
        }
        System.out.println("Docker initialized");
        Thread.sleep(15000);
    }

    @AfterSuite
    void stopDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("./stop_dockerGrid.sh");
        System.out.println("Docker shutdown");
        Thread.sleep(5000);

        Runtime.getRuntime().exec("killall 'Terminal'");
        System.out.println("Close Terminal");
    }

}
