package com.lwhtarena.cg.controller;

import com.lwhtarena.cg.entity.Result;
import com.lwhtarena.cg.entity.StatusCode;

/**
 * @author liwh
 * @Title: BaseExceptionHandler
 * @Package com.lwhtarena.cg.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/2 06:14
 */
@ControllerAdvice// 交给spring容器管理 标识是一个异常处理器
public class BaseExceptionHandler {
    //方法当被@requestMapingg注解修饰的方法 有 异常发生的时候 被调用

    // Exception.class 当  发生了 Exeption 异常以及它的子类的异常都被捕获到处理.

    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public Result handlerException(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }

  /*  @ExceptionHandler(value= aaa.class)
    public Result handlerException(){

    }

    @ExceptionHandler(value= bbb.class)
    public Result handlerException(){

    }*/
}
