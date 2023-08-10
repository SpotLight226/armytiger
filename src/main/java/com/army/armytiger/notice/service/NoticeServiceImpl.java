package com.army.armytiger.notice.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.army.armytiger.command.FileUploadVO;
import com.army.armytiger.command.NoticeVO;
import com.army.armytiger.util.Criteria;

@Service("noticeSerivce")
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper2 noticeMapper;
	
	@Value("${project.upload.path}")
	private String uploadPath;
	
	//폴더생성함수
		public String makeFolder() {
			String path = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
			
			File file = new File(uploadPath + "/" + path);
			
			if(file.exists() == false) { //존재하면 true, 존재하지 않으면 false
				file.mkdirs();
			}
			
			return path; //날짜폴더명 반환
		}
	
	@Override
	public int regNotice(NoticeVO vo, List<MultipartFile> list) {
		
			int result = noticeMapper.regNotice(vo);
			
			for(MultipartFile file : list) {
				
				String originName = file.getOriginalFilename();
				String fileName = originName.substring(originName.lastIndexOf("\\") + 1);
				String uuid = UUID.randomUUID().toString();
				String filesize = Long.toString(file.getSize());
				String filePath = makeFolder();
				String savePath = uploadPath + "/" + filePath + "/" + uuid + "_" + fileName;
				
				try {
					File saveFile = new File(savePath);
					file.transferTo(saveFile);				
				} catch (Exception e) {
					System.out.println("파일업로드 중 에러발생");
					e.printStackTrace();
					return 0; // 실패의 의미
				}
				
				noticeMapper.noticeFileRegist(FileUploadVO.builder()
														  .filename(fileName)
														  .filepath(filePath)
														  .filesize(filesize)
														  .uuid(uuid)
														  .notice_no(vo.getNotice_no())
														  .build());
			}
		
		return result;
	}

	@Override
	public ArrayList<NoticeVO> getList(String writer, Criteria cri) {
		
		return noticeMapper.getList(writer, cri);
	}
	
	@Override
	public NoticeVO getContent(int notice_no) {
		return noticeMapper.getContent(notice_no);
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		return noticeMapper.updateNotice(vo);
	}

	@Override
	public void deleteNotice(int notice_no) {
		noticeMapper.deleteNotice(notice_no);
	}

	@Override
	public int getTotal(String writer, Criteria cri) {
		return noticeMapper.getTotal(writer, cri);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public int getCount(int notice_no) {
		
		return noticeMapper.getCount(notice_no);
		
	}
	
	
}
