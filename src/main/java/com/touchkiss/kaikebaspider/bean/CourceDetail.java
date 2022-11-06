package com.touchkiss.kaikebaspider.bean;

import lombok.Builder;
import lombok.Data;

/**
 * Created on 2022/11/05 22:23
 *
 * @author Touchkiss
 */
@Data
@Builder
public class CourceDetail {
    /**
     * https://xiaoe.kaikeba.com/detail/p_62e9f8fbe4b0c9426482a91b/6?l_program=xe_know_pc
     */
    private String url;
    /**
     * appId:appqszhpsdw5896
     */
    private String appId;
}
