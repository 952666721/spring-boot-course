package top.qqs.boot.redis.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.qqs.boot.redis.exception.ServerException;
import top.qqs.boot.redis.result.Result;

/**
 * @Author: mqxu
 * @Date: 2025/9/19
 * @Description: 业务异常处理器
 * AOP 切面处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServerException.class)
    public Result<String> handleBusinessException(ServerException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理其他异常
     *
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.error(e.getMessage());
    }
}