package com.touchkiss.kaikebaspider.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created on 2022/11/05 22:33
 *
 * @author Touchkiss
 */
@NoArgsConstructor
@Data
public class GoodsItem {
    private List<?> resourceList;
    private String appId;
    private String resourceId;
    private String title;
    private String imgUrl;
    private String imgUrlCompress;
    private String startAt;
    private String tryM3u8Url;
    private String tryAudioUrl;
    private String audioUrl;
    private String audioM3u8Url;
    private String audioCompressUrl;
    private String videoUrl;
    private String videoM3u8Url;
    private Integer resourceType;
    private Integer viewCount;
    private Integer commentCount;
    private Integer isTry;
    private Integer canView;
    private Integer audioLength;
    private Integer videoLength;
    private Integer isPartTry;
    private String partTryUrl;
    private String partTryM3u8Url;
    private Integer partTryLength;
    private Integer paymentType;
    private String redirectUrl;
}
