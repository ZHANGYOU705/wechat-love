package cn.zhangyou705.wechatlove.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ZhangYou
 * @description
 * @date 2022/8/23
 */
public class DateCompareUtil {

    public static void main(String[] args) {

        System.out.println(getLicense("2022-08-21"));
        System.out.println(getLicense("2022-08-24"));
        System.out.println(getLicense("2022-08-27"));

    }


    public static String getLicense(String getLicense) {
        int result = after(getLicense);
        return result > 0 ? "我们已经成为合法夫妻" + result + "天了"
                : result == 0 ? "今天我们领证啦~" : "好期待与你一起的岁岁年年~";
    }

    public static String getLoveStart(String loveStart) {
        int result = after(loveStart);
        return result > 0 ? "今天是我们恋爱的第" + result + "天" : "亲爱的，我会一直守护你";
    }

    public static String getBirthdayToYou(String birthdayToYou) {
        int result = everyDayOfYear(birthdayToYou);
        return result == 0 ? "亲爱的，今天是你的生日呀~" : "距离你的生日还有：" + result + "天";
    }

    /**
     * 计算每年今日
     *
     * @param oriDate
     * @return
     */
    public static int everyDayOfYear(String oriDate) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cToday = Calendar.getInstance();
        Calendar cBirth = Calendar.getInstance();
        try {
            cBirth.setTime(myFormatter.parse(oriDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR));
        int days;
        if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
            // 今年的目标日期已经过了，要算明年的了
            days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
            days += cBirth.get(Calendar.DAY_OF_YEAR);
        } else {
            // 今年的目标日期还没过
            days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
        }
        return days;
    }


    /**
     * 计算两日期差距
     *
     * @param oriDate
     * @return
     */
    public static int after(String oriDate) {
        long between = 0;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(oriDate);
            between = DateUtil.between(parse, new Date(), DateUnit.DAY, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) between;
    }
}
