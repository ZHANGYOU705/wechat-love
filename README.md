# 微信每日早安问候（用微信传递爱情）

### 点击获取[Gitee](https://gitee.com/ZHANGYOU705/wechat-love) 源码

### API申请

##### 天气
[百度天气API](https://lbsyun.baidu.com/apiconsole/center#/home)
##### 情话
[彩虹屁API](https://www.tianapi.com/apiview/181)
##### 微信测试号
[微信测试账号](https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login)

### 修改配置文件
在这个文件`src/main/resources/application.yml`把prod改为dev

在这个文件`src/main/resources/application-dev.yml`填写你申请的秘钥

### 定时发送时间

如果想修改定时时间，找到
`src/main/java/cn/zhangyou705/wechatlove/task/WeChatPushJob.java`
更改你想要的cron表达式即可：[在线cron工具](https://cron.qqe2.com/)

### 启动
找到Application.java直接运行即可