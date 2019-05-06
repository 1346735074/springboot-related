package com.example.springmobile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: YAO
 * @date: 2018/11/2 13:51
 * @description:
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping("/")
    public String greeting(Device device) {

        String deviceType = "";
        String platform = "";

        if (device.isNormal()) {
            deviceType = "电脑设备";
        } else if (device.isMobile()) {
            deviceType = "移动手机";
        } else if (device.isTablet()) {
            deviceType = "平板电脑";
        }
        platform = device.getDevicePlatform().name();

        if (platform.equalsIgnoreCase("UNKNOWN")) {
            platform = "浏览器";
        }
        log.info("Client Device Type:【{}】,Platform:【{}】", deviceType, platform);
        return "123";
    }
}
