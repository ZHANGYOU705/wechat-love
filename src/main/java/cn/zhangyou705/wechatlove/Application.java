package cn.zhangyou705.wechatlove;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ZhangYou
 * @description
 * @date 2022/8/23
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        log.info("          ___           ___           ___           ___           ___                                ___           ___  ");
        log.info("         /\\__\\         /\\  \\         /\\  \\         /\\  \\         /\\__\\                              /\\  \\         /\\  \\ ");
        log.info("        /::|  |        \\:\\  \\       /::\\  \\        \\:\\  \\       /:/ _/_                  ___       /::\\  \\        \\:\\  \\ ");
        log.info("       /:/:|  |         \\:\\  \\     /:/\\:\\  \\        \\:\\  \\     /:/ /\\  \\                /|  |     /:/\\:\\  \\        \\:\\  \\ ");
        log.info("      /:/|:|  |__   ___ /::\\  \\   /:/ /::\\  \\   _____\\:\\  \\   /:/ /::\\  \\              |:|  |    /:/  \\:\\  \\   ___  \\:\\  \\ ");
        log.info("     /:/ |:| /\\__\\ /\\  /:/\\:\\__\\ /:/_/:/\\:\\__\\ /::::::::\\__\\ /:/__\\/\\:\\__\\             |:|  |   /:/__/ \\:\\__\\ /\\  \\  \\:\\__\\ ");
        log.info("     \\/__|:|/:/  / \\:\\/:/  \\/__/ \\:\\/:/  \\/__/ \\:\\~~\\~~\\/__/ \\:\\  \\ /:/  /           __|:|__|   \\:\\  \\ /:/  / \\:\\  \\ /:/  / ");
        log.info("         |:/:/  /   \\::/__/       \\::/__/       \\:\\  \\        \\:\\  /:/  /           /::::\\  \\    \\:\\  /:/  /   \\:\\  /:/  / ");
        log.info("         |::/  /     \\:\\  \\        \\:\\  \\        \\:\\  \\        \\:\\/:/  /            ~~~~\\:\\  \\    \\:\\/:/  /     \\:\\/:/  / ");
        log.info("         |:/  /       \\:\\__\\        \\:\\__\\        \\:\\__\\        \\::/  /                  \\:\\__\\    \\::/  /       \\::/  / ");
        log.info("         |/__/         \\/__/         \\/__/         \\/__/         \\/__/                    \\/__/     \\/__/         \\/__/ ");

        System.out.println("启动成功！！！更多精彩，请关注佑佑学习网：https://www.zhangyou705.cn/");
    }

}
