package com.lsj.springbasic.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lsj.springbasic.dto.PostSample1RequestDto;
import com.lsj.springbasic.service.SampleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




// json 형태만 반환 하는 어노테이션
@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor

public class SampleController {

    // 구현부(체)에다가 추상화 진행, 외부주입
    private final SampleService sampleService;


    @PostMapping("")    
    // 반환타입 별도 지정하는 어노테이션 @ResponseEntity<제너릭 타입>
    public ResponseEntity<String> postSample1(
        // valid = 유효성 검사 실행 어노테이션
        // RequestBody : -POST, PUT, PATCH처럼 Request Body로 데이터를 전송하는 메서드에서 데이터를 읽기 위한 어노테이션
        @RequestBody @Valid PostSample1RequestDto requestBody
    ) {
        ResponseEntity<String> response = sampleService.postSample1(requestBody);

        return response;

    }

    // 삭제 컨트롤러 만들기 (특정 경로로 들어오면 아래 코드가 실행 되게)
    @DeleteMapping("/{sampleId}")
    public ResponseEntity<String> deleteSample1(
        @PathVariable("sampleId") String sampleId 
    ) {
        ResponseEntity<String> response = sampleService.deleteSample1(sampleId);
        return response;
    }

        @GetMapping("")
        public ResponseEntity<String> queryMethod() {
            ResponseEntity<String> response = sampleService.queryString();
            return response;
        }
  
        @GetMapping("/jwt/{name}")
        public String getJwt(
            @PathVariable("name") String name 
        ) {
            String response = sampleService.getJwt(name);
            return response;
        }

        @PostMapping("/jwt")
        public String validateJwt(
            @RequestBody String jwt 
        ) {
             String response = sampleService.validateJwt(jwt);
             return response;
        }

}
