package com.lsj.springbasic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lsj.springbasic.dto.PostSample1RequestDto;
import com.lsj.springbasic.entity.SampleTable1Entity;
import com.lsj.springbasic.repositoy.SampleTable1Repository;
import com.lsj.springbasic.service.SampleService;

import lombok.RequiredArgsConstructor;


// spring bean 등록
@Service
@RequiredArgsConstructor
public class SampleServiceImplement implements SampleService {

    private final SampleTable1Repository sampleTable1Repository;

    @Override
    public ResponseEntity<String> postSample1(PostSample1RequestDto dto) {


        String sampleId = dto.getSampleId();
        Integer sampleColumn = dto.getSampleColumn();

        // SELECT (SQL : SELECT)
        // 1. repository 를 이용하여 조회 (findAll, findById)
        // findById = pk 조회
        // SampleTable1Entity existEntity = sampleTable1Repository.findById(sampleId).get();
        // 2. repository를 이용하여 조회 (existsById)
        boolean isExiststed = sampleTable1Repository.existsById(sampleId);
        if (isExiststed) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 존재하는 기본키입니다.");

        // CREATE (SQL : INSERT)
        // 1. Entity 클래스의 인스턴스 생성
        SampleTable1Entity entity = new SampleTable1Entity(sampleId, sampleColumn);
        
        // 2. 생성한 인스턴스를 repository를 이용하여 저장
        // save() : 저장
        // - 만약에 Primary key가 동일한 레코드가 존재하지 않으면 레코드 생성
        // - 동일한 레코드 존재하면 수정
        sampleTable1Repository.save(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body("성공");
    }
        
}
