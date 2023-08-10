package com.army.armytiger.member.service;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

    // memberMapper
    @Autowired
    private MemberMapper memberMapper;

    // 예비군 등록
    @Override
    public int memberRegist(MemberVO vo) {

        int result = memberMapper.memberRegist(vo);

        return result;
    }

    // 상세정보
    @Override
    public MemberVO getDetail(String military_sn) {
        return memberMapper.getDetail(military_sn);
    }

    // 예비군 목록
    @Override
    public ArrayList<MemberVO> getList(Criteria cri) {
        return memberMapper.getList(cri);
    }

    // 수정하기
    @Override
    public int memberUpdate(MemberVO vo) {
        return memberMapper.memberUpdate(vo);
    }

    // 크리테리아
    @Override
    public int getTotal(Criteria cri) {
        return memberMapper.getTotal(cri);
    }


}
