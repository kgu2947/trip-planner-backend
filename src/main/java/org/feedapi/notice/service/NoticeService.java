package org.feedapi.notice.service;

import org.feedapi.notice.dto.NoticeDTO;
import org.feedapi.notice.dto.NoticeResDTO;
import org.feedapi.notice.mapper.NoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NoticeService {
    private final NoticeMapper noticeMapper;

    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public void addNotice(NoticeDTO noticeDTO) {
        noticeMapper.addNotice(noticeDTO);
    }

    public NoticeResDTO getNoitce(NoticeDTO  noticeDTO) {
        NoticeResDTO  noticeResDTO = new NoticeResDTO();

        noticeResDTO.setNoticeList(noticeMapper.getNotice(noticeDTO));
        noticeResDTO.setCnt(noticeMapper.getNoticeCnt(noticeDTO));

        return noticeResDTO;
    }

    public NoticeDTO getDetailNotice(Integer no) {
        return noticeMapper.getDetailNotice(no);
    }

    public void updateNotice(NoticeDTO noticeDTO) {
        noticeMapper.updateNotice(noticeDTO);
    }

    public void deleteNotice(Integer no) {
        noticeMapper.deleteNotice(no);
    }

}
