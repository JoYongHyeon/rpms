package centralregion.userapi.healthCheck.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUserVo {

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    private String email;

    @NotNull(message = "name cannot be null")
    @Size(min = 8, message = "Name not be less than two characters")
    private String name;

    @NotNull(message = "Password cannot be null")
    @Size(min = 2, message = "Password must be equal or grater than 8 characters and less than 16 characters")
    private String pwd;

}
