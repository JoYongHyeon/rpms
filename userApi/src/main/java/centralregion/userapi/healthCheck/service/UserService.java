package centralregion.userapi.healthCheck.service;

import centralregion.userapi.healthCheck.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
}
