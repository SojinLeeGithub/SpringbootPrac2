package com.lsj.springbasic.entity;

import com.lsj.springbasic.dto.PostUserRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 데이터베이스 테이블과 매핑 시키는 작업

// 캡슐화 작업
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// 문자열 변환 어노테이션
@ToString

// SampleUserEntity를 JPA에서 사용할 Entity로 지정
@Entity(name = "user")
// 테이블 이름이 다르기 때문에 데이터베이스 테이블명 직접 지정해줌
@Table(name= "sample_user")
@Builder
public class SampleUserEntity {

    @Id
    private String userId;
    private String password;
    private String name;
    private String address;
    private String telNumber;
 
    public SampleUserEntity(PostUserRequestDto dto) {
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.telNumber = dto.getTelNumber();
        
    }


}
