package org.feedapi.file.controller;

import org.springframework.core.io.Resource;
import org.feedapi.file.dto.FileDTO;
import org.feedapi.file.service.FileService;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/file/download/{no}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("no") Integer no) throws IOException {
        FileDTO fileDTO = fileService.getFileInfo(no);

        // db에 저장된 파일 경로를 java 파일 경로 객체로 변환
        Path filePath = Paths.get(fileDTO.getFilePath());

        // 해당 경로의 파일을 Spring에서 읽고 응답해주는 객체
        UrlResource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        // http 응답
        return ResponseEntity.ok()
                // 파일 다운로드 창 띄우는 헤더
               .header(HttpHeaders.CONTENT_DISPOSITION
                       // 위 filePath의 실제 저장된 원본파일명
                       , "attachment; filename=\""
                       + URLEncoder.encode(fileDTO.getOriginName(), StandardCharsets.UTF_8)
                       + "\"")
               .body(resource);
    }

}
