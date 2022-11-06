package com.touchkiss.kaikebaspider.util;

import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import com.touchkiss.kaikebaspider.bean.M3u8Response;

/**
 * Created on 2022/11/05 23:10
 *
 * @author Touchkiss
 */
public class GetVideo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String videoDetailsResponse = HttpUtil.createPost("https://xiaoe.kaikeba.com/api/xe.goods.detail.get/2.0.0?app_id=appqszhpsdw5896")
                .addHeaders(CookieContext.COMMON_HEADERS)
                .header("Accept", "application/json, text/plain, */*")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221842e9c7987604-07802cf301c17dc-26021f51-4953600-1842e9c7988e33%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Flink%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg0MmU5Yzc5ODc2MDQtMDc4MDJjZjMwMWMxN2RjLTI2MDIxZjUxLTQ5NTM2MDAtMTg0MmU5Yzc5ODhlMzMifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221842e9c7987604-07802cf301c17dc-26021f51-4953600-1842e9c7988e33%22%7D; gr_user_id=f3c7974e-8384-4d98-b4b6-47c543d40350; anonymous_user_key=dV9hbm9ueW1vdXNfNjM2NjRiMTgyNDMxYV9JOGhwOFczREVm; Hm_lvt_156e88c022bf41570bf96e74d090ced7=1667229315,1667648863; access-edu_online=282e6ce0b58dfd730c9d47675aed6b4b; pc_user_key=65036b985f71ce989fa3c7a8baf97334; xenbyfpfUnhLsdkZbX=0; sa_jssdk_2015_xiaoe_kaikeba_com=%7B%22distinct_id%22%3A%22u_635a25f4dc737_s1boE5ph8a%22%2C%22first_id%22%3A%22184479559ad943-0cb4ed25100e3f-26021e51-4953600-184479559aeff2%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%7D; shop_version_type=8; LANGUAGE_appqszhpsdw5896=cn; dataUpJssdkCookie={\"wxver\":\"\",\"net\":\"\",\"sid\":\"\"}; userInfo={\"app_id\":\"appqszhpsdw5896\",\"user_id\":\"u_635a25f4dc737_s1boE5ph8a\",\"wx_avatar\":\"http://commonresource-1252524126.cdn.xiaoeknow.com/image/default.svg\",\"wx_gender\":0,\"birth\":null,\"address\":null,\"job\":null,\"company\":null,\"wx_account\":null,\"universal_union_id\":null,\"can_modify_phone\":true,\"phone\":\"15321576299\",\"pc_user_key\":\"65036b985f71ce989fa3c7a8baf97334\",\"permission_visit\":0,\"permission_comment\":0,\"permission_buy\":0,\"pwd_isset\":true,\"channels\":[{\"type\":\"wechat\",\"active\":0},{\"type\":\"qq\",\"active\":0}],\"area_code\":\"86\"}; app_id=\"appqszhpsdw5896\"")
//                .body(gson.toJson(M3u8Request.builder()
//                        .goodsId("v_62ecdda7e4b050af23a559aa")
//                        .columnPartTryId("")
//                        .fromId("p_62e9f8fbe4b0c9426482a91b")
//                        .goodsType(3)
//                        .type("6")
//                        .build()
//                ))
                .body("{\"goods_id\":\"v_62ecddaae4b050af23a559ae\",\"goods_type\":3,\"from_id\":\"p_62e9f8fbe4b0c9426482a91b\",\"type\":\"6\",\"column_part_try_id\":\"\"}")
                .execute().body();
        System.out.println(videoDetailsResponse);
        M3u8Response m3u8Response = gson.fromJson(videoDetailsResponse, M3u8Response.class);
        if (m3u8Response.getData().getVideoUrls() != null && !m3u8Response.getData().getVideoUrls().isEmpty()) {
            M3u8Response.M3u8Details.VideoUrlsDTO videoUrlsDTO = m3u8Response.getData().getVideoUrls().get(0);
            DownloadVideo.downloadM3u8(videoUrlsDTO.getUrl(), videoUrlsDTO.getExt().getHost(), videoUrlsDTO.getExt().getPath(), videoUrlsDTO.getExt().getParam());
        }
    }
}
