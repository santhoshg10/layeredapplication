package com.santhosh.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.santhosh.controller.BatsmanController;
import com.santhosh.vo.BatsmanVO;

public class IPLBatsmanLayeredApp 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Batsman number");
		int batsmanno=Integer.parseInt(sc.next());
		System.out.println("Enter batsman name :");
		String batsmanname=sc.next();
		System.out.println("Enter batsman age :");
		int age=Integer.parseInt(sc.next());
		System.out.println("Enter number of runs scored :");
		int noOfRunsScored=Integer.parseInt(sc.next());
		System.out.println("Enter number of innings played :");
		int noOfInnings=Integer.parseInt(sc.next());
		System.out.println("Enter number of not outs");
		int notOuts=Integer.parseInt(sc.next());
		BatsmanVO batsmanVO=new BatsmanVO();
		batsmanVO.setBatsmanId(batsmanno);
		batsmanVO.setName(batsmanname);
		batsmanVO.setAge(age);
		batsmanVO.setRunsScored(noOfRunsScored);
		batsmanVO.setNoOfInnings(noOfInnings);
		batsmanVO.setNotOuts(notOuts);
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/santhosh/cfgs/applicationContext.xml");
		BatsmanController controller=factory.getBean("batsmanRegController",BatsmanController.class);
		try 
		{
			String result=controller.calculateAverage(batsmanVO);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem");
			e.printStackTrace();
		}
	}
}
