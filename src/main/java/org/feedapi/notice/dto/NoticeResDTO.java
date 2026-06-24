package org.feedapi.notice.dto;

import lombok.Getter;
import lombok.Setter;
import org.feedapi.file.dto.FileDTO;

import java.util.List;

@Getter
@Setter
public class NoticeResDTO extends NoticeDTO {
    private List<NoticeDTO> noticeList;
    private Integer cnt;
    private List<FileDTO> fileList;
    private Integer fileCnt;
}
