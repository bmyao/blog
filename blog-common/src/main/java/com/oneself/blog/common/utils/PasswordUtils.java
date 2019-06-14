/**
 * @Author: guohuaming
 * @Date: 2019/3/8 9:08
 * @Version 1.0
 */
package com.oneself.blog.common.utils;


import com.oneself.blog.common.constant.CommonConst;

/**
 * @Describe 密码加密类
 * @Author: liangjiayao
 * @Date: 2019/6/12 17:48
 * @Version 1.0
 */
public class PasswordUtils {

    /**
     * AES 加密
     *  @param username
     * @param password
     *         未加密的密码
     *         盐值，默认使用用户名就可
     * @return
     * @throws Exception
     */
    public static String encrypt(String username, String password) {
        return AesUtils.encrypt(Md5Utils.MD5(username.toLowerCase() + CommonConst.PW_SECURITY_KEY), password);
    }

    /**
     * AES 解密
     * @param encryptPassword
     *         加密后的密码
     * @param username
     *         盐值，默认使用用户名就可
     * @return
     * @throws Exception
     */
    public static String decrypt(String username,String encryptPassword) throws Exception {
        return AesUtils.decrypt(Md5Utils.MD5(username.toLowerCase() + CommonConst.PW_SECURITY_KEY), encryptPassword);
    }

    public static void main(String[] args) throws Exception {

        System.out.println(PasswordUtils.encrypt("DYTXJL", "123456"));

        System.out.println(PasswordUtils.decrypt("sadmin","LYmiZV4krJQaHZ0M9v/JXw=="));

    }
}
