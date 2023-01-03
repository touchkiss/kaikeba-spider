package com.touchkiss.kaikebaspider.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2023/01/03 21:55
 *
 * @author Touchkiss
 */
@NoArgsConstructor
@Data
public class VideoUrlDetail {

    @SerializedName("definition_name")
    private String definitionName;
    @SerializedName("definition_p")
    private String definitionP;
    @SerializedName("url")
    private String url;
    @SerializedName("is_support")
    private Boolean isSupport;

    private String mp4fileName;
    @SerializedName("ext")
    private ExtDTO ext;

    @NoArgsConstructor
    @Data
    public static class ExtDTO {
        @SerializedName("host")
        private String host;
        @SerializedName("path")
        private String path;
        @SerializedName("param")
        private String param;
    }
}
