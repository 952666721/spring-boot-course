package top.qqs.boot.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.qqs.boot.exception.common.Result;
import top.qqs.boot.exception.exception.BusinessException;

@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理其他异常
     *
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        log.error(e.getMessage(), e);
    }
}
