package com.lsj.springbasic.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// lombok이용한 캡슐화 작업
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostSample1RequestDto {

    //문자열 타입에서 null, 빈문자열(""), 공백 문자열("  ")을 허용하지 않음
    @NotBlank
    @Length(max=10)
    private String sampleId;

    @NotNull
    private Integer sampleColumn;
}
