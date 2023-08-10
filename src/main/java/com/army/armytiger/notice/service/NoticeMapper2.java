package com.army.armytiger.notice.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.army.armytiger.command.FileUploadVO;
import com.army.armytiger.command.NoticeVO;
import com.army.armytiger.util.Criteria;

@Mapper
public interface NoticeMapper2 {
	
	public int regNotice(NoticeVO vo); // 공지 등록
	
	public void noticeFileRegist(FileUploadVO vo);
	
	public ArrayList<NoticeVO> getList(@Param("writer") String writer,
									   @Param("cri") Criteria cri); //모든 공지 리스트 조회
	public NoticeVO getContent(int notice_no);
	public int updateNotice(NoticeVO vo);
	public void deleteNotice(int notice_no);
	public int getTotal(@Param("writer") String writer,
			   			@Param("cri") Criteria cri);
	public int getCount(int notice_no);
}
