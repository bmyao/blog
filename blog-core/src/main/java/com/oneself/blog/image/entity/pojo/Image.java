package com.oneself.blog.image.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Image {

    /**
     * 图片ID
     */
    private Integer imageId;

    /**
     * 图片名称
     */
    private String imageName;

    /**
     * 图片URL
     */
    private String imageUrl;

    /**
     * 图片描述
     */
    private String imageDescription;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 上传IP
     */
    private String uploadIp;

    /**
     * 上传人
     */
    private Integer uploadUser;

}