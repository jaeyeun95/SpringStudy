package com.example.member.service;

import java.util.List;
import java.util.Map;

import com.example.member.vo.MemberVo;

public interface MemberService {

    Map<String, Object> insertMember(MemberVo vo) throws Exception;

    List<MemberVo> getlist();

    // MemberVo insertMember(MemberVo vo) throws Exception;

    
}
