package com.touchkiss.kaikebaspider.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
        execCommand("ffmpeg -f concat -safe 0 -i D:\\kaikeba\\\\files.txt -c copy -strict -2 D:\\kaikeba\\\\1042分布式事务seata-模式-XA模式.mp4");
    }

    public static void execCommand(String cmd) {
        try {
            Runtime runtime = Runtime.getRuntime();
            // 打开任务管理器，exec方法调用后返回 Process 进程对象
            Process process = runtime.exec(cmd);
            // 等待进程对象执行完成，并返回“退出值”，0 为正常，其他为异常
            int exitValue = process.waitFor();
            System.out.println("exitValue: " + exitValue);
            // 销毁process对象
            process.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void aaa(String stam) {
        BufferedReader br = null;
        try {
            File tmpFile = new File(TS_PATH + "temp.tmp");//新建一个用来存储结果的缓存文件
            if (!tmpFile.exists()) {
                tmpFile.createNewFile();
            }
            ProcessBuilder pb = new ProcessBuilder().command("cmd.exe", "/c", stam).inheritIO();
            pb.redirectErrorStream(true);//这里是把控制台中的红字变成了黑字，用通常的方法其实获取不到，控制台的结果是pb.start()方法内部输出的。
            pb.redirectOutput(tmpFile);//把执行结果输出。
            pb.start().waitFor();//等待语句执行完成，否则可能会读不到结果。
            InputStream in = new FileInputStream(tmpFile);
            br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            br = null;
            tmpFile.delete();//卸磨杀驴。
            System.out.println("执行完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void downloadM3u8(String m3u8Url, String mp4fileName, String tsHost, String tsPath, String tsParam, String uid) {
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
        String keyFilePath = TS_PATH + "key.key";
        List<String> tsFiles = new ArrayList<>();
        String m3u8 = Stream.of(m3u8Response.split("\\n"))
                .map(String::trim)
                .map(line -> {
                    if (line.startsWith("#EXT-X-KEY:")) {
                        return Stream.of(line.split(","))
                                .map(s -> {
                                    if (s.startsWith("URI=\"")) {
                                        try {
                                            downloadKey(s.substring("URI=\"".length(), s.length() - 1) + "&uid=" + uid, keyFilePath);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                        return "URI=\"key.key\"";
                                    } else {
                                        return s;
                                    }
                                })
                                .collect(Collectors.joining(","));

                    } else if (!line.startsWith("#") && line.length() > 0) {
                        int i = index.getAndIncrement();
                        String tsFilePath = TS_PATH + i + ".ts";
                        try {
                            downloadTs(tsHost + "/" + tsPath + "/" + line + "&" + tsParam, tsFilePath);
                            DecryptVideo.decryptVideo(tsFilePath, keyFilePath, uid);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        tsFiles.add(tsFilePath);
                        return tsFilePath;
                    } else {
                        return line;
                    }
                })
                .collect(Collectors.joining("\n"));

        FileUtil.writeString(tsFiles.stream().map(f -> "file '" + f + "'").collect(Collectors.joining("\n")), TS_PATH + "\\files.txt", Charset.defaultCharset());
        String cmd = "ffmpeg -f concat -safe 0 -i " + TS_PATH + "files.txt -c copy -strict -2 " + TS_PATH + mp4fileName;
        aaa(cmd);
        try {
            Thread.sleep(10000);
            tsFiles.forEach(f -> {
                try {
                    FileUtil.del(f);
                } catch (Exception eee) {
                    aaa("del " + f);
                }
            });
        } catch (InterruptedException e) {

        }
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
        FileUtil.writeFromStream(inputStream, new File(filePath));
//        File file = new File(filePath);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        BufferedOutputStream isbaos = FileUtil.getOutputStream(file);
//        IOUtils.copy(inputStream, isbaos);
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
}
