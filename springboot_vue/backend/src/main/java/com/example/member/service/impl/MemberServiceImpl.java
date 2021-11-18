package com.example.member.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.member.mapper.MemberMapper;
import com.example.member.service.MemberService;
import com.example.member.vo.MemberVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Override
    public Map<String, Object> insertMember(MemberVo vo) throws Exception {
        System.out.println("############################MEMBERSERVICEIMPL");
        Map<String, Object> map = new HashMap<>();
        int result = mapper.insertMember(vo);
        System.out.println("############ 결과 ##########" + result);
        if(result > 0){
            map.put("result", result);
        } else {
            map.put("result", "실패");
        }
        return map;
    }



    // @Override
    // public MemberVo insertMember(MemberVo vo) throws Exception {
    //     return mapper.insertMember(vo);
    // }
    
    
}
