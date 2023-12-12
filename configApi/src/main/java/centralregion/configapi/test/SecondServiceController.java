package centralregion.configapi.test;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/configApi-service")
public class SecondServiceController {

    Environment env;

    @Autowired // 4.3 버전부터 생성자가 하나 일 경우 @Autowired 를 명시하지 않아도 의존성 주입을 해줌
    public SecondServiceController(Environment env) {
        this.env = env;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Second service.";
    }


    @GetMapping("/message")
    public String message(@RequestHeader("configApi-request") String header) {
        log.info("header = " + header);
        return "Hello World in Second Service";
    }

    @GetMapping("/check")
    public String cherck(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());
        return String.format("Hi, there. This is a message from Second Service. On PORT %s", env.getProperty("local.server.port"));
    }
}
