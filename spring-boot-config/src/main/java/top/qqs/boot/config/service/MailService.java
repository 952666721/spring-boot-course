package top.qqs.boot.config.service;

import top.qqs.boot.config.enums.ResultStatus;
import top.qqs.boot.config.model.Mail;
public interface MailService {
    ResultStatus sendSimpleMail(Mail mail);
    ResultStatus sendHtmlMail(Mail mail);
}
