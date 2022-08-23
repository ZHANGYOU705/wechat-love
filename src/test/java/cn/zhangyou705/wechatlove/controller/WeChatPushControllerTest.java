package cn.zhangyou705.wechatlove.controller;

import cn.zhangyou705.wechatlove.service.WeChatPushService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ZhangYou
 * @description
 * @date 2022/8/23
 */
@SpringBootTest
public class WeChatPushControllerTest {

    @Value("${target.targetOpenId}")
    private String target;

    @Resource
    private WeChatPushService weChatPushService;

    @Test
    public void push() {
        weChatPushService.push(target);
        System.out.println("已发送！！！");
    }

}