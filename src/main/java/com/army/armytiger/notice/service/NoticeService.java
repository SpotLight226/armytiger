package com.army.armytiger.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.army.armytiger.command.NoticeVO;
import com.army.armytiger.util.Criteria;

public interface NoticeService {
	
	public int regNotice(NoticeVO vo, List<MultipartFile> list);
	public ArrayList<NoticeVO> getList(String writer, Criteria cri);
	public NoticeVO getContent(int notice_no);
	public int updateNotice(NoticeVO vo);
	public void deleteNotice(int notice_no);
	public int getTotal(String writer, Criteria cri);
	public int getCount(int notice_no);
	
}
