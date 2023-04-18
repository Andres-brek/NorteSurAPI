package com.nortesur.nortesur.Api.Dtos;

import org.springframework.stereotype.Component;

import com.nortesur.nortesur.entidades.User;

@Component
public class UserMapper {
    
    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFullname(user.getFullname());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setBookings(user.getBooking());
        return userDto;
    }
    
    public static User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setFullname(userDto.getFullname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setBooking(userDto.getBookings());
        return user;
    }

    public static UserCreationDto toUserCreatedDto(User user) {
        UserCreationDto userCreationDto = new UserCreationDto();
        userCreationDto.setId(user.getId());
        userCreationDto.setFullname(user.getFullname());
        userCreationDto.setUsername(user.getUsername());
        userCreationDto.setPassword(user.getPassword());
        return userCreationDto;
    }

    public static User mapToEntity(UserCreationDto userCreationDto) {
        User user = new User();
        user.setFullname(userCreationDto.getFullname());
        user.setUsername(userCreationDto.getUsername());
        user.setPassword(userCreationDto.getPassword());
        return user;
    }

}
