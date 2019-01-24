package com.demo.ant.handler;

import com.demo.ant.enums.ResultEnum;
import com.demo.ant.utils.ResultVOUtil;
import com.demo.ant.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/15 13:45
 * @description: 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultVO handle(Exception e){
        log.error("系统异常",e);
        return ResultVOUtil.error(ResultEnum.EXCEPTION);
    }

}
