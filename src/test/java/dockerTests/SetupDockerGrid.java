package dockerTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SetupDockerGrid {
    @BeforeTest
    void startDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/start_dockerGrid.sh");
        System.out.println("Docker initialized");
        Thread.sleep(15000);
    }

    @Test
    void moreContainerDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/moreContainer_dockerGrid.sh");
        System.out.println("Docker scale more Browser");
        Thread.sleep(15000);
    }
    @AfterTest
    void stopDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/stop_dockerGrid.sh");
        System.out.println("Docker shutdown");
        Thread.sleep(5000);

        Runtime.getRuntime().exec("killall 'Terminal'");
        System.out.println("Close Terminal");
    }
}
