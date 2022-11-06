package com.touchkiss.kaikebaspider.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created on 2022/11/05 22:34
 *
 * @author Touchkiss
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class GoodsListRequest {

    private Integer pageSize;
    private String productId;
    private String goodsId;
    private String lastId;
    private Integer goodsType;
    private List<Integer> resourceType;
    private Integer orderType;
}
