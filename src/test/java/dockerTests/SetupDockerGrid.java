package dockerTests;

import org.testng.annotations.*;
import resources.BaseClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetupDockerGrid extends BaseClass {
    @BeforeSuite
    void startDockerGrid() throws IOException, InterruptedException {
        Process proc =  Runtime.getRuntime().exec("./start_dockerGrid.sh");
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));
        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
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
