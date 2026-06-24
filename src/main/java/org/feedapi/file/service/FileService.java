package org.feedapi.file.service;

import org.feedapi.file.dto.FileDTO;
import org.feedapi.file.mapper.FileMapper;
import org.feedapi.login.dto.LoginDTO;
import org.feedapi.login.dto.LoginDataDTO;
import org.feedapi.login.mapper.LoginMapper;
import org.feedapi.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class FileService {
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public FileDTO getFileInfo(Integer no) {
        return fileMapper.getFileInfo(no);
    }
}
