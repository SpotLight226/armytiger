package com.army.armytiger.member.service;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface MemberMapper {
    
    // 멤버 등록
    int memberRegist(MemberVO vo);

    // 예비군 목록
    ArrayList<MemberVO> getList(Criteria cri);

    // 상세정보
    MemberVO getDetail(String military_sn);

    // 총 수
    int getTotal(Criteria cri);

    // 수정하기
    int memberUpdate(MemberVO vo);

    
}
