package com.lsj.springbasic.service;
import org.springframework.http.ResponseEntity;
import com.lsj.springbasic.dto.PostSample1RequestDto;


// 추상화 작업 먼저 해야해서 인터페이스 생성함
// 실제 사용할 메서드 만들어야 함
public interface SampleService {

    // 서비스 호출하기
    ResponseEntity<String> postSample1 (PostSample1RequestDto dto);
    ResponseEntity<String> deleteSample1 (String sampleId);
    ResponseEntity<String> queryString();
    String getJwt(String name);
    
} 