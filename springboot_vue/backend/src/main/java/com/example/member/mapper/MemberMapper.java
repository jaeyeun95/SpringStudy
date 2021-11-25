package com.example.member.mapper;

import java.util.List;

import com.example.member.vo.MemberVo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int insertMember(MemberVo vo) throws Exception;

    List<MemberVo> getList();


    
}
