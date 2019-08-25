package com.oneself.blog.system.code.service.impl;

import com.oneself.blog.common.constant.RedisLockKeyConst;
import com.oneself.blog.common.enums.GenerateCodeEnum;
import com.oneself.blog.common.enums.SuffixStatus;
import com.oneself.blog.system.code.dao.CodeMapper;
import com.oneself.blog.system.code.entity.vo.CodeVO;
import com.oneself.blog.system.code.service.CodeService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/5 18:05
 * @Version 1.0
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeMapper codeMapper;

    @Resource
    private RedissonClient redisson;

    /**
     * @Author liangjiayao
     * @Description 数据库生成编号
     * @Date 2019/8/6 10:13
     * @Param [codeEnum]
     * @return java.lang.String
     **/
    @Override
    @Transactional
    public String getCode(GenerateCodeEnum codeEnum) {
        //生成公平锁，会排序等待
        RLock fairLock = redisson.getFairLock(RedisLockKeyConst.CODE_LOCK_KEY +"-"+ codeEnum.getValue());
        try {
            //10秒解除锁
            fairLock.expire(10, TimeUnit.SECONDS);
            fairLock.lock();
            CodeVO code = codeMapper.findCode(codeEnum.getValue());
            if (Objects.isNull(code)) {
                throw new RuntimeException(String.format("生成编号失败，请初始化:%s!", codeEnum.getValue()));
            }
            String sequenceNo;
            Long currentValue = code.getCodeValue() + code.getIncreaseValue();
            if (SuffixStatus.NO_SUFFIX.getValue().equals(code.getCodeValue())) {
                sequenceNo = code.getCodePrefix() + currentValue;
            } else if(SuffixStatus.RANDOM_FOUR_NUMBER_SUFFIX.getValue().equals(code.getCodeValue())){
                sequenceNo = code.getCodePrefix() + currentValue + (int) ((Math.random() * 9 + 1) * 1000);
            } else if(SuffixStatus.SQL_SUFFIX.getValue().equals(code.getCodeValue())){
                sequenceNo = code.getCodePrefix() + currentValue + code.getCodeSuffix();
            } else{
                sequenceNo = code.getCodePrefix() + currentValue;
            }
            codeMapper.updateCode(codeEnum.getValue());
            return sequenceNo;
        } finally {
            //解除锁
            if(fairLock.isExists() && fairLock.isLocked()) {
                fairLock.unlock();
            }
        }
    }
}
