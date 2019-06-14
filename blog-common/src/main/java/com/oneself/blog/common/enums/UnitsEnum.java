package com.oneself.blog.common.enums;

/**
 * @Describe 单位转换枚举
 * @Author: liangjiayao
 * @Date: 2019/6/6 13:47
 * @Version 1.0
 */
public enum UnitsEnum {

    MM_MM("mm", "mm","1","毫米转毫米"),
    MM_CM("mm", "cm","0.1","毫米转厘米"),
    MM_M("mm", "m","0.001","毫米转米"),
    MM_IN("mm", "in","0.0393701","毫米转英寸"),
    MM_FT("mm", "ft","0.0032808","毫米转英尺"),
    CM_MM("cm", "mm","10","厘米转毫米"),
    CM_CM("cm", "cm","1","厘米转厘米"),
    CM_M("cm", "m","0.01","厘米转米"),
    CM_IN("cm", "in","0.3937008","厘米转英寸"),
    CM_FT("cm", "ft","0.0328084","厘米转英尺"),
    M_MM("m", "mm","1000","米转毫米"),
    M_CM("m", "cm","100","米转厘米"),
    M_M("m", "m","1","米转米"),
    M_IN("m", "in","39.3700787","米转英寸"),
    M_FT("m", "ft","3.2808399","米转英尺"),
    IN_MM("in", "mm","25.4","英寸转毫米"),
    IN_CM("in", "cm","2.54","英寸转厘米"),
    IN_M("in", "m","0.0254","英寸转米"),
    IN_IN("in", "in","1","英寸转英寸"),
    IN_FT("in", "ft","0.0833333","英寸转英尺"),
    FT_MM("ft", "mm","304.8","英尺转毫米"),
    FT_CM("ft", "cm","30.48","英尺转厘米"),
    FT_M("ft", "m","0.3048","英尺转米"),
    FT_IN("ft", "in","12","英尺转英寸"),
    FT_FT("ft", "ft","1","英尺转英尺"),
    G_G("g", "g","1","转克"),
    G_KG("g", "kg","0.001","转千克"),
    G_OZ("g", "oz","0.035274","转盎司"),
    G_LB("g", "lb","0.0022046","转磅"),
    KG_G("kg", "g","1000", "转克"),
    KG_KG("kg", "kg","1","转千克"),
    KG_OZ("kg", "oz","35.2739619","转盎司"),
    KG_LB("kg", "lb","2.2046226","转磅"),
    OZ_G("oz", "g","28.3495231","转克"),
    OZ_KG("oz", "kg","0.0283495","转千克"),
    OZ_OZ("oz", "oz","1","转盎司"),
    OZ_LB("oz", "lb","0.0625","转磅"),
    LB_G("lb", "g","453.59237","转克"),
    LB_KG("lb", "kg","0.4535924","转千克"),
    LB_OZ("lb", "oz","16","转盎司"),
    LB_LB("lb", "lb","1","转磅");

    private String basic;
    private String target;
    private String plural;
    private String name;

    UnitsEnum(String basic, String target, String plural, String name) {
        this.basic = basic;
        this.target = target;
        this.plural = plural;
        this.name = name;
    }


    public String getBasic() {
        return basic;
    }

    public String getTarget() {
        return target;
    }

    public String getPlural() {
        return plural;
    }

    public String getName() {
        return name;
    }
}
