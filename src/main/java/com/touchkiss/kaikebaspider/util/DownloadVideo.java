package com.touchkiss.kaikebaspider.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.http.HttpUtil;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2022/11/05 23:37
 *
 * @author Touchkiss
 */
public class DownloadVideo {
    public static final String TS_PATH = "D:\\kaikeba\\";

    public static void main(String[] args) throws IOException {
//        downloadM3u8("https://pri-cdn-tx.xiaoeknow.com/appqszhpsdw5896/private_index/1664281714bYTu6O.m3u8?sign=f37aadaf99c265918108ba40f310fa6f&t=63667cd0",
//                "https://c-vod.hw-cdn.xiaoeknow.com/",
//                "529d8d60vodtransbj1252524126/c60df50f387702304282483292/drm"
//                , "sign=f8ee1ed89bab1b426b1350a41817e796&t=63672590&us=dRWJfjOrLT&whref=xiaoe.kaikeba.com");
//        downloadTs("https://c-vod.hw-cdn.xiaoeknow.com/529d8d60vodtransbj1252524126/c60df50f387702304282483292/drm/v.f421220_0.ts?start=0&end=134431&type=mpegts&sign=4f84df2f7b6699fd68b13c630fbd3a26&t=63673258&us=eAxuhKvpZS&whref=xiaoe.kaikeba.com", TS_PATH + "1.ts");
        decryptVideo();
    }

    public static void downloadM3u8(String m3u8Url, String tsHost, String tsPath, String tsParam) {
        String m3u8Response = HttpUtil.createGet(m3u8Url)
                .header("accept", "*/*")
                .header("accept-encoding", "gzip, deflate, br")
                .header("accept-language", "zh-CN,zh;q=0.9,en;q=0.8")
                .header("cache-control", "no-cache")
                .header("dnt", "1")
                .header("origin", "https://xiaoe.kaikeba.com")
                .header("pragma", "no-cache")
                .header("referer", "https://xiaoe.kaikeba.com/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "Windows")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "cross-site")
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .execute()
                .body();
        System.out.println(m3u8Response);

        AtomicInteger index = new AtomicInteger(1);
        String m3u8 = Stream.of(m3u8Response.split("\\n"))
                .map(String::trim)
                .map(line -> {
//                    if (line.startsWith("#EXT-X-KEY:")) {
//                        return Stream.of(line.split(","))
//                                .map(s -> {
//                                    if (s.startsWith("URI=\"")) {
//                                        try {
//                                            downloadKey(s.substring("URI=\"".length(), s.length() - 2)+"&uid=u_635a25f4dc737_s1boE5ph8a", TS_PATH + "key.key");
//                                        } catch (IOException e) {
//                                            throw new RuntimeException(e);
//                                        }
//                                        return "URI=\"key.key\"";
//                                    } else {
//                                        return s;
//                                    }
//                                })
//                                .collect(Collectors.joining(","));
//
//                    } else
                    if (!line.startsWith("#") && line.length() > 0) {
                        int i = index.getAndIncrement();
                        try {
                            downloadTs(tsHost + "/" + tsPath + "/" + line + "&" + tsParam, TS_PATH + i + ".ts");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return TS_PATH + i + ".ts";
                    } else {
                        return line;
                    }
                })
                .collect(Collectors.joining("\n"));

        File m3u8File = new File(TS_PATH + "video.m3u8");
        FileUtil.writeString(m3u8, m3u8File, Charset.defaultCharset());

        String cmd = "ffmpeg -allowed_extensions ALL -protocol_whitelist \"file,http,https,crypto,tcp\" -i " + TS_PATH + "video.m3u8 -c copy " + TS_PATH + "\\result.mp4";
        System.out.println(cmd);

    }

    static boolean downloadKey(String keyUrl, String filePath) throws IOException {

        System.out.println("正在下载： " + keyUrl);

        InputStream inputStream = HttpUtil.createGet(keyUrl)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .header("Cache-Control", "no-cache")
                .header("DNT", "1")
                .header("Origin", "https://xiaoe.kaikeba.com")
                .header("Pragma", "no-cache")
                .header("Referer", "https://xiaoe.kaikeba.com/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "Windows")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .execute()
                .bodyStream();
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedOutputStream isbaos = FileUtil.getOutputStream(file);
        IOUtils.copy(inputStream, isbaos);
        return true;
    }


    static boolean downloadTs(String tsUrl, String filePath) throws IOException {
        System.out.println("正在下载： " + tsUrl);

        InputStream inputStream = HttpUtil.createGet(tsUrl)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("DNT", "1")
                .header("Host", "c-vod.hw-cdn.xiaoeknow.com")
                .header("Origin", "https://xiaoe.kaikeba.com")
                .header("Pragma", "no-cache")
                .header("Referer", "https://xiaoe.kaikeba.com/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "Windows")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .execute()
                .bodyStream();
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedOutputStream isbaos = FileUtil.getOutputStream(file);
        IOUtils.copy(inputStream, isbaos);
        return true;
    }

    static void decryptVideo() {

//        List<Byte> bytes = Arrays.asList(87, 3, 126, 224, 110, 48, 131, 32, 96, 180, 210, 243, 26, 165, 55, 86).stream().map(DownloadVideo::intToByte).collect(Collectors.toList());
//        byte[] key = new byte[16];
//        for (int i = 0; i < key.length; i++) {
//            key[i]=bytes.get(i);
//        }

        byte[] key = FileUtil.readBytes(new File(TS_PATH + "key.key"));
//        for (int i = 0; i < 17; i++) {
            AES aes = new AES(Mode.CBC, Padding.NoPadding, key, getIv(0));
            byte[] decrypt = aes.decrypt(FileUtil.readBytes(new File(TS_PATH + "280.ts")));
            FileUtil.writeBytes(decrypt, new File(TS_PATH + "280-bak.ts"));
//        }
    }
    // int转byte
    public static byte intToByte(int i) {
        return (byte)(i & 0xFF);
    }


    static byte[] getIv(int sn) {
        byte[] iv = new byte[16];
        for (int i = 12; i < 16; i++) {
            iv[i] = intToByte(sn >> 8 * (15 - i));
        }
        return iv;
    }
}
