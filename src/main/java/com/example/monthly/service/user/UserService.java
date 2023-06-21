package com.example.monthly.service.user;

import com.example.monthly.dto.UserDto;
import com.example.monthly.mapper.UserMapper;
import com.example.monthly.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserMapper userMapper;

    // 회원 가입
    public void register(UserVo userVo){
        if (userVo == null){ throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음"); }
        userMapper.insert(userVo);
    }

    // 가입 후 기본 정보 출력
    public UserDto showJoin(UserDto userDto){
        if (userDto == null) {
            throw new IllegalArgumentException("회원 가입 오류 발생(번호 없음)");
        }
        return userMapper.showJoinInfo(userDto);
    }


    //회원번호로 회원 전체 조회
    public UserDto findAll(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return userMapper.selectAll(userNumber);
    }

    //비밀번호 수정
    public void updatePassword(UserDto userDto){
        if (userDto == null) {
            throw new IllegalArgumentException("비밀번호, 회원 번호 누락");
        }
        userMapper.updatePassword(userDto);
    }

    //회원 상태 변경
    public void changeStatus(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        userMapper.userWithdraw(userNumber);
    }

}
