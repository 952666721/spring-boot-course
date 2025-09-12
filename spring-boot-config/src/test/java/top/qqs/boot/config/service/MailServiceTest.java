package top.qqs.boot.config.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.qqs.boot.config.model.Mail;

@SpringBootTest
@Slf4j
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        Mail mail = new Mail();
        mail.setTo("952666721@qq.com");
        mail.setSubject("测试简单邮件");
        mail.setContent("测试邮件内容");
        mailService.sendSimpleMail(mail);
    }

    @Test
    void sendHtmlMail() {
        Mail mail = new Mail();
        mail.setTo("952666721@qq.com");
        mail.setSubject("测试HTML邮件");
        mail.setContent("<html><body><h1>测试邮件内容</h1></body></html>");
        mailService.sendSimpleMail(mail);
    }
}