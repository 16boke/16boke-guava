package com.guava.basic;

import com.google.common.base.Preconditions;
import com.sun.istack.internal.NotNull;

/**
 * ǰ������
 * checkArgument(boolean)	���boolean�Ƿ�Ϊtrue��������鴫�ݸ������Ĳ�����ʧ�ܣ�IllegalArgumentException
 * checkNotNull(T)	���value�Ƿ�Ϊnull���÷���ֱ�ӷ���value����˿�����Ƕʹ��checkNotNull��ʧ�ܣ�NullPointerException
 * checkState(boolean)	�����������ĳЩ״̬��ʧ�ܣ�IllegalStateException
 * checkElementIndex(int index, int size)	���index��Ϊ����ֵ��ĳ���б��ַ����������Ƿ���Ч��index>=0 && index<size��ʧ�ܣ�IndexOutOfBoundsException
 * checkPositionIndex(int index, int size)	���index��Ϊλ��ֵ��ĳ���б��ַ����������Ƿ���Ч��index>=0 && index<=size��ʧ�ܣ�IndexOutOfBoundsException
 * checkPositionIndexes(int start, int end, int size)	���[start, end]��ʾ��λ�÷�Χ��ĳ���б��ַ����������Ƿ���Ч��ʧ�ܣ�IndexOutOfBoundsException
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
