package org.feedapi.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNoticeDTO {
    private Integer no;
    private String title;
    private String content;
}
