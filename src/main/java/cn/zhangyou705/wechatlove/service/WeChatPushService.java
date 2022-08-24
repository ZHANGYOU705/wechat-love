package cn.zhangyou705.wechatlove.service;

import cn.zhangyou705.wechatlove.util.WeatherUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import cn.zhangyou705.wechatlove.util.LoveWordsUtil;
import cn.zhangyou705.wechatlove.util.DateCompareUtil;

import javax.annotation.Resource;

/**
 * @author ZhangYou
 * @description 微信推送Service
 * @date 2022/8/23
 */
@Service
@Slf4j
public class WeChatPushService {

    @Value("${wechat.appId}")
    private String appId;
    @Value("${wechat.secret}")
    private String secret;
    @Value("${wechat.templateId}")
    private String templateId;

    @Value("${tian.caihongpi.key}")
    private String key;

    @Value("${target.loveStart}")
    private String loveStart;
    @Value("${target.getLicense}")
    private String getLicense;
    @Value("${target.birthdayToYou}")
    private String birthdayToYou;

    @Resource
    private WeatherUtil weatherUtil;

    public void push(String targetOpenId) {

        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(targetOpenId)
                .templateId(templateId)
                .build();

        WxMpTemplateMessage buildContextResult = this.buildContext(templateMessage);

        try {
            log.info("待推送的内容为：{}", buildContextResult.toJson());
            String msgId = wxMpService.getTemplateMsgService().sendTemplateMsg(buildContextResult);
            log.info("推送成功：{}", msgId);
        } catch (Exception e) {
            log.error("消息推送失败，error：{}", e.getMessage(), e);
        }
    }

    /**
     * 构建模板内容
     *
     * @param templateMessage
     * @return
     */
    private WxMpTemplateMessage buildContext(WxMpTemplateMessage templateMessage) {
        JSONObject todayWeather = weatherUtil.getTodayWeatherByBaiDu();

        templateMessage.addData(new WxMpTemplateData("today", todayWeather.getString("date") + " " + todayWeather.getString("week"), "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("weather", todayWeather.getString("text_day"), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("minimumTemperature", todayWeather.getString("low") + "", "#173177"));
        templateMessage.addData(new WxMpTemplateData("maximumTemperature", todayWeather.getString("high") + "", "#FF6347"));

        int loveStart = DateCompareUtil.getLoveStart(this.loveStart);
        if (loveStart > 0) {
            templateMessage.addData(new WxMpTemplateData("loveStartPrefix", "今天是我们恋爱的第 "));
            templateMessage.addData(new WxMpTemplateData("loveStart", loveStart + "", "#FF1493"));
            templateMessage.addData(new WxMpTemplateData("loveStartSuffix", " 天"));
        } else {
            templateMessage.addData(new WxMpTemplateData("loveStartPrefix", "亲爱的，我会一直守护你~"));
        }

        int license = DateCompareUtil.getLicense(getLicense);
        if (license > 0) {
            templateMessage.addData(new WxMpTemplateData("getLicensePrefix", "今天是我们恋爱的第 "));
            templateMessage.addData(new WxMpTemplateData("getLicense", license + "", "#FF6347"));
            templateMessage.addData(new WxMpTemplateData("getLicenseSuffix", " 天了~"));
        } else {
            templateMessage.addData(new WxMpTemplateData("getLicensePrefix", "好期待与你一起的岁岁年年~"));
        }

        int birthdayToYou = DateCompareUtil.getBirthdayToYou(this.birthdayToYou);
        if (birthdayToYou > 0) {
            templateMessage.addData(new WxMpTemplateData("getBirthdayToYouPrefix", "距离你的生日还有 "));
            templateMessage.addData(new WxMpTemplateData("birthdayToYou", birthdayToYou + "", "#FFA500"));
            templateMessage.addData(new WxMpTemplateData("getBirthdayToYouSuffix", " 天~"));
        } else {
            templateMessage.addData(new WxMpTemplateData("getBirthdayToYouPrefix", "亲爱的，今天是你的生日呀~"));
        }

        templateMessage.addData(new WxMpTemplateData("caiHongPi", LoveWordsUtil.getCaiHongPi(key), "#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("loveWords", LoveWordsUtil.getJinJu() + "", "#C71585"));


        return templateMessage;
    }
}
