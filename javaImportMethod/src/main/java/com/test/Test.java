package com.test;

public class Test {

	public String methodA() {
		System.out.println("Method A of Spring bean sample activated");
		return "Method A";
		}
		public void methodB() {
		System.out.println("Method B of Spring bean sample activated");
		}
		public String methodC(String inputA, String inputB) {
		System.out.println("Method B of Spring bean sample activated");
		return "Method C got " + inputA + " and " + inputB;
		}
	
}
