package com.example.member.vo;

import lombok.Data;

@Data
public class MemberVo {
    private String id;
    private String pw;
    private String name;
    private String nickname;
    private String address;
    private String email;
    private String registDate;
}