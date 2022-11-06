package com.touchkiss.kaikebaspider.bean;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Created on 2022/11/05 22:32
 *
 * @author Touchkiss
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Data
public class GoodsListResponse extends BaseResponse<GoodsListResponse.GoodsListData> {

    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    @Builder
    public static class GoodsListData {
        private List<GoodsItem> goodsList;
        private String lastId;
        private Integer isAvailable;
        private Integer visibleOn;
        private Boolean isLogin;
    }
}
