package top.qqs.boot.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 每日天气早报服务
 */
@Slf4j
@Service
public class DailyWeatherService {
//    private final OkHttpClient okHttpClient = new OkHttpClient();
//
//    @Resource
//    private JavaMailSender mailSender;
//
//    // 从配置文件注入参数
//    @Value("${weather.api.key}")
//    private String weatherApiKey;
//
//    @Value("${weather.api.city}")
//    private String cityId;
//
//    @Value("${weather.api.url}")
//    private String weatherApiUrl;
//
//    @Value("${spring.mail.username}")
//    private String fromEmail;
//
//    @Value("${email.recipients}")
//    private String[] toEmails;
//
//
//    /**
//     * 定时任务，每天7:20执行
//     */
//    @Scheduled(cron = "0 33 9 * * ?")
//    public void sendDailyWeather() {
//        try {
//            // 1. 调用和风天气API获取天气预报
//            String weatherResponse = getWeatherData();
//            if (weatherResponse == null) {
//                log.error("【天气早报】获取天气数据失败");
//                return;
//            }
//            // 2. 解析API响应（提取当天天气）
//            JSONObject weatherJson = JSONObject.parseObject(weatherResponse);
//            JSONObject todayWeather = weatherJson.getJSONArray("daily").getJSONObject(0);
//            // 提取天气相关信息
//            // 日期
//            String date = todayWeather.getString("fxDate");
//            // 最高温
//            String tempMax = todayWeather.getString("tempMax");
//            // 最低温
//            String tempMin = todayWeather.getString("tempMin");
//            // 白天天气（如“晴”）
//            String textDay = todayWeather.getString("textDay");
//            // 白天风向
//            String windDirDay = todayWeather.getString("windDirDay");
//            // 白天风力
//            String windScaleDay = todayWeather.getString("windScaleDay");
//
//            // 3. 构造邮件内容
//            String subject = String.format("【每日天气早报】%s 南京天气", LocalDate.parse(date).format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
//            String content = String.format("""
//                    📅 日期：%s
//                    🌤️ 天气：%s
//                    🌡️ 温度：%s℃ ~ %s℃
//                    💨 风向：%s
//                    🌬️ 风力：%s级
//                    💡 提示：出门请根据天气增减衣物，注意交通安全！""", date, textDay, tempMin, tempMax, windDirDay, windScaleDay);
//            // 4. 发送邮件
//            sendEmail(subject, content);
//            log.info("【天气早报】邮件发送成功，收件人：{}", String.join(",", toEmails));
//
//        } catch (Exception e) {
//            log.error("【天气早报】执行失败", e);
//        }
//    }
//
//
//    /**
//     * 调用和风天气API,获取3天天气预报
//     *
//     * @return API响应（JSON格式）
//     */
//    private String getWeatherData() throws IOException {
//        // 构造API请求URL（含城市ID和API密钥）
//        String requestUrl = String.format("%s?location=%s&key=%s", weatherApiUrl, cityId, weatherApiKey);
//        Request request = new Request.Builder().url(requestUrl).build();
//        try (Response response = okHttpClient.newCall(request).execute()) {
//            if (response.isSuccessful() && response.body() != null) {
//                return response.body().string();
//            }
//            return null;
//        }
//    }
//
//    /**
//     * 发送邮件方法
//     *
//     * @param subject 邮件主题
//     * @param content 邮件内容
//     */
//    private void sendEmail(String subject, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(fromEmail);
//        message.setTo(toEmails);
//        message.setSubject(subject);
//        message.setText(content);
//        mailSender.send(message);
//    }
}