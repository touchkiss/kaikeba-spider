package com.touchkiss.kaikebaspider.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Created on 2023/01/03 21:06
 *
 * @author Touchkiss
 */
public class DecryptVideo {
    public static void decryptVideo(String tsFilePath, String keyFilePath, String userId) {
        AES aes = new AES(Mode.CBC, Padding.NoPadding, getAesKey(keyFilePath, userId), getIv(0));
        byte[] decrypt = aes.decrypt(FileUtil.readBytes(new File(tsFilePath)));
        FileUtil.writeBytes(decrypt, new File(tsFilePath));
    }

    // int转byte
    public static byte intToByte(int i) {
        return (byte) (i & 0xFF);
    }


    static byte[] getIv(int sn) {
        byte[] iv = new byte[16];
        for (int i = 12; i < 16; i++) {
            iv[i] = intToByte(sn >> 8 * (15 - i));
        }
        return iv;
    }

    static byte[] getAesKey(String keyFilePath, String userid) {
        byte[] keyBytes = FileUtil.readBytes(keyFilePath);
        byte[] useridBytes = userid.getBytes(Charset.forName("utf-8"));
        for (int i = 0; i < keyBytes.length; i++) {
            keyBytes[i] ^= useridBytes[i];
        }
        return keyBytes;
    }
}
