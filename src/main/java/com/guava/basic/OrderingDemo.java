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
		
		System.out.println("ԭʼ��"+numbers);
		Collections.sort(numbers, ordering);
		System.out.println(ordering.isOrdered(numbers));
		System.out.println("���������"+numbers);
		Collections.sort(numbers, ordering.reverse());
		System.out.println("���������"+numbers);
		
		numbers.add(null);
		//null������ǰ��
		Collections.sort(numbers,ordering.nullsFirst());
		System.out.println("nullֵ�����������"+numbers);
		
		/**
		 * ʹ����ʽ�ṹ��ʵ��null������ҽ�������
		 * ���Ķ���ʽ���ò�����������ʱ��Ӧ�ôӺ���ǰ����
		 */
		Collections.sort(numbers,ordering.reverse().nullsLast());
		System.out.println("null������ҽ�������:"+numbers);
	}
}
