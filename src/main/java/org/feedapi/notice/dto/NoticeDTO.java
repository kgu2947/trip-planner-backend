package org.feedapi.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {
    private Integer no;
    private String title;
    private String writer;
    private String reg_date;
    private String searchKeyword;
    private String searchType;
    private Integer page;
}
