package com.touchkiss.kaikebaspider.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created on 2023/01/03 21:38
 *
 * @author Touchkiss
 */
@NoArgsConstructor
@Data
public class VideoDetailInfoResponse {

    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataDTO data;
    @SerializedName("forward_url")
    private String forwardUrl;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @SerializedName("config_data")
        private ConfigDataDTO configData;
        @SerializedName("jump_h5_url")
        private String jumpH5Url;
        @SerializedName("video_urls")
        private String videoUrls;
        @SerializedName("only_h5_play")
        private Integer onlyH5Play;
        @SerializedName("payment_url")
        private String paymentUrl;
        @SerializedName("video_player_type")
        private Integer videoPlayerType;
        @SerializedName("is_auto_play")
        private Integer isAutoPlay;
        @SerializedName("is_try")
        private Integer isTry;
        @SerializedName("product_try_info")
        private List<?> productTryInfo;
        @SerializedName("user_last_process")
        private Integer userLastProcess;
        @SerializedName("video_info")
        private VideoInfoDTO videoInfo;

        @NoArgsConstructor
        @Data
        public static class ConfigDataDTO {
            @SerializedName("1")
            private _$1DTO $1;
            @SerializedName("2")
            private _$2DTO $2;

            @NoArgsConstructor
            @Data
            public static class _$1DTO {
                @SerializedName("config_name")
                private String configName;
                @SerializedName("is_open")
                private Integer isOpen;
                @SerializedName("config_type")
                private Integer configType;
            }

            @NoArgsConstructor
            @Data
            public static class _$2DTO {
                @SerializedName("config_name")
                private String configName;
                @SerializedName("is_open")
                private Integer isOpen;
                @SerializedName("config_type")
                private Integer configType;
            }
        }

        @NoArgsConstructor
        @Data
        public static class VideoInfoDTO {
            @SerializedName("app_id")
            private String appId;
            @SerializedName("resource_id")
            private String resourceId;
            @SerializedName("video_length")
            private Integer videoLength;
            @SerializedName("file_name")
            private String fileName;
            @SerializedName("video_audio_url")
            private String videoAudioUrl;
            @SerializedName("patch_img_url")
            private String patchImgUrl;
            @SerializedName("patch_img_url_compressed")
            private String patchImgUrlCompressed;
            @SerializedName("can_select")
            private Integer canSelect;
            @SerializedName("is_drm")
            private Integer isDrm;
            @SerializedName("is_transcode")
            private Integer isTranscode;
            @SerializedName("is_report_video_status")
            private Boolean isReportVideoStatus;
            @SerializedName("resource_type")
            private Integer resourceType;
        }
    }
}
