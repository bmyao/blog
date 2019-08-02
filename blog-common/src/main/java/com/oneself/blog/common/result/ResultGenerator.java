package com.oneself.blog.common.result;

import com.oneself.blog.common.enums.ResultCodeEnum;

/**
 * @Describe    结果返回类
 * @Author: liangjiayao
 * @Date: 2019/8/2 11:33
 * @Version 1.0
 */
public class ResultGenerator {

    /**
     * 返回成功
     **/
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * @Author liangjiayao
     * @Description 成功不返回参数
     * @Date 2019/8/2 11:49
     * @Param []
     * @return com.oneself.blog.common.result.Result
     **/
    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * @Author liangjiayao
     * @Description 成功返回参数
     * @Date 2019/8/2 11:49
     * @Param [data]
     * @return com.oneself.blog.common.result.Result
     **/
    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    /**
     * @Author liangjiayao
     * @Description 失败不返回原因
     * @Date 2019/8/2 11:50
     * @Param [message]
     * @return com.oneself.blog.common.result.Result
     **/
    public static Result genFailResult() {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setMessage(ResultCodeEnum.FAIL.getName());
        return result;
    }

    /**
     * @Author liangjiayao
     * @Description 失败返回原因
     * @Date 2019/8/2 11:50
     * @Param [message]
     * @return com.oneself.blog.common.result.Result
     **/
    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setMessage(message);
        return result;
    }
}
