package org.feedapi.file.util;

import org.feedapi.file.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {

    private static final String UPLOAD_PATH = "C:/project/upload";

    public static FileDTO uploadFile(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            return null;
        }

        // 업로드한 파일명
        String originalFilename = file.getOriginalFilename();


        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            // 확장자 명 추출
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        // 서버에 저장될 파일명
        String savedName = UUID.randomUUID().toString() + extension;

        File dir = new File(UPLOAD_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 서버에 저장된 파일의 경로
        String filePath = UPLOAD_PATH + File.separator + savedName;

        // 서버에 파일 저장
        file.transferTo(new File(filePath));

        FileDTO fileDTO = new FileDTO();
        fileDTO.setOriginName(originalFilename);
        fileDTO.setSavedName(savedName);
        fileDTO.setFilePath(filePath);

        return fileDTO;
    }
}
