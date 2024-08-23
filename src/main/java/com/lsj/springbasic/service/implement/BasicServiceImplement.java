package com.lsj.springbasic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.lsj.springbasic.service.BasicService;

// Sercivce 레이어 
// - : 실제 비즈니스 로직을 실행하는 영역
// - 트랜잭션(기능 단위)처리나 유효성 검사(이전 트랜잭션 결과의 유효성 검사)를 수행함
// - controller로 부터 받은 요청을 처리하고 해당 처리 중 데이터 베이스 작업이 필요하면 Repository 영역으로 요청

// @Serie : 해당 클래스를 Spring Bean으로 등록하는 어노테이션, @Component와 동일하지만 가독성 향상을 위해 Service 이름을 사용
// @Component
@Service
public class BasicServiceImplement implements BasicService {

    public void method() {
        
    }

    @Override
    public ResponseEntity<String> getService() {
        return ResponseEntity.status(HttpStatus.OK).body("서비스 호출");
    }
}