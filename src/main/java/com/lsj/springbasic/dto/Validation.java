package com.lsj.springbasic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// client request body 데이터의 유효성 검사
// - spring-boot-starter-validation 라이브러리 사용
// - 스프링 프레임워크에서 제공하는 유효성 검사 인터페이스 라이브러리
// - 클라이언트가 서버측에 데이터를 전송할 때 유효성을 검사하고 정확한 데이터만 받을 수 있도록 도움을 줌
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Validation {
    
    // @NotNull: null을 허용하지 않음
    @NotNull
    private String notNull;
    
    // @NotEmpty: 문자열 타입에서 null과 빈문자열("")을 허용하지 않음
    @NotEmpty
    private String notEmpty;

    // @NotBlank: 문자열 타입에서 null, 빈문자열(""), 공백 문자열("  ")을 허용하지 않음
    // "notBlank": null, "", "  ", "null" = 400 error 발생
    @NotBlank
    private String notBlank;


    // client로 부터 데이터를 받을 때는 기본형 데이터타입을 쓰기 않는게 좋음
    @NotNull
    // int 로 지정하면 0이 들어가서 Not null로 인정되지 않는다.
    // 다른 방법을 사용하여 오류를 해결한다. e.g Integer(wrapper class) or minmax < 1
    // @NotBlank -> 쓰면 안됨 문자열만 검사할 수 있음
    private Integer number;

    // @ Length(min = ?, max = ?) : 문자열 타입에서 길이의 최소 최대를 지정
    // 최소, 최대 둘다 같이 적어줘도 됨
    // "number" : 10, "length: asfeae" = 정상, "number" : 10, "length: "  " = 실패, 
    // null이면 검사하지 않음 따라서 @NotNull어노테이션도 같이 붙여줘야 정확하게 검사할 수 있다.
    @NotNull
    @Length(min = 4)
    private String length;

    //Min(), @Max(): 정수의 최소 최대값을 지정
    @Min(10)
    @Max(20)
    private Integer minMax;

    // @Range(min=?, max?)
    @Range(min=5, max=25)
    private Integer range;

    // @Size(min=?, max) : 컬렉션의 길이 최소 최대값을 지정
    @Size(min = 2, max = 4)
    private Integer[] size;

    // @Patter(regexp=정규식):
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String pattern;
}
