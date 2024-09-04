package com.lsj.springbasic.service.implement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lsj.springbasic.dto.PostUserRequestDto;
import com.lsj.springbasic.dto.SignInRequestDto;
import com.lsj.springbasic.entity.SampleUserEntity;
import com.lsj.springbasic.provider.JwtProvider;
import com.lsj.springbasic.repositoy.SampleUserRepository;
import com.lsj.springbasic.service.AuthService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


// spring bean 등록
@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    private final SampleUserRepository sampleUserRepository;
    private final JwtProvider jwtProvider;

    // PasswordEncoder 인터페이스 
    // 비밀번호를 안전하고 쉽게 암호화 하여 관리할 수 있도록 하는 도움주는 인터페이스 
    // - 구현체 (세가지 존재)
    // - BCryptPassworEncoder, SCryptPasswordEncoder, Pbkdf2PasswordEncoder
    // - String encode(평문 비밀번호): 평문 비밀번호를 암호화 하여 반환
    // - boolean matches(평문 비밀번호, 암호화 된 비밀번호) : 평문 비밀번호와 암호화 된 비밀번호가 일치하는지 여부를 반환
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 실제 비지니스 작업 이루어질 영역 (비지니스 로직)
    @Override
    public String signUp(PostUserRequestDto dto) {

        

        try {

            String userId = dto.getUserId();
            boolean isExiststed = sampleUserRepository.existsByUserId(userId);
            if (isExiststed) return "존재하는 아이디!";

            String telNumber = dto.getTelNumber();
            boolean isExistedTelnumber = sampleUserRepository.existsByTelNumber(telNumber);
            if (isExistedTelnumber) return "존재하는 전화번호!";

            // String password = dto.getPassword();
            // String name = dto.getName();
            // String address = dto.getAddress();
            // SampleUserEntity userEntity = new SampleUser(userId, password, address, telnumber);
            // SampleUserEntity userEntity = new SampleEntity(); 

            // setter 메서드 안씀
            // userEntity.setUserId(userId);
            // userEntity.setPassword(password);

            // 데이터 베이스 테이블에 ? 생성 = 인스턴스 생성
            // setter메서드, new 생성자 대신 builder 패턴 사용

            // SampleUserEntity userEntity 
            // = SampleUserEntity.builder()
            //     .userId(userId)
            //     .password(password)
            //     .name(name)
            //     .address(address)
            //     .telNumber(telNumber)
            //     .build();

            // 비밀번호 암호화

            // 평문 비밀번호
            String password = dto.getPassword();

            // 비밀번호 인코딩 작업
            String encodedPassword = passwordEncoder.encode(password);

            // 인코딩 된 비밀번호 dto에 넣어주기
            dto.setPassword(encodedPassword);

            SampleUserEntity userEntity = new SampleUserEntity(dto);
            sampleUserRepository.save(userEntity);

            return "성공!";

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return "예외 발생!";
        }

    }

    @Override
    public String signIn(SignInRequestDto dto) {
        
        try {

            String userId = dto.getUserId();
            SampleUserEntity userEntity = sampleUserRepository.findByUserId(userId);
            if (userEntity == null) return "로그인 정보가 일치하지 않습니다.";

            String Password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();

            boolean isMatched = passwordEncoder.matches(Password, encodedPassword);
            if (!isMatched) return "로그인 정보가 일치하지 않습니다.";

            String token = jwtProvider.create(userId);
            return token;

        } catch (Exception exception) {

            exception.printStackTrace();
            return "예외 발생!";
            
        }

    }
    
}
