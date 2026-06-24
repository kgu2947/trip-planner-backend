package org.feedapi.notice.service;

import org.feedapi.file.dto.FileDTO;
import org.feedapi.file.mapper.FileMapper;
import org.feedapi.file.util.FileUtil;
import org.feedapi.notice.dto.AddNoticeDTO;
import org.feedapi.notice.dto.NoticeDTO;
import org.feedapi.notice.dto.NoticeResDTO;
import org.feedapi.notice.dto.UpdateNoticeDTO;
import org.feedapi.notice.mapper.NoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final FileMapper fileMapper;

    public NoticeService(NoticeMapper noticeMapper, FileMapper fileMapper) {
        this.noticeMapper = noticeMapper;
        this.fileMapper = fileMapper;
    }

    @Transactional
    public void addNotice(AddNoticeDTO addNoticeDTO, List<MultipartFile> files) throws IOException {
        noticeMapper.addNotice(addNoticeDTO);

        Integer noticeNo = addNoticeDTO.getNoticeNo();
        String targetType = "notice";

        if(files != null && files.size() > 0) {
            for (MultipartFile file : files) {
                FileDTO fileInfo = FileUtil.uploadFile(file);

                fileInfo.setTargetId(noticeNo);
                fileInfo.setTargetType(targetType);

                fileMapper.addFileInfo(fileInfo);
            }
        }
    }

    public NoticeResDTO getNoitce(NoticeDTO  noticeDTO) {
        NoticeResDTO  noticeResDTO = new NoticeResDTO();

        noticeResDTO.setNoticeList(noticeMapper.getNotice(noticeDTO));
        noticeResDTO.setCnt(noticeMapper.getNoticeCnt(noticeDTO));

        return noticeResDTO;
    }

    public NoticeResDTO getDetailNotice(Integer no) {

        NoticeResDTO noticeResDTO = noticeMapper.getDetailNotice(no);
        noticeResDTO.setFileCnt(fileMapper.getFileCnt(no));
        noticeResDTO.setFileList(fileMapper.getFileList(no));

        System.out.println(noticeResDTO.getFileList());

        return noticeResDTO;
    }

    @Transactional
    public void updateNotice(UpdateNoticeDTO updateNoticeDTO) {
        noticeMapper.updateNotice(updateNoticeDTO);
    }

    @Transactional
    public void deleteNotice(Integer no) {
        noticeMapper.deleteNotice(no);
    }

}
