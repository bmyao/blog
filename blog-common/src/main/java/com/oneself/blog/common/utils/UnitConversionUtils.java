package com.oneself.blog.common.utils;

import com.oneself.blog.common.enums.UnitsEnum;

import java.math.BigDecimal;

/**
 * @Describe 单位转换utils
 * @Author: liangjiayao
 * @Date: 2019/6/6 13:47
 * @Version 1.0
 */
public class UnitConversionUtils {

    /**
     * @Author liangjiayao
     * @Description 获取单位转换率
     * @Date 2019/6/6 11:56
     * @param enumClass 枚举类
     * @param basic 基础单位
     * @param target 目标单位
     **/
    private static <T extends UnitsEnum> T getByPlural(Class<T> enumClass, String basic, String target) {
        //通过反射取出Enum所有常量的属性值
        for (T each: enumClass.getEnumConstants()) {
            //循环比较，获取对应的枚举
            if (basic.equals(each.getBasic())) {
                if (target.equals(each.getTarget())) {
                    return each;
                }
            }
        }
        return null;
    }

    /**
     * @Author liangjiayao
     * @Description 单位转换
     * @Date 2019/6/6 13:59
     * @Param basicWeightUnit 原始单位
     * @Param targetWeightUnit 转换单位
     * @Param value 转换值
     * @return java.math.BigDecimal
     **/
    public static BigDecimal doConvert(String basicWeightUnit, String targetWeightUnit, BigDecimal value) {
        return doConvert(basicWeightUnit,targetWeightUnit,value,3, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/6/6 14:00
     * @Param basicWeightUnit 原始单位
     * @Param targetWeightUnit 转换单位
     * @Param value 转换值
     * @return java.math.BigDecimal
     **/
    public static BigDecimal doConvert(String basicWeightUnit, String targetWeightUnit, double value) {
        return doConvert(basicWeightUnit,targetWeightUnit,new BigDecimal(value),3, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/6/6 14:00
     * @Param basicWeightUnit 原始单位
     * @Param targetWeightUnit 转换单位
     * @Param value 转换值
     * @Param number 保留小数位
     * @return java.math.BigDecimal
     **/
    public static BigDecimal doConvert(String basicWeightUnit, String targetWeightUnit, BigDecimal value, int number) {
        return doConvert(basicWeightUnit,targetWeightUnit,value,number, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/6/6 14:00
     * @Param basicWeightUnit 原始单位
     * @Param targetWeightUnit 转换单位
     * @Param value 转换值
     * @Param number 保留小数位
     * @return java.math.BigDecimal
     **/
    public static BigDecimal doConvert(String basicWeightUnit, String targetWeightUnit, double value, int number) {
        return doConvert(basicWeightUnit,targetWeightUnit,new BigDecimal(value),number, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/6/6 14:00
     * @Param basicWeightUnit 原始单位
     * @Param targetWeightUnit 转换单位
     * @Param value 转换值
     * @Param number 保留小数位
     * @Param scale 小数位规则
     * @return java.math.BigDecimal
     **/
    public static BigDecimal doConvert(String basicWeightUnit, String targetWeightUnit, BigDecimal value, int number,int scale) {
        if (basicWeightUnit == null || basicWeightUnit.equals("")) {
            return BigDecimal.valueOf(0);
        }
        if (targetWeightUnit == null || targetWeightUnit.equals("")) {
            return BigDecimal.valueOf(0);
        }
        if (value == null) {
            return BigDecimal.valueOf(0);
        }
        BigDecimal plural = new BigDecimal(getByPlural(UnitsEnum.class,basicWeightUnit, targetWeightUnit).getPlural());
        if (plural == null) {
            return BigDecimal.valueOf(0);
        }
        return plural.multiply(value).setScale(number,scale);
    }


}
