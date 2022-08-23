# Wechat daily good morning greetings (use wechat to convey love)

Wechat official account article tutorial: https://mp.weixin.qq.com/s/v3adYcM26pk-5hDg36kU3w
Video tutorial: hold on, recording

### Click to get [gitee](https://gitee.com/ZHANGYOU705/wechat-love)Source code

### API Application

##### Weather
[Baidu weather API](https://lbsyun.baidu.com/apiconsole/center#/home)
##### Love words
[rainbow fart API](https://www.tianapi.com/apiview/181)
##### Wechat test number
[wechat test account](https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login)

### Modify profile
In the file ` Src / main / resources / application. YML ', change prod to dev

Fill in the secret key you applied for in the file 'Src / main / resources / application dev.yml'

### Scheduled transmission time
If you want to modify the timing time, find
`src/main/java/cn/zhangyou705/wechatlove/task/WeChatPushJob.java`
Change the cron expression you want: [Online cron tool](https://cron.qqe2.com/)

### Start
Find application.java and run it directly