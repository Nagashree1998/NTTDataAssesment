package com.nttdata.gitdemo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GreetingExample {

	public static void main(String[] args) {
		GregorianCalendar time = new GregorianCalendar();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name please..!!!");
		String name=sc.next();
		int hour = time.get(Calendar.HOUR_OF_DAY);
		
		if (hour < 12)
			System.out.println("Good Morning...!! "+name);
		else if (hour < 17 && hour >= 12)
			System.out.println("Good Afternoon...!! "+name);
		else
			System.out.println("Good Evening...!! "+name);
		System.out.println("Thank You");
	}

}
