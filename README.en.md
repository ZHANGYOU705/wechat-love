# Wechat daily good morning greetings (use wechat to convey love)

1. Wechat official account article tutorial: https://mp.weixin.qq.com/s/v3adYcM26pk-5hDg36kU3w
2. Video tutorial:
   - Video number --> can only be opened by mobile phone: https://weixin.qq.com/sph/Alhazw
   - Station B: https://www.bilibili.com/video/BV1VP41157Z7

### Click to get [gitee](https://gitee.com/ZHANGYOU705/wechat-love)Source code
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/1.png)
### API Application

##### Weather
[Baidu weather API](https://lbsyun.baidu.com/apiconsole/center#/home)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/2.png)
##### Love words
[rainbow fart API](https://www.tianapi.com/apiview/181)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/3.png)
##### Wechat test number
[wechat test account](https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/4.png)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/5.png)

### Modify profile
In the file ` Src / main / resources / application. YML ', change prod to dev

Fill in the secret key you applied for in the file 'Src / main / resources / application dev.yml'

### Scheduled transmission time
If you want to modify the timing time, find
`src/main/java/cn/zhangyou705/wechatlove/task/WeChatPushJob.java`
Change the cron expression you want: [Online cron tool](https://cron.qqe2.com/)

### Start
Find application.java and run it directly
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/6.png)

## Technical support
佑佑学习网: https://www.zhangyou705.cn/