package org.feedapi.notice.service;

import org.feedapi.notice.dto.AddNoticeDTO;
import org.feedapi.notice.dto.NoticeDTO;
import org.feedapi.notice.dto.NoticeResDTO;
import org.feedapi.notice.dto.UpdateNoticeDTO;
import org.feedapi.notice.mapper.NoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeService {
    private final NoticeMapper noticeMapper;

    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Transactional
    public void addNotice(AddNoticeDTO addNoticeDTO) {
        noticeMapper.addNotice(addNoticeDTO);
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

    @Transactional
    public void updateNotice(UpdateNoticeDTO updateNoticeDTO) {
        noticeMapper.updateNotice(updateNoticeDTO);
    }

    @Transactional
    public void deleteNotice(Integer no) {
        noticeMapper.deleteNotice(no);
    }

}
