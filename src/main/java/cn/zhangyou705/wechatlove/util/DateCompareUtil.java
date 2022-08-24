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

        System.out.println(getBirthdayToYou("2021-01-11"));
        System.out.println(getBirthdayToYou("2022-08-24"));
        System.out.println(getBirthdayToYou("2008-06-27"));

    }


    public static int getLicense(String getLicense) {
        return after(getLicense);
    }

    public static int getLoveStart(String loveStart) {
        return after(loveStart);
    }

    public static int getBirthdayToYou(String birthdayToYou) {
        return everyDayOfYear(birthdayToYou);
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
