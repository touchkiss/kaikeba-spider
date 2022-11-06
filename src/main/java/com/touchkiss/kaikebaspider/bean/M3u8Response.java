package com.touchkiss.kaikebaspider.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Created on 2022/11/05 23:12
 *
 * @author Touchkiss
 */

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Data
public class M3u8Response extends BaseResponse<M3u8Response.M3u8Details>{

    @NoArgsConstructor
    @Data
    public static class M3u8Details {
        @SerializedName("seo_description")
        private String seoDescription;
        @SerializedName("app_id")
        private String appId;
        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("img_url")
        private String imgUrl;
        @SerializedName("img_url_compressed")
        private String imgUrlCompressed;
        @SerializedName("start_at")
        private String startAt;
        @SerializedName("stop_at")
        private Object stopAt;
        @SerializedName("state")
        private Integer state;
        @SerializedName("old_recycle_bin_state")
        private Integer oldRecycleBinState;
        @SerializedName("sell_mode")
        private Integer sellMode;
        @SerializedName("view_count")
        private Integer viewCount;
        @SerializedName("finish_count")
        private Integer finishCount;
        @SerializedName("period")
        private Integer period;
        @SerializedName("payment_type")
        private Integer paymentType;
        @SerializedName("is_stop_sell")
        private Integer isStopSell;
        @SerializedName("have_password")
        private Integer havePassword;
        @SerializedName("is_public")
        private Integer isPublic;
        @SerializedName("img_size_total")
        private Double imgSizeTotal;
        @SerializedName("video_audio_url")
        private String videoAudioUrl;
        @SerializedName("part_try_url")
        private String partTryUrl;
        @SerializedName("video_mp4_size")
        private Integer videoMp4Size;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("part_try_m3u8_url")
        private String partTryM3u8Url;
        @SerializedName("video_mp4_high_size")
        private Integer videoMp4HighSize;
        @SerializedName("can_select")
        private Integer canSelect;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("video_size")
        private Double videoSize;
        @SerializedName("is_transcode")
        private Integer isTranscode;
        @SerializedName("part_try_length")
        private Integer partTryLength;
        @SerializedName("patch_img_url_compressed")
        private String patchImgUrlCompressed;
        @SerializedName("img_url_compressed_larger")
        private String imgUrlCompressedLarger;
        @SerializedName("is_drm")
        private Integer isDrm;
        @SerializedName("file_name")
        private String fileName;
        @SerializedName("descrb")
        private String descrb;
        @SerializedName("video_length")
        private Integer videoLength;
        @SerializedName("is_part_try")
        private Integer isPartTry;
        @SerializedName("patch_img_url")
        private String patchImgUrl;
        @SerializedName("shop_id")
        private String shopId;
        @SerializedName("org_content")
        private String orgContent;
        @SerializedName("file_id")
        private String fileId;
        @SerializedName("resource_id")
        private String resourceId;
        @SerializedName("video_mp4_vbitrate")
        private Integer videoMp4Vbitrate;
        @SerializedName("video_mp4_high_vbitrate")
        private Integer videoMp4HighVbitrate;
        @SerializedName("audio_compress_size")
        private Integer audioCompressSize;
        @SerializedName("audio_compress_url")
        private String audioCompressUrl;
        @SerializedName("audio_length")
        private Integer audioLength;
        @SerializedName("audio_size")
        private Integer audioSize;
        @SerializedName("audio_url")
        private String audioUrl;
        @SerializedName("content")
        private String content;
        @SerializedName("epub_catalog")
        private String epubCatalog;
        @SerializedName("epub_opf")
        private String epubOpf;
        @SerializedName("epub_url")
        private String epubUrl;
        @SerializedName("file_from")
        private Integer fileFrom;
        @SerializedName("finished_state")
        private Integer finishedState;
        @SerializedName("is_member")
        private Integer isMember;
        @SerializedName("is_sequence")
        private Integer isSequence;
        @SerializedName("is_try")
        private Integer isTry;
        @SerializedName("manual_stop_at")
        private String manualStopAt;
        @SerializedName("member_type")
        private Integer memberType;
        @SerializedName("name")
        private String name;
        @SerializedName("opf_catalog")
        private String opfCatalog;
        @SerializedName("org_summary")
        private String orgSummary;
        @SerializedName("push_state")
        private Integer pushState;
        @SerializedName("resource_count")
        private Integer resourceCount;
        @SerializedName("resource_password")
        private String resourcePassword;
        @SerializedName("rewind_time")
        private String rewindTime;
        @SerializedName("room_id")
        private String roomId;
        @SerializedName("summary")
        private String summary;
        @SerializedName("total_chapters")
        private Integer totalChapters;
        @SerializedName("total_size")
        private Integer totalSize;
        @SerializedName("try_audio_length")
        private Integer tryAudioLength;
        @SerializedName("try_audio_url")
        private String tryAudioUrl;
        @SerializedName("try_chapters")
        private Integer tryChapters;
        @SerializedName("try_content")
        private String tryContent;
        @SerializedName("try_epub_opf")
        private String tryEpubOpf;
        @SerializedName("try_file_name")
        private String tryFileName;
        @SerializedName("try_m3u8_url")
        private String tryM3u8Url;
        @SerializedName("try_org_content")
        private String tryOrgContent;
        @SerializedName("zb_start_at")
        private String zbStartAt;
        @SerializedName("zb_stop_at")
        private String zbStopAt;
        @SerializedName("update_state")
        private Integer updateState;
        @SerializedName("resource_type")
        private Integer resourceType;
        @SerializedName("goods_id")
        private String goodsId;
        @SerializedName("goods_type")
        private Integer goodsType;
        @SerializedName("is_sale")
        private Integer isSale;
        @SerializedName("stop_sale")
        private Integer stopSale;
        @SerializedName("price")
        private Integer price;
        @SerializedName("line_price")
        private Integer linePrice;
        @SerializedName("piece_price")
        private Integer piecePrice;
        @SerializedName("author")
        private String author;
        @SerializedName("sell_type")
        private Integer sellType;
        @SerializedName("purchase_count")
        private Integer purchaseCount;
        @SerializedName("stock")
        private Integer stock;
        @SerializedName("content_type")
        private Integer contentType;
        @SerializedName("length")
        private Integer length;
        @SerializedName("alive_status")
        private Integer aliveStatus;
        @SerializedName("catalog")
        private String catalog;
        @SerializedName("comment_count")
        private Integer commentCount;
        @SerializedName("update_status")
        private Integer updateStatus;
        @SerializedName("recycle_bin_state")
        private Integer recycleBinState;
        @SerializedName("visible_on")
        private Integer visibleOn;
        @SerializedName("alive_type")
        private Integer aliveType;
        @SerializedName("has_buy")
        private Integer hasBuy;
        @SerializedName("zb_start_rest_time")
        private Integer zbStartRestTime;
        @SerializedName("is_company")
        private Integer isCompany;
        @SerializedName("audio_play_time")
        private Integer audioPlayTime;
        @SerializedName("audio_play_count")
        private Integer audioPlayCount;
        @SerializedName("member_unit")
        private String memberUnit;
        @SerializedName("member_expire_time")
        private String memberExpireTime;
        @SerializedName("time_left")
        private Integer timeLeft;
        @SerializedName("available")
        private Boolean available;
        @SerializedName("audio_m3u8")
        private String audioM3u8;
        @SerializedName("img_url_compress")
        private String imgUrlCompress;
        @SerializedName("download_count")
        private Integer downloadCount;
        @SerializedName("can_view")
        private Integer canView;
        @SerializedName("audio_m3u8_url")
        private String audioM3u8Url;
        @SerializedName("periodical_count")
        private Integer periodicalCount;
        @SerializedName("sale_status")
        private Integer saleStatus;
        @SerializedName("init_price")
        private Integer initPrice;
        @SerializedName("left_time")
        private Integer leftTime;
        @SerializedName("alive_start_rest_time")
        private Integer aliveStartRestTime;
        @SerializedName("is_free")
        private Integer isFree;
        @SerializedName("share_info")
        private ShareInfoDTO shareInfo;
        @SerializedName("favorites_info")
        private FavoritesInfoDTO favoritesInfo;
        @SerializedName("company_info")
        private CompanyInfoDTO companyInfo;
        @SerializedName("shop_module")
        private ShopModuleDTO shopModule;
        @SerializedName("parent_is_available")
        private Boolean parentIsAvailable;
        @SerializedName("is_login")
        private Boolean isLogin;
        @SerializedName("resource_info")
        private ResourceInfoDTO resourceInfo;
        @SerializedName("content_page_seo")
        private Integer contentPageSeo;
        @SerializedName("video_urls")
        private List<VideoUrlsDTO> videoUrls;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("permission_visit")
        private Integer permissionVisit;
        @SerializedName("permission_comment")
        private Integer permissionComment;
        @SerializedName("permission_buy")
        private Integer permissionBuy;
        @SerializedName("library_list")
        private List<?> libraryList;
        @SerializedName("period_value")
        private String periodValue;
        @SerializedName("period_type")
        private Integer periodType;
        @SerializedName("repeat_purchase")
        private Integer repeatPurchase;
        @SerializedName("is_period")
        private Integer isPeriod;
        @SerializedName("end_at")
        private Integer endAt;
        @SerializedName("only_h5_play")
        private Integer onlyH5Play;
        @SerializedName("product_part_try_info")
        private ProductPartTryInfoDTO productPartTryInfo;
        @SerializedName("pcConfig")
        private PcConfigDTO pcConfig;

