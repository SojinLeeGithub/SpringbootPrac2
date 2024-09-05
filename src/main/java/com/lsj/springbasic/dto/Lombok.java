package com.lsj.springbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Lombok 라이브러리
// -getter 메서드, setter 메서드, 생성자, toString  메서드 등 자주 사용되지만 반복적인 작업을 자동으로 생성하는 라이브러리
// - 프로젝트가 Lombok 라이브러리 의존성을 가지고 있어야함
// - 대부분의 IDE에서 Lombok 어노테이션을 읽을 수 없기 때문에 Lombok 추가 확장이 필요하다.
// vs code의 경우 확장에 들어가서 'Lombock' 검색하거나 dependency설정에서 추가, 혹은 스프링 부트 스타터에 dependency 설정 때 추가하면 된다.

// @Getter: getter 메서드 생성
// @Setter: setter 메서드 생성
// @toString: toString 메서드 생성 (필드이름과 값을 문자열로 표현)
// @NoArgsConstructor: 빈 생성자 생성
// @AllArgsConstructor: 모든 멤버 변수를 초기화 하는 생성자 생성
// @RequiredArgsConstructor: 필수 멤버 변수를 초기화 하는 생성자 생성
// @Data: @Getter, @Setter, @RequiredArgsConstructor 등을 하나로 합친 어노테이션

@Getter
@Setter
@AllArgsConstructor
// @NoArgsConstructor
@RequiredArgsConstructor
public class Lombok {

    // @AllArgsConstructor 추가하면 field1, field2 빨간줄 사라지는 것을 확인할 수 있다.
    // @NoArgsConstructor 은 final 접근 제어자 있으면 사용하지 못한다(빨간줄 생김)


    final private String field1; 
    final private String field2;
    private String field3;

    // 기본형 boolean일 경우 getter 메서드 이름은 isXXX()
    private boolean field4;
    // 참조형 Boolean일 경우 getter 메서드 이름은 geXXX()
    private Boolean field5;

    
}
