package dockerTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SetupDockerGrid {
    @BeforeTest
    void startDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("./start_dockerGrid.sh");
        System.out.println("Docker initialized");
        TimeUnit.SECONDS.sleep(15);

    }

//    @Test
//    void moreContainerDockerGrid() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("./moreContainer_dockerGrid.sh");
//        System.out.println("Docker scale more Browser");
//        Thread.sleep(15000);
//    }

    @AfterTest
    void stopDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("./stop_dockerGrid.sh");
        System.out.println("Docker shutdown");
        TimeUnit.SECONDS.sleep(5);

        Runtime.getRuntime().exec("killall 'Terminal'");
        System.out.println("Close Terminal");
    }
}
