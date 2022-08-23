package cn.zhangyou705.wechatlove.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangYou
 * @description
 * @date 2022/8/23
 */
public class DateCompareUtil {

    public static int getLicense(String getLicense) {
        return before(getLicense);
    }

    public static int getLoveStart(String loveStart) {
        return after(loveStart);
    }

    public static int getBirthdayToYou(String birthdayToYou) {
        return before(birthdayToYou);
    }

    /**
     * 距离date还有多少天
     *
     * @param tarDate
     * @return
     */
    public static int before(String tarDate) {
        long between = 0;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(tarDate);
            between = DateUtil.between(parse, new Date(), DateUnit.DAY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) between;
    }


    /**
     * 已经过去date多少天
     *
     * @param oriDate
     * @return
     */
    public static int after(String oriDate) {
        Date parse = null;
        try {
            parse = new SimpleDateFormat("yyyy-MM-dd").parse(oriDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long between = DateUtil.between(parse, new Date(), DateUnit.DAY);
        return (int) between;
    }
}
