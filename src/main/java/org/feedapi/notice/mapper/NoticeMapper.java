package org.feedapi.notice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.feedapi.notice.dto.AddNoticeDTO;
import org.feedapi.notice.dto.NoticeDTO;
import org.feedapi.notice.dto.UpdateNoticeDTO;

import java.util.List;

@Mapper
public interface NoticeMapper {

    void addNotice(AddNoticeDTO addNoticeDTO);

    List<NoticeDTO> getNotice(NoticeDTO noticeDTO);

    NoticeDTO getDetailNotice(Integer no);

    void updateNotice(UpdateNoticeDTO updateNoticeDTO);

    void deleteNotice(Integer no);

    Integer getNoticeCnt(NoticeDTO noticeDTO);
}
