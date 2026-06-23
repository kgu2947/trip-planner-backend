package org.feedapi.file.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDTO {
    private Integer file_no;
    private String originName;
    private String savedName;
    private String filePath;
    private String targetType;
    private Integer targetId;
}
