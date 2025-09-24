package top.qqs.boot.exception.service;

import org.springframework.stereotype.Service;
import top.qqs.boot.exception.exception.BusinessException;

@Service
public class ExceptionService {
    /**
     * 模拟未登录异常
     */
    public void unAuthorizedError() {
        throw new BusinessException("权限不足");
    }

    /**
     * 模拟系统异常
     */
    public void systemError() {
        throw new BusinessException("系统错误");
    }
}
