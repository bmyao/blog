package com.oneself.blog.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * 生成系统自增编码工具类
 */
public class GenerateCodeUtils {


    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    /**
     * 生成8位UUID
     * @return 8位UUID
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /*
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
    */

}
