package centralregion.adminapi.test;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    http://localhost:9002/welcome 을 예상했지만
    http://localhost:9002/adminApi-service/welcome 을 찾는다.

 */
@RestController
@Slf4j
@RequestMapping("/adminApi-service")
public class FirstServiceController {

    Environment env;

    @Autowired // 4.3 버전부터 생성자가 하나 일 경우 @Autowired 를 명시하지 않아도 의존성 주입을 해줌
    public FirstServiceController(Environment env) {
        this.env = env;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First service.";
    }


    @GetMapping("/message")
    public String message(@RequestHeader("adminApi-request") String header) {
        log.info("header = " + header);
        return "Hello World in First Service";
    }

    @GetMapping("/check")
    public String cherck(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());
        return String.format("Hi, there. This is a message from First Service. On PORT %s", env.getProperty("local.server.port"));
    }
}
