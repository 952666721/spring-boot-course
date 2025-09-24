package top.qqs.boot.redis.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.qqs.boot.redis.enums.ErrorCode;
@EqualsAndHashCode(callSuper = false)
@Data
public class ServerException extends RuntimeException {
  private int code;
  private String msg;

  public ServerException(String msg) {
    super(msg);
    this.code = ErrorCode.SERVER_ERROR.getCode();
    this.msg = msg;
  }
  public ServerException(ErrorCode errorCode) {
    this.code = errorCode.getCode();
    this.msg = errorCode.getMsg();
  }
  public ServerException(String msg, Throwable e)  {
    super(msg);
    this.code = ErrorCode.SERVER_ERROR.getCode();
  }

}
