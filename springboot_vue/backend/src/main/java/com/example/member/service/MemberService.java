package com.example.member.service;

import java.util.Map;

import com.example.member.vo.MemberVo;

public interface MemberService {

    Map<String, Object> insertMember(MemberVo vo) throws Exception;

    // MemberVo insertMember(MemberVo vo) throws Exception;

    
}
