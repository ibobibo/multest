package dockerTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class SetupDockerGrid {
    @BeforeTest
    void startDockerGrid() throws IOException {
        Runtime.getRuntime().exec("./start_dockerGrid.sh");
        System.out.println("Docker initialized");
    }

//    @Test
//    void moreContainerDockerGrid() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("./moreContainer_dockerGrid.sh");
//        System.out.println("Docker scale more Browser");
//        Thread.sleep(15000);
//    }

    @AfterTest
    void stopDockerGrid() throws IOException {
        Runtime.getRuntime().exec("./stop_dockerGrid.sh");
        System.out.println("Docker shutdown");

        Runtime.getRuntime().exec("killall 'Terminal'");
        System.out.println("Close Terminal");
    }
}
