package com.touchkiss.kaikebaspider.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.touchkiss.kaikebaspider.bean.VideoDetailInfoResponse;
import com.touchkiss.kaikebaspider.bean.VideoUrlDetail;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created on 2022/11/05 23:10
 *
 * @author Touchkiss
 */
public class GetVideo {
    public static void main(String[] args) {
        String[] resourceIds = new String[]{
//                "v_62ecdda6e4b0c9426483cfe5",
//                "v_62ecdda7e4b050af23a559aa",
//                "v_62ecdda8e4b0a51fef090411",
                "v_62ecddaae4b050af23a559ae",
                "v_62ecddabe4b00a4f372fd9c5",
                "v_62ecddace4b0c9426483cfec",
                "v_62ecddade4b0eca59c1f2c6d",
                "v_62ecddafe4b0c9426483cff1",
                "v_62ecddb0e4b00a4f372fd9cb",
                "v_62ecddb1e4b00a4f372fd9d5",
                "v_62ecddb3e4b050af23a559b7",
                "v_62ecddb4e4b050af23a559b9",
                "v_62ecddb6e4b050af23a559bb",
                "v_62ecddb7e4b0a51fef09041f",
                "v_62ecddb8e4b00a4f372fd9de",
                "v_62ecddbae4b0c9426483cffa",
                "v_62ecddbbe4b0a51fef090422",
                "v_62ecddbce4b0a51fef090424",
                "v_62ecddbee4b0c9426483cffd",
                "v_62ecddbfe4b0c9426483d000",
                "v_62ecddc0e4b00a4f372fd9ed",
                "v_62ecddc2e4b0c9426483d036",
                "v_62ecddc3e4b0eca59c1f2c74",
                "v_62ecddc5e4b050af23a559c4",
                "v_62ecddc6e4b0c9426483d03b",
                "v_62ecddc7e4b050af23a559c6",
                "v_62ecddc9e4b050af23a559c9",
                "v_62ecddcae4b00a4f372fd9f5",
                "v_62ecddcce4b050af23a559ce",
                "v_62ecddcde4b00a4f372fd9f7",
                "v_62ecddcee4b0eca59c1f2c7d",
                "v_62ecddd0e4b0c9426483d041",
                "v_62ecddd1e4b050af23a559d7",
                "v_62ecddd2e4b0c9426483d043",
                "v_62ecddd4e4b0eca59c1f2c88",
                "v_62ecddd5e4b0eca59c1f2c8a",
                "v_62ecddd6e4b0eca59c1f2c8c",
                "v_62ecddd8e4b00a4f372fd9fe",
                "v_62ecddd9e4b0a51fef09044a",
                "v_62ecdddbe4b0c9426483d051",
                "v_62ecdddce4b00a4f372fda02",
                "v_62ecdddee4b0a51fef09044e",
                "v_62ecdddfe4b0a51fef090452",
                "v_62ecdde1e4b00a4f372fda08",
                "v_62ecdde2e4b0c9426483d060",
                "v_62ecdde4e4b00a4f372fda0c",
                "v_62ecdde5e4b00a4f372fda0f",
                "v_62ecdde6e4b00a4f372fda13",
                "v_62ecdde8e4b050af23a559f3",
                "v_62ecdde9e4b0eca59c1f2c9c",
                "v_62ece06be4b00a4f372fdc72",
                "v_62ece06ce4b050af23a55c26",
                "v_62ece06ee4b0eca59c1f2ee9",
                "v_62ece070e4b0a51fef090660",
                "v_62ece071e4b0a51fef090665",
                "v_62ece073e4b050af23a55c2d",
                "v_62ece074e4b0a51fef09066b",
                "v_62ee1f07e4b0c942648421a6",
                "v_62ee1f09e4b050af23a5ab15",
                "v_62ee1f0ae4b0eca59c1f7bf5"
        };

        for (String resourceId : resourceIds) {
            VideoUrlDetail videoDetailInfo = getVideoDetailInfo(resourceId, "p_62e9f8fbe4b0c9426482a91b", "");
            System.out.println(videoDetailInfo.getUrl());

            String uid = "u_635a25f4dc737_s1boE5ph8a";
            DownloadVideo.downloadM3u8(videoDetailInfo.getUrl(), videoDetailInfo.getMp4fileName(), videoDetailInfo.getExt().getHost(), videoDetailInfo.getExt().getPath(), videoDetailInfo.getExt().getParam(), uid);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
        }
    }

    static VideoUrlDetail getVideoDetailInfo(String resourceId, String productId, String cookie) {
        Gson gson = new Gson();
        String videoDetailsResponse = HttpUtil.createPost("https://xiaoe.kaikeba.com/xe.course.business.video.detail_info.get/2.0.0")
                .addHeaders(CookieContext.COMMON_HEADERS)
                .header("Accept", "application/json, text/plain, */*")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", cookie)
                .header("Referer", "https://xiaoe.kaikeba.com/p/t_pc/course_pc_detail/video/" + resourceId + "?product_id=" + productId + "&content_app_id=&type=6")
                .body("resource_id=" + resourceId + "&opr_sys=Win32&product_id=" + productId + "&content_app_id=")
                .execute().body();
        System.out.println(videoDetailsResponse);
        VideoDetailInfoResponse videoDetailInfoResponse = gson.fromJson(videoDetailsResponse, VideoDetailInfoResponse.class);
        if (videoDetailInfoResponse != null && videoDetailInfoResponse.getData() != null && StringUtils.isNoneBlank(videoDetailInfoResponse.getData().getVideoUrls())) {
            String ba = videoDetailInfoResponse.getData().getVideoUrls()
                    .replace("__ba", "").replaceAll("@", "1").replaceAll("#", "2").replaceAll("\\$", "3").replaceAll("%", "4");
            List<VideoUrlDetail> res = gson.fromJson(Base64.decodeStr(ba), new TypeToken<List<VideoUrlDetail>>() {
            }.getType());
            VideoUrlDetail videoUrlDetail = res.get(0);
            videoUrlDetail.setMp4fileName(videoDetailInfoResponse.getData().getVideoInfo().getFileName());
            return videoUrlDetail;
        }
        return null;
    }
}
