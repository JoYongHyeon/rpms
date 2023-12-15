package centralregion.userapi.healthCheck.controller;

import centralregion.userapi.healthCheck.dto.UserDto;
import centralregion.userapi.healthCheck.service.UserService;
import centralregion.userapi.healthCheck.vo.GreetingVo;
import centralregion.userapi.healthCheck.vo.RequestUserVo;
import centralregion.userapi.healthCheck.vo.ResponseUserVo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    // yml 파일 가져오기 방법 (1/2)
//    private final Environment env;

    // yml 파일 가져오기 방법 (1/2)
    private final GreetingVo greetingVo;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        // yml 파일 가져오기 방법 1
//        return env.getProperty("greeting.message");
        // yml 파일 가져오기 방법 2
        return greetingVo.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUserVo> createUser(@RequestBody RequestUserVo user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUserVo responseUserVo = mapper.map(userDto, ResponseUserVo.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUserVo);
    }
}
