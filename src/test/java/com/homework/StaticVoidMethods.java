package com.homework;

public class StaticVoidMethods {

	public StaticVoidMethods() {
		// TODO Auto-generated constructor stub
	}
	
	
	void logingTest(){
		
		System.out.println("Login Home Work");
	}
	
	static void submitHomework() {
		System.out.println("I submitted my homework");
	}

	public static void main(String[] args) {
		
		StaticVoidMethods obj = new StaticVoidMethods();
		obj.logingTest();
		submitHomework();

	}

}