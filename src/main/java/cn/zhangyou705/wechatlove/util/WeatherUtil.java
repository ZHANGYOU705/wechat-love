package cn.zhangyou705.wechatlove.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ZhangYou
 * @description
 * @date 2022/8/23
 */
@Component
public class WeatherUtil {

    @Value("${weather.ak}")
    private String ak;

    @Value("${weather.areaCode}")
    private String areaCode;

    public JSONObject getTodayWeatherByBaiDu() {
        String result;
        JSONObject todayWeather = new JSONObject();
        try {
            result = HttpUtil.get("https://api.map.baidu.com/weather/v1/?district_id=" + areaCode + "&data_type=all&ak=" + ak);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if ("success".equals(jsonObject.getString("message"))) {
                JSONArray arr = jsonObject.getJSONObject("result").getJSONArray("forecasts");
                todayWeather = arr.getJSONObject(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todayWeather;
    }
}
