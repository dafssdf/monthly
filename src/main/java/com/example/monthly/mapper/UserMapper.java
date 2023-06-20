package com.example.monthly.mapper;

import com.example.monthly.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public void insert(UserDto userDto);

    public Long selectUserNumber(@Param("userId")String userId,
                                 @Param("userPassword")String userPassword);


    UserDto selectAll(Long userNumber);

    void updatePassword(UserDto userDto);

    void userWithdraw(Long userNumber);


}
