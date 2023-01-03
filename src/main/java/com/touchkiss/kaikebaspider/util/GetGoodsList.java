package com.touchkiss.kaikebaspider.util;

import cn.hutool.http.HttpUtil;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.touchkiss.kaikebaspider.bean.GoodsItem;
import com.touchkiss.kaikebaspider.bean.GoodsListRequest;
import com.touchkiss.kaikebaspider.bean.GoodsListResponse;

/**
 * Created on 2022/11/05 22:35
 *
 * @author Touchkiss
 */
public class GetGoodsList {
    public static void main(String[] args) {
        Gson gson = new Gson();
        GoodsListRequest goodsListRequest = GoodsListRequest.builder()
                .goodsId("p_62e9f8fbe4b0c9426482a91b")
                .goodsType(6)
                .lastId("")
                .orderType(0)
                .pageSize(20)
                .productId("")
                .resourceType(Lists.newArrayList(1, 2, 3, 4, 20))
                .build();

        String responseBody = HttpUtil.createPost("https://xiaoe.kaikeba.com/api/xe.goods.relation.get/1.0.0?app_id=appqszhpsdw5896")
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .header("App-Id", "appqszhpsdw5896")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Cookie", "")
                .header("DNT", "1")
                .header("Host", "xiaoe.kaikeba.com")
                .header("Origin", "https://xiaoe.kaikeba.com")
                .header("Pragma", "no-cache")
                .header("Referer", "https://xiaoe.kaikeba.com/detail/p_62e9f8fbe4b0c9426482a91b/6?l_program=xe_know_pc")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "Windows")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .body(gson.toJson(goodsListRequest))
                .execute().body();
        System.out.println(responseBody);
        GoodsListResponse goodsListResponse = gson.fromJson(responseBody, GoodsListResponse.class);
        for (GoodsItem goodsItem : goodsListResponse.getData().getGoodsList()) {
            System.out.println(goodsItem.getTitle());
        }
    }
}
