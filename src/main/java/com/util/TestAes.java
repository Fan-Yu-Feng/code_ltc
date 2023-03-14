package com.util;

import cn.hutool.crypto.SecureUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestAes {
    public static void main(String[] args) {
        try {
            String originFilePath = "D:\\Desktop\\20230209.ZIP";
            String newFilePath = "D:\\Desktop\\20230209111.zip";
            String beiyinFileAesKey = "Qwqgn4S7AKJs4RWT";
            File file = new File(newFilePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            SecureUtil.aes(beiyinFileAesKey.getBytes()).decrypt(new FileInputStream(originFilePath), new FileOutputStream(newFilePath), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
