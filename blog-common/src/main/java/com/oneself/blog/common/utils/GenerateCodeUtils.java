package com.oneself.blog.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 生成系统自增编码工具类

@Component
public class GenerateCodeUtils {

    @Autowired
    private SysSequenceMapper sysSequenceMapper;

    private static GenerateCodeUtils generateCodeUtils;

    @PostConstruct
    public void init(){
        generateCodeUtils = this;
        generateCodeUtils.sysSequenceMapper = this.sysSequenceMapper;
    }

    //生成编码
    public synchronized static String generateCode(GenerationCodeEnum codeEnum){

        String code = generateCodeUtils.sysSequenceMapper.generateCode(codeEnum.getValue());

        return code;
    }


}
 */