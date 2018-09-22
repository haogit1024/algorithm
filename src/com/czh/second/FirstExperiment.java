package com.czh.second;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 *  https://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *  https://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *  https://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *  https://algs4.cs.princeton.edu/14analysis/8Kints.txt
 */
public class FirstExperiment {

    public static void main(String[] args) throws IOException {
        Random r = new Random();
        int[] arr = netWork("https://algs4.cs.princeton.edu/14analysis/4Kints.txt");
        System.out.println("length:" + arr.length);
        long startTime = System.currentTimeMillis();
        System.out.println("从网络获取随机数完毕,当前时间为:" + startTime);

        int N = arr.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                for (int k = j; k < N; k++) {
                   if ((arr[i] + arr[j] + arr[k]) == 0) {
                       cnt++;
                   }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("运行结束,cnt = "+cnt+",当前时间为:" + endTime);
        System.out.println("运行时间为:" + (endTime - startTime) / 1000.00 + "s");
    }

    private static int[]  netWork(String path) throws IOException {
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5 * 1000);
        if (connection.getResponseCode() == 200) {
            InputStream is = connection.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            String s = new String(bos.toByteArray());
            String[] sArray = s.split("\n");
            int[] iArray = new int[sArray.length];
            for (int i = 0; i < sArray.length; i++) {
                iArray[i] = Integer.parseInt(sArray[i].replace(" ",""));
            }
            return iArray;
        } else {
            System.out.println("网络链接失败");
        }
        return null;
    }

}
