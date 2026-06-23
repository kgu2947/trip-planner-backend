package org.feedapi.notice.controller;

import org.feedapi.notice.dto.AddNoticeDTO;
import org.feedapi.notice.dto.NoticeDTO;
import org.feedapi.notice.dto.NoticeResDTO;
import org.feedapi.notice.dto.UpdateNoticeDTO;
import org.feedapi.notice.service.NoticeService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public NoticeResDTO getNotice(NoticeDTO noticeDTO){
        return noticeService.getNoitce(noticeDTO);
    }

    @GetMapping("/notice/{no}")
    public NoticeDTO getDetailNotice(@PathVariable Integer no){
        return noticeService.getDetailNotice(no);
    }

    @PostMapping("/notice")
    public void addNotice(@RequestBody AddNoticeDTO addNoticeDTO){
        noticeService.addNotice(addNoticeDTO);
    }

    @PutMapping("/notice")
    public void updateNotice(@RequestBody UpdateNoticeDTO updateNoticeDTO){
        noticeService.updateNotice(updateNoticeDTO);
    }

    @DeleteMapping("/notice/{no}")
    public void deleteNotice(@PathVariable Integer no){
        noticeService.deleteNotice(no);
    }

}
