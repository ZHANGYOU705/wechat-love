package cn.zhangyou705.wechatlove.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ZhangYou
 * @description
 * @date 2022/8/23
 */
public class LoveWordsUtil {
    private static final String url = "http://api.tianapi.com/caihongpi/index?key=";
    private static final List<String> LoveWordsList = new ArrayList<>();
    private static final String name = "宝贝";

    public static String getCaiHongPi(String key) {
        String str = "情书给你一封，情话给你一句，余生给你一人";
        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.get(url + key).replace("XXX", name));
            if (jsonObject.getIntValue("code") == 200) {
                str = jsonObject.getJSONArray("newslist").getJSONObject(0).getString("content");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    static {
        InputStream inputStream = LoveWordsUtil.class.getClassLoader().getResourceAsStream("static/Love-words.txt");
        try {
            assert inputStream != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder str = new StringBuilder();
                String temp = "";
                while ((temp = br.readLine()) != null) {
                    if (StringUtils.isNotBlank(temp)) {
                        str.append("\r\n").append(temp);
                    } else {
                        LoveWordsList.add(str.toString());
                        str = new StringBuilder();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJinJu() {
        Random random = new Random();
        return LoveWordsList.get(random.nextInt(LoveWordsList.size()));
    }

}
