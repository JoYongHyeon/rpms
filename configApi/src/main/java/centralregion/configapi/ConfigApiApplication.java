package centralregion.configapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApiApplication.class, args);
    }

}
