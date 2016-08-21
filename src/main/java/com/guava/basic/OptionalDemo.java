package com.guava.basic;

import com.google.common.base.Optional;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * guava��null�Ĵ���Ҫ�󿪷���˼�������Ƿ�Ϊnull�������Լ�������null�����
 * abstract Set<T> asSet() ����һ�����ɱ�ĵ�����ΨһԪ����������ʵ��(�������);����Ϊһ���յĲ��ɱ�ļ��ϡ�
 * static <T> Optional<T> fromNullable(T nullableReference) ���nullableReference�ǿգ�����һ����������Optionalʵ��;���򷵻�absent()��
 * abstract T get() ������������ʵ������������ڡ�
 * static <T> Optional<T> of(T reference) ���ذ��������ķǿ�����Optionalʵ����
 * abstract Optional<T> or(Optional<? extends T> secondChoice) ���ش�Optional���������һ��ֵ����; ���򷵻�secondChoice��
 * abstract T or(Supplier<? extends T> supplier) ������������ʵ��(�������); ����supplier.get()��
 * abstract T or(T defaultValue) ������������ʵ��(�������);����ΪĬ��ֵ��
 * abstract T orNull() ������������ʵ��(�������);���򷵻�null��
 */
public class OptionalDemo {
	/**
	 * @NotNull ֻ�ǲ�����һ����ʶ�����򲻻��Զ��жϲ�����Ϊ�գ������Ҫ�жϣ�����Ҫ�Լ��ֶ���ʵ�֡����Ĺ��������ѵ����ߴ˲���Ϊ�ǿ�
	 * @param a
	 * @param b
	 * @return
	 */
	public int sum(@Nullable Integer a, @NotNull Integer b) {
		/*
		 * static <T> Optional<T> fromNullable(T nullableReference)
		 * ���nullableReference�ǿգ�����һ����������Optionalʵ��;���򷵻�absent()��
		 */
		a = Optional.fromNullable(a).or(0);
		b = Optional.fromNullable(b).or(0);
		return a + b;
	}

	public static void main(String[] args) {
		OptionalDemo demo = new OptionalDemo();
		System.out.println(demo.sum(1, null));
		System.out.println(Optional.of(1).fromNullable(null).asSet().size());
	}
}
