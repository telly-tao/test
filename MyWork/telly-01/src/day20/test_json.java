package day20;

import com.alibaba.fastjson.JSON;

public class test_json {
	public static void main(String[] args){
		Person p1=new Person();
		p1.setAge(20);
		p1.setName("telly");
		p1.setSex("ÄÐ");
		System.out.println(JSON.toJSONString(p1));
	}
}
