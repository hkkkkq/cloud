package com.lwhtarena.glmall.product.exception;

import com.lwhtarena.common.exception.BizCodeEnume;
import com.lwhtarena.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liwh
 * @Title: GulimallExceptionControllerAdvice
 * @Package com.lwhtarena.glmall.product.exception
 * @Description: 集中处理所有异常
 *  @ResponseBody + @ControllerAdvice = @ControllerAdvice
 * @Version 1.0.0
 * @date 2020/7/28 12:47
 */

//@ResponseBody
//@ControllerAdvice(basePackages = "com.lwhtarena.glmall.product.controller")

@Slf4j
@RestControllerAdvice(basePackages = "com.lwhtarena.glmall.product.controller")
public class GulimallExceptionControllerAdvice {


    /**
     * 精确匹配
     * @param e
     * @return
     */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String,String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError)->{
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(),BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data",errorMap);
    }

    /**
     * 匹配不了的异常，全往这边抛出
     * @param throwable
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){

        log.error("错误：",throwable);
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }


}
