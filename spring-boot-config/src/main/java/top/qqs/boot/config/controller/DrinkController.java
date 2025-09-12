package top.qqs.boot.config.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qqs.boot.config.enums.DrinkType;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
    @GetMapping("/{type}")
    public String selectDrink(@PathVariable DrinkType type) {
        return String.format("您选择的是：%s，价格：%.2f元",
                type.getDescription(),
                type.getPrice());
    }
}
