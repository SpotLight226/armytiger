package com.army.armytiger.member.service;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.util.Criteria;

import java.util.ArrayList;

public interface MemberService {

    // 예비군 등록
    int memberRegist(MemberVO vo);

    // 예비군 목록
    ArrayList<MemberVO> getList(Criteria cri);

    // 총 수
    int getTotal(Criteria cri);
    
    // 상세정보
    MemberVO getDetail(String military_sn);
    
    // 정보수정
    int memberUpdate(MemberVO vo);
    
}
