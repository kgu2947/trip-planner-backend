package org.feedapi.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNoticeDTO {
    private String title;
    private String content;
    private String writer;
}
