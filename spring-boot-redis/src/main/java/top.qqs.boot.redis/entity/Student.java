package top.qqs.boot.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -5597206790619421003L;
    private String id;
    private String name;
    private Address address;
}
