package com.lsj.springbasic.service;

import com.lsj.springbasic.dto.PostUserRequestDto;
import com.lsj.springbasic.dto.SignInRequestDto;

public interface AuthService {

    String signUp(PostUserRequestDto dto);
    String signIn(SignInRequestDto dto);

    
} 