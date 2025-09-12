package top.qqs.boot.config.model;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class TeamTest {
    @Resource
    private Team team;

    @Test
    void testTeam() {
        log.info("团队创建成功");
        /*team.setName("移动2班");
        log.info(String.valueOf(team));*/
        assertEquals("移动2班",team.getName());
        assertEquals("sqq",team.getLeader());
    }
}