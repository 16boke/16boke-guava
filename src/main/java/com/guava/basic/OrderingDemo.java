package com.guava.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Ordering;

public class OrderingDemo {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(5));
		numbers.add(new Integer(2));
		numbers.add(new Integer(15));
		numbers.add(new Integer(51));
		numbers.add(new Integer(53));
		numbers.add(new Integer(35));
		numbers.add(new Integer(45));
		numbers.add(new Integer(32));
		numbers.add(new Integer(43));
		numbers.add(new Integer(16));
		
		Ordering ordering = Ordering.natural();
		System.out.println("max = "+ordering.max(numbers));
		System.out.println("min = "+ordering.min(numbers));
		
		System.out.println("原始："+numbers);
		Collections.sort(numbers, ordering);
		System.out.println(ordering.isOrdered(numbers));
		System.out.println("升序排序后："+numbers);
		Collections.sort(numbers, ordering.reverse());
		System.out.println("降序排序后："+numbers);
		
		numbers.add(null);
		//null放在最前面
		Collections.sort(numbers,ordering.nullsFirst());
		System.out.println("null值的升序排序后："+numbers);
		
		/**
		 * 使用链式结构来实现null在最后且降序排列
		 * 当阅读链式调用产生的排序器时，应该从后往前读。
		 */
		Collections.sort(numbers,ordering.reverse().nullsLast());
		System.out.println("null在最后且降序排列:"+numbers);
	}
}
