package com.guava.basic;

import com.google.common.base.Optional;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * guava对null的处理。要求开发者思考参数是否为null，或者自己来处理null的情况
 * abstract Set<T> asSet() 返回一个不可变的单集的唯一元素所包含的实例(如果存在);否则为一个空的不可变的集合。
 * static <T> Optional<T> fromNullable(T nullableReference) 如果nullableReference非空，返回一个包含引用Optional实例;否则返回absent()。
 * abstract T get() 返回所包含的实例，它必须存在。
 * static <T> Optional<T> of(T reference) 返回包含给定的非空引用Optional实例。
 * abstract Optional<T> or(Optional<? extends T> secondChoice) 返回此Optional，如果它有一个值存在; 否则返回secondChoice。
 * abstract T or(Supplier<? extends T> supplier) 返回所包含的实例(如果存在); 否则supplier.get()。
 * abstract T or(T defaultValue) 返回所包含的实例(如果存在);否则为默认值。
 * abstract T orNull() 返回所包含的实例(如果存在);否则返回null。
 */
public class OptionalDemo {
	/**
	 * @NotNull 只是参数的一个标识，程序不会自动判断参数不为空，如果需要判断，则需要自己手动来实现。最大的功能是提醒调用者此参数为非空
	 * @param a
	 * @param b
	 * @return
	 */
	public int sum(@Nullable Integer a, @NotNull Integer b) {
		/*
		 * static <T> Optional<T> fromNullable(T nullableReference)
		 * 如果nullableReference非空，返回一个包含引用Optional实例;否则返回absent()。
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
