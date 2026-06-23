package org.feedapi.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNoticeDTO {
    private Integer noticeNo;
    private String title;
    private String content;
    private String writer;
    private Integer fileNo;
}
