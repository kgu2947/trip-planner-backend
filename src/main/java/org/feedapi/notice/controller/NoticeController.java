package org.feedapi.notice.controller;

import org.feedapi.notice.dto.NoticeDTO;
import org.feedapi.notice.dto.NoticeResDTO;
import org.feedapi.notice.service.NoticeService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/getNotice")
    public NoticeResDTO getNotice(NoticeDTO noticeDTO){
        return noticeService.getNoitce(noticeDTO);
    }

    @GetMapping("/getDetailNotice/{no}")
    public NoticeDTO getDetailNotice(@PathVariable Integer no){
        return noticeService.getDetailNotice(no);
    }

    @PostMapping("/addNotice")
    public void addNotice(@RequestBody NoticeDTO noticeDTO){
        noticeService.addNotice(noticeDTO);
    }

    @PutMapping("/updateNotice")
    public void updateNotice(@RequestBody NoticeDTO noticeDTO){
        noticeService.updateNotice(noticeDTO);
    }

    @DeleteMapping("/deleteNotice/{no}")
    public void deleteNotice(@PathVariable Integer no){
        noticeService.deleteNotice(no);
    }

}
