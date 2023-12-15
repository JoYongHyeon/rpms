package centralregion.userapi.healthCheck.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class GreetingVo {

    @Value("${greeting.message}")
    private String message;

}
