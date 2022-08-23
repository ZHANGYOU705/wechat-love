package cn.zhangyou705.wechatlove.controller;

import cn.zhangyou705.wechatlove.service.WeChatPushService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZhangYou
 * @description 微信推送
 * @date 2022/8/23
 */
@RestController
@RequestMapping("wechat")
public class WeChatPushController {

    @Value("${target.targetOpenId}")
    private String target;

    @Resource
    private WeChatPushService weChatPushService;

    @GetMapping("/push")
    public void push() {
        weChatPushService.push(target);
    }

}
