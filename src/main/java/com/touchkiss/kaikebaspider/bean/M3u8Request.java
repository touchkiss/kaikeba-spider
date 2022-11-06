package com.touchkiss.kaikebaspider.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2022/11/05 23:12
 *
 * @author Touchkiss
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class M3u8Request {

    private String goodsId;
    private Integer goodsType;
    private String fromId;
    private String type;
    private String columnPartTryId;
}
