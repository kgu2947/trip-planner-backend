package org.feedapi.notice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.feedapi.notice.dto.NoticeDTO;

import java.util.List;

@Mapper
public interface NoticeMapper {

    void addNotice(NoticeDTO noticeDTO);

    List<NoticeDTO> getNotice(NoticeDTO noticeDTO);

    NoticeDTO getDetailNotice(Integer no);

    void updateNotice(NoticeDTO noticeDTO);

    void deleteNotice(Integer no);

    Integer getNoticeCnt(NoticeDTO noticeDTO);
}
