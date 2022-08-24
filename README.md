# 微信每日早安问候（用微信传递爱情）
1、微信公众号文章教程：https://mp.weixin.qq.com/s/v3adYcM26pk-5hDg36kU3w

2、视频教程：
 - 视频号-->只能手机打开：https://weixin.qq.com/sph/Alhazw
 - B站：https://www.bilibili.com/video/BV1VP41157Z7

### 点击获取[Gitee](https://gitee.com/ZHANGYOU705/wechat-love) 源码
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/1.png)
### API申请

##### 天气
[百度天气API](https://lbsyun.baidu.com/apiconsole/center#/home)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/2.png)
##### 情话
[彩虹屁API](https://www.tianapi.com/apiview/181)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/3.png)
##### 微信测试号
[微信测试账号](https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/4.png)
![](https://img-yyxxw.zhangyou705.cn/2022/08/23/5.png)
### 修改配置文件
在这个文件`src/main/resources/application.yml`把prod改为dev

在这个文件`src/main/resources/application-dev.yml`填写你申请的秘钥

### 定时发送时间

如果想修改定时时间，找到
`src/main/java/cn/zhangyou705/wechatlove/task/WeChatPushJob.java`
更改你想要的cron表达式即可：[在线cron工具](https://cron.qqe2.com/)

### 启动
找到Application.java直接运行即可

![](https://img-yyxxw.zhangyou705.cn/2022/08/23/6.png)

## 优化
对模板内容做了优化，采取变量的方式，按需替换

![](https://img-yyxxw.zhangyou705.cn/2022/08/23/7.png)

模板文件获取：src/main/resources/templates/模板.txt

## 如何获取最新的代码
点击star，然后点击fork

![](https://img-yyxxw.zhangyou705.cn/2022/08/23/10.png)

Fork到你的仓库之后，再点击这个同步按钮，当我有更新的时候，会同步给你哦！

![](https://img-yyxxw.zhangyou705.cn/2022/08/23/9.png)

## 技术支持
佑佑学习网：https://www.zhangyou705.cn/