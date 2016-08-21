package com.guava.basic;

import com.google.common.base.Objects;

public class ObjectDemo {
	public void newEqual() {
		System.out.println(Objects.equal("a", new String("a"))); // returns true
		System.out.println(Objects.equal("a", "a")); // returns true
		System.out.println(Objects.equal(null, "a")); // returns false
		System.out.println(Objects.equal("a", null)); // returns false
		System.out.println(Objects.equal(null, null)); // returns true
		System.out.println(Objects.equal(1.0, new Double(1d))); // returns true
	}

	public void testHashCode() {
		Test test1 = new Test(1,"1");
		System.out.println(Objects.hashCode(test1));
		System.out.println(Objects.hashCode(null, null, null));
		//À≥–Ú√Ù∏–
		System.out.println(Objects.hashCode(test1.getId(), test1.getName()));
		System.out.println(Objects.hashCode(test1.getName(), test1.getId()));
	}

	public static void main(String[] args) {
		ObjectDemo demo = new ObjectDemo();
		demo.newEqual();
		demo.testHashCode();
	}
}

class Test {
	private Integer id;
	private String name;

	public Test() {
	}

	public Test(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
