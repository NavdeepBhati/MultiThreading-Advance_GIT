package com.copyOnWrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteCollections {

	public static void main(String[] args) {

		 List<Integer> cwa=new CopyOnWriteArrayList<>();
		List<Integer> cwaArray = new ArrayList<>();

		// calcutaion(cwa);
		 name(cwa);
	//	calcutaion(cwaArray);
		name(cwaArray);
	}

	private static void name(List<Integer> cwa) {

		for (int i = 0; i < 20; i++) {
			cwa.add(i);
		}

		Iterator<Integer> itr = cwa.iterator();

		int j = 1000;
		while (itr.hasNext()) {
			Integer integer = (Integer) itr.next();

			System.out.println("cwa    " + integer);
			cwa.add(j);
		//	cwa.remove(j);

			j++;
		}
		Iterator<Integer> itr2 = cwa.iterator();

		while (itr2.hasNext()) {
			Integer integer = (Integer) itr2.next();
			System.out.println("                     cwa" + integer);
			
		}

	}

	private static void calcutaion(List<Integer> cwa) {
		for (int i = 0; i < 100; i++) {
			cwa.add(i);
		}

		int j = 1000;
		for (int i = 0; i < cwa.size(); i++) {
			System.out.println("cwa   " + cwa.get(i));

			if (j < 1050) {
				cwa.remove(i);
			}
			j++;
		}
	}

}