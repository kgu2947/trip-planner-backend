package org.feedapi.notice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NoticeResDTO {
    private List<NoticeDTO> noticeList;
    private Integer cnt;
}
