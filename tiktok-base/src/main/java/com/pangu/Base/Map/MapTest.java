package com.pangu.Base.Map;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-30 11:15
 * @desc:Java基础Map类
 */
public class MapTest {
    private final static int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static int times = 100000;
    private static int a = 100;
    private static int b = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(times);
    private static CountDownLatch mainCountDownLatch = new CountDownLatch(times);
    private static int hashMapValue = 1;
    private static int hashTableValue = 1;
    private static int concurrentHashMapValue = 1;

    public static void main(String[] args) {
        HashMap<Object, Integer> hashMap = new HashMap<>();
        Hashtable<Object, Integer> hashtable = new Hashtable<>();
        TreeMap<Object, Integer> treeMap = new TreeMap<>();
        ConcurrentHashMap<Object, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        LinkedHashMap<Object, Integer> linkedHashMap = new LinkedHashMap<>();
//        // 验证有序性
//        for(int i = 0; i < 100; i++){
//            hashMap.put(String.valueOf(i),i);
//            linkedHashMap.put(String.valueOf(i),i);
//            treeMap.put(String.valueOf(i),i);
//        }
//        for(Map.Entry<Object, Integer> mapEntry : hashMap.entrySet()){
//            // 并非顺序展示
//            System.out.println("hashMap:" + mapEntry.getKey() + "----" + mapEntry.getValue());
//        }
//        for(Map.Entry<Object, Integer> mapEntry : linkedHashMap.entrySet()){
//            // 顺序展示
//            System.out.println("linkedHashMap:" + mapEntry.getKey() + "----" + mapEntry.getValue());
//        }
//        for(Map.Entry<Object, Integer> mapEntry : treeMap.entrySet()){
//            // 按照Key的升序列顺序展示
//            System.out.println("treeMap:" + mapEntry.getKey() + "----" + mapEntry.getValue());
//        }

        // 验证线程安全性
        int carePoolSize = 10;
        int maxThreadSize = 20;
        long keepAlive = 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(carePoolSize,maxThreadSize,keepAlive, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        AtomicInteger AiMap = new AtomicInteger(0);
        AtomicInteger AiTable = new AtomicInteger(0);
        AtomicInteger AiCHashMap = new AtomicInteger(0);
        hashMap.put("num",AiMap.get());
        hashtable.put("num",AiTable.get());
        concurrentHashMap.put("num",AiCHashMap.get());
        for(int i = 0; i  < times; i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        hashMap.put("num",AiMap.incrementAndGet());
                        hashtable.put("num", AiTable.incrementAndGet());
                        concurrentHashMap.put("num", AiCHashMap.incrementAndGet());
                        mainCountDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            mainCountDownLatch.await();
            System.out.println(a);
            System.out.println("hashMap:" + hashMap.get("num"));
            System.out.println("hashtable:" + hashtable.get("num"));
            System.out.println("concurrentHashMap:" + concurrentHashMap.get("num"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