        @NoArgsConstructor
        @Data
        public static class ShareInfoDTO {
            @SerializedName("wx")
            private WxDTO wx;

            @NoArgsConstructor
            @Data
            public static class WxDTO {
                @SerializedName("share_url")
                private String shareUrl;
                @SerializedName("short_url")
                private String shortUrl;
                @SerializedName("wx_app_qrcode")
                private String wxAppQrcode;
            }
        }

        @NoArgsConstructor
        @Data
        public static class FavoritesInfoDTO {
            @SerializedName("is_favorite")
            private Integer isFavorite;
            @SerializedName("favorite_count")
            private Integer favoriteCount;
            @SerializedName("resource_id")
            private String resourceId;
        }

        @NoArgsConstructor
        @Data
        public static class CompanyInfoDTO {
            @SerializedName("shop_id")
            private String shopId;
            @SerializedName("company_id")
            private String companyId;
            @SerializedName("vip_id")
            private String vipId;
            @SerializedName("name")
            private String name;
            @SerializedName("title")
            private String title;
            @SerializedName("logo")
            private String logo;
            @SerializedName("cover_img")
            private String coverImg;
            @SerializedName("state")
            private Integer state;
            @SerializedName("expired_at")
            private String expiredAt;
        }

        @NoArgsConstructor
        @Data
        public static class ShopModuleDTO {
            @SerializedName("need_comment_check")
            private Integer needCommentCheck;
            @SerializedName("hide_comment_count")
            private Integer hideCommentCount;
            @SerializedName("hide_view_count")
            private Integer hideViewCount;
            @SerializedName("hide_sub_count")
            private Integer hideSubCount;
            @SerializedName("authentic_state")
            private Integer authenticState;
            @SerializedName("is_show_resourcecount")
            private Integer isShowResourcecount;
        }

        @NoArgsConstructor
        @Data
        public static class ResourceInfoDTO {
            @SerializedName("seo_description")
            private String seoDescription;
        }

        @NoArgsConstructor
        @Data
        public static class ProductPartTryInfoDTO {
            @SerializedName("is_try")
            private Integer isTry;
            @SerializedName("part_try_length")
            private Integer partTryLength;
            @SerializedName("part_try_url")
            private String partTryUrl;
        }

        @NoArgsConstructor
        @Data
        public static class PcConfigDTO {
            @SerializedName("enable_un_login_menu")
            private Integer enableUnLoginMenu;
            @SerializedName("enable_un_login_try_course")
            private Integer enableUnLoginTryCourse;
            @SerializedName("enable_un_login_free_course")
            private Integer enableUnLoginFreeCourse;
            @SerializedName("enable_course_detail_module")
            private Integer enableCourseDetailModule;
        }

        @NoArgsConstructor
        @Data
        public static class VideoUrlsDTO {
            @SerializedName("definition_name")
            private String definitionName;
            @SerializedName("definition_p")
            private String definitionP;
            @SerializedName("url")
            private String url;
            @SerializedName("is_support")
            private Boolean isSupport;
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
    }
}
