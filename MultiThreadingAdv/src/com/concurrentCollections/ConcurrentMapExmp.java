package com.concurrentCollections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentMapExmp {

	public static void main(String[] args) {
		
		concurrentHashMapExample();
		concurrentSkipListMapExample();
		
		
	}

	private static void concurrentSkipListMapExample() {

		Map<Integer, Integer> mp= new ConcurrentSkipListMap<>();
		
		mp.put(1, 1);
		mp.put(19, 1);
		mp.put(14, 1);
		mp.put(7, 1);
		mp.put(2, 1);
		mp.put(5, 1);
		mp.put(9, 1);
		System.out.println("ConcurrentSkipListMap");
		for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
			
			System.out.println(e.getKey());
			
		}
		
	}

	private static void concurrentHashMapExample() {
		Map<Integer, Integer> mp= new ConcurrentHashMap<>();
		
		for (int i = 0; i < 10; i++) {
			
			mp.put(i,i);
		}
		
		Iterator<Integer> it = mp.keySet().iterator();
		
		while (it.hasNext()) {
				Integer key =it.next();
			System.out.println("key   "+key);
			System.out.println(mp.put(key+100, key));
		}
		
		System.out.println(mp);
	}
}
