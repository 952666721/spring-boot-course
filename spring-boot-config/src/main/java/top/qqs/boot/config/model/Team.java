package top.qqs.boot.config.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class Team {
    //@Value("${team.name}")
    @NotNull
    @Size(min = 3,max = 20,message = "名称长度必须在3-20之间")
    private String name;

    //@Value("${team.leader}")
    @NotNull
    @Size(min = 3,max = 8,message = "名称长度必须在3-8之间")
    private String leader;

    //@Value("${team.phone}")
    @Pattern(regexp = "^[0-9]{11}$",message = "手机号格式不正确")
    private String phone;

   //@Value("${team.age}")
    @Min(1)
    @Max(4)
    private Integer age;

    @Past(message = "创建时间不能晚于当前时间")
    private LocalDate createTime;
}
