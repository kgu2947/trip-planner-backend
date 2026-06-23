package org.feedapi.file.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.feedapi.file.dto.FileDTO;
import org.feedapi.notice.dto.AddNoticeDTO;
import org.feedapi.notice.dto.NoticeDTO;
import org.feedapi.notice.dto.UpdateNoticeDTO;

import java.util.List;

@Mapper
public interface FileMapper {

    void addFileInfo(FileDTO fileInfo);
}
