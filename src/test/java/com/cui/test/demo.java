package com.cui.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;

import org.junit.Test;

public class demo {

	public static void main(String[] args) {
		System.out.println(setM("10"));
		System.out.println(setM("abc"));
	}
	public static int setM(String num){
		//Arrays.sort(a);
		int i=0;
		try {
			i=Integer.parseInt(num);
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			i=-1;
		}finally{
			i++;
			
		}
		return i;
	}
	@Test
	public void tst(){
		Cookie cookie=new Cookie("username", "cuiweijie");
		
		
		
	}
	@Test
	public void tsssst(){
		int i=0;
		float a=2.5f;
		//总数
		float b=0f;

		while (true) {
			//开始
			i=i+1;
			b=b+a;
			//第5天或者5的倍数
			if(i%5==0){
				b=b-6;	
			}
			System.out.println(b);
			//终于存了100
			if(b==100){	
				System.out.println("最后的"+i);
				break;
			}
			
		}
		
		
	}
}
