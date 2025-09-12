package top.qqs.boot.config.service.impl;

import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import top.qqs.boot.config.enums.ResultStatus;
import top.qqs.boot.config.model.Mail;
import top.qqs.boot.config.service.MailService;

@Service
public class MailServiceImpl implements MailService {
  @Value("${spring.mail.username}")
  private String from;

  @Resource
  private JavaMailSender javaMailSender;


  @Override
  public ResultStatus sendSimpleMail(Mail mail) {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(from);
      message.setTo(mail.getTo());
      message.setSubject(mail.getSubject());
      message.setText(mail.getContent());
      /*javaMailSender.send(message);*/
      try {
          javaMailSender.send(message);
          return ResultStatus.SUCCESS;
      } catch (Exception e) {
          return ResultStatus.FAIL;
      }
    }
    @Override
    public ResultStatus sendHtmlMail(Mail mail) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());

            helper.setText(mail.getContent(), true);
            javaMailSender.send(message);
            return ResultStatus.SUCCESS;
        } catch (Exception e) {
            return ResultStatus.FAIL;
        }
    }
}
