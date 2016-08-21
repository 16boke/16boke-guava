package com.guava.basic;

import com.google.common.base.Preconditions;
import com.sun.istack.internal.NotNull;

/**
 * 前置条件
 * checkArgument(boolean)	检查boolean是否为true，用来检查传递给方法的参数，失败：IllegalArgumentException
 * checkNotNull(T)	检查value是否为null，该方法直接返回value，因此可以内嵌使用checkNotNull，失败：NullPointerException
 * checkState(boolean)	用来检查对象的某些状态，失败：IllegalStateException
 * checkElementIndex(int index, int size)	检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size，失败：IndexOutOfBoundsException
 * checkPositionIndex(int index, int size)	检查index作为位置值对某个列表、字符串或数组是否有效。index>=0 && index<=size，失败：IndexOutOfBoundsException
 * checkPositionIndexes(int start, int end, int size)	检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效，失败：IndexOutOfBoundsException
 * @author wyc
 *
 */
public class PreconditionsDemo {
	public double sqrt(double input) throws IllegalArgumentException {
		Preconditions.checkArgument(input > 0.0, "Illegal Argument passed: Negative value %s.", input);
		return Math.sqrt(input);
	}

	public int sum(@NotNull Integer a, @NotNull Integer b) {
		a = Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
		b = Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");
		return a + b;
	}

	public int getValue(int index) {
		int[] data = { 1, 2, 3, 4, 5 };
		Preconditions.checkElementIndex(index, data.length, "Illegal Argument passed: Invalid index.");
		return 0;
	}

	public static void main(String[] args) {
		PreconditionsDemo demo = new PreconditionsDemo();
		System.out.println(demo.sum(1, null));
		System.out.println(demo.getValue(4));
	}
}
