package cn.zhangyou705.wechatlove.task;

import cn.hutool.core.date.DateUtil;
import cn.zhangyou705.wechatlove.service.WeChatPushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZhangYou
 * @description 定时job
 * @date 2022/8/23
 */
@Component
@Slf4j
public class WeChatPushJob {

    @Value("${target.targetOpenId}")
    private String targetOpenId;

    @Resource
    private WeChatPushService pusherService;

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning() {

        pusherService.push(targetOpenId);
        log.info("定时任务已执行，当前时间：" + DateUtil.now());

    }

}
