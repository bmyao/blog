/**
 * MIT License
 * Copyright (c) 2018 yadong.zhang
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oneself.blog.common.constant;

/**
 * @Describe 程序中公用的常量类
 * @Author: liangjiayao
 * @Date: 2019/6/6 13:47
 * @Version 1.0
 */
public class CommonConst {

    /**
     * 安全密码(UUID生成)，作为盐值用于用户密码的加密
     */
    public static final String PW_SECURITY_KEY = "842513f8f16498s8b0a531045453e1f1";


    /**
     * 安全密码(UUID生成)，作为盐值用于生成user_token的加密
     */
    public static final String USER_TOKEN_KEY = "8edf16498f8f16454e8b0a52dfdo15qhj1";

}
