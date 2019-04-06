package com.example.xmlconvertjson.listener;

import com.example.xmlconvertjson.entity.Manifest_XML.Transmission;
import com.example.xmlconvertjson.utils.FileConvertByte;
import com.example.xmlconvertjson.utils.XStreamUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/16 12:17
 * @description: 文件监听器
 */
@Data
@Slf4j
@Component
public class ResourceListener {

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    private WatchService ws;
    private String listenerPath;

    public ResourceListener(String path) {
        try {
            ws = FileSystems.getDefault().newWatchService();
            this.listenerPath = path;
            fixedThreadPool.execute(new Listner(ws,this.listenerPath));
            log.info("【文件监控】 初始化成功");
        } catch (IOException e) {
            log.info("【文件监控】 启动异常 {}",e);
        }
    }
}
@Slf4j
class Listner implements Runnable {
    private WatchService service;
    private String rootPath;

    public Listner(WatchService service, String rootPath) {
        this.service = service;
        this.rootPath = rootPath;
    }

    public void run() {
        try {
            while (true) {
                log.info("正在监控=========");
                WatchKey watchKey = service.take();
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                for (WatchEvent<?> event : watchEvents) {
                    //TODO 根据事件类型采取不同的操作
                    log.info("【文件监控】 [{}][{}] 文件发生了 [{}]事件", rootPath, event.context(), event.kind());
                    //读取文件
                    File file = new File(rootPath + "\\" + event.context());
                    byte[] bytes = FileConvertByte.fileConverByte(file);
                    //创建事件
                    if (event.kind().name().equals("ENTRY_CREATE")) {
                        //转为对象
                        Transmission transmission = XStreamUtil.toBean(Transmission.class,new String(bytes));
                        log.info(new String(bytes));
                    }
                    //修改事件
                    if (event.kind().name().equals("ENTRY_MODIFY")) {
//                        log.info(new String(bytes));
                    }
                    //删除事件
                    if (event.kind().name().equals("ENTRY_DELETE")) {
//                        log.info(new String(bytes));
                    }
                }
                watchKey.reset();
            }
        } catch (InterruptedException | IOException e) {
            log.info("finally catch=========");
            e.printStackTrace();
        } finally {
            try {
                log.info("finally=========");
                //关闭监控
                service.close();
                //启动监控
            } catch (IOException e) {
                log.info("finally catch=========");
                e.printStackTrace();
            }
        }

    }
}
