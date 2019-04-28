package com.cui.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Data;

import cy.cms.application.dx.util.HttpClient;

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
		//Cookie cookie=new Cookie("username", "cuiweijie");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=new Date();
		String string = format.format(date.getTime());
		System.out.println(string);
		
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
	
	@Test
	public void getyokrn() {
		Map map=new HashMap();
		map.put("username", "root");
		map.put("password","123456");
		HttpClient client=new HttpClient("http://localhost:8084/meeting/login/loginService",map);
		try {
			client.post();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
