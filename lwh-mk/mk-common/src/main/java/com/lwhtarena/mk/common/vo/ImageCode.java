package com.lwhtarena.mk.common.vo;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liwh
 * @Title: ImageCode
 * @Package com.lwhtarena.mk.common.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 17:58
 */
@Data
public class ImageCode implements Serializable {
    private String code;

    private LocalDateTime expireTime;

    private BufferedImage image;

    public ImageCode(BufferedImage image, String sRand, int defaultImageExpire) {
        this.image = image;
        this.code = sRand;
        this.expireTime = LocalDateTime.now().plusSeconds(defaultImageExpire);
    }
}
