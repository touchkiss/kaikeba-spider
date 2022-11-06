package com.touchkiss.kaikebaspider.util;

import com.google.common.collect.Maps;

import java.net.HttpCookie;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2022/11/05 22:48
 *
 * @author Touchkiss
 */
public class CookieContext {
    public static final Set<HttpCookie> COOKIES = new HashSet<>();
    public static final Map<String, String> COMMON_HEADERS = Maps.newHashMap();

    static {
        COMMON_HEADERS.put("App-Id","appqszhpsdw5896");
        COMMON_HEADERS.put("DNT", "1");
        COMMON_HEADERS.put("Host", "xiaoe.kaikeba.com");
        COMMON_HEADERS.put("Origin", "https://xiaoe.kaikeba.com");
        COMMON_HEADERS.put("Pragma", "no-cache");
        COMMON_HEADERS.put("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"");
        COMMON_HEADERS.put("sec-ch-ua-mobile", "?0");
        COMMON_HEADERS.put("sec-ch-ua-platform", "Windows");
        COMMON_HEADERS.put("Sec-Fetch-Dest", "empty");
        COMMON_HEADERS.put("Sec-Fetch-Mode", "cors");
        COMMON_HEADERS.put("Sec-Fetch-Site", "same-origin");
        COMMON_HEADERS.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
    }
}
