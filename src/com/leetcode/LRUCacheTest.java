package com.leetcode;

import java.util.*;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}

class LRUCache {
    private int capacity;
    private List<Integer> keyList;
    private Map<Integer,Integer> map;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        keyList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.get(key)==null) return -1;//未找到
        Integer value = map.get(key);
        keyList.remove((Object)key);
        keyList.add(0,key);
        return value;
    }

    public void put(int key, int value) {
        if(map.get(key)!=null) {//有该key
            map.put(key,value);
            keyList.remove((Object)key);
            keyList.add(0,key);
        } else {//需要加入新的键值对
            if(capacity==map.size()) {//已经满了，取出队列中队尾key及相应键值对
                Integer removeKey = keyList.remove(keyList.size()-1);
                map.remove(removeKey);
            }
            keyList.add(0,key);
            map.put(key,value);
        }

    }
}
