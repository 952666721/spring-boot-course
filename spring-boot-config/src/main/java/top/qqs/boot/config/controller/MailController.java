package top.qqs.boot.config.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qqs.boot.config.config.ApiResponse;
import top.qqs.boot.config.enums.ResultStatus;
import top.qqs.boot.config.model.Mail;
import top.qqs.boot.config.service.MailService;

@RestController
@RequestMapping("/mails")
public class MailController {
    @Resource
    private MailService mailService;

    @RequestMapping("/simple")
    public ResponseEntity<ApiResponse<ResultStatus>> sendimplMail(@Valid @RequestBody Mail mail) {
        ResultStatus rs = mailService.sendSimpleMail(mail);
        if (rs == ResultStatus.SUCCESS){
            return ResponseEntity.ok(ApiResponse.success("发送成功",rs));
        }
        return ResponseEntity.badRequest().body(ApiResponse.error("发送失败"));
    }
    @RequestMapping("/html")
    public ResponseEntity<ApiResponse<ResultStatus>> sendHtmlMail(@Valid @RequestBody Mail mail) {
        ResultStatus rs = mailService.sendHtmlMail(mail);
        return rs == ResultStatus.SUCCESS ? ResponseEntity.ok(ApiResponse.success("发送成功", rs)) : ResponseEntity.badRequest().body(ApiResponse.error("发送失败"));
    }
}
