package top.qqs.boot.redis.entity;

import lombok.Data;
/**
 * @Author: mqxu
 * @Date: 2025/9/24
 */
@Data
public class LoginRequest {
    private String phone;
    private String code;
}
