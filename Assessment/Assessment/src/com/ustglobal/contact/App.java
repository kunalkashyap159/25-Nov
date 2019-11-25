package com.ustglobal.contact;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ustglobal.bean.ContactBean;
import com.ustglobal.dao.ContactDao;
import com.ustglobal.manager.ContactManager;

public class App {
	public static void main(String[] args) {
		while (true)
		{
			System.out.println("Press 1:Show all contacts");
			System.out.println("Press 2:Search for contacts");
			System.out.println("Press 3:Operate on contacts");
			System.out.println("Enter your choice!!");
			Scanner sc=new Scanner(System.in);
			int option=sc.nextInt();

			switch(option)
			{
			case 1:ArrayList<ContactBean> a=new ArrayList<ContactBean>();
			ContactDao dao4=ContactManager.getAllContact();
			a=dao4.contactDetails();
			for(ContactBean bean:a)
			{
				System.out.println("-------------------------------");
				System.out.println("Name: "+bean.getName());
				System.out.println("Number: "+bean.getNumber());
				System.out.println("Groups: "+bean.getGroups());
				System.out.println("-------------------------------");
			}
			break;
			case 2:System.out.println("Enter the name");
			String name=sc.next();
			ContactDao dao2=ContactManager.getAllContact();
			ContactBean bean2=new ContactBean();
			bean2=dao2.searchContact(name);
			System.out.println("----------------------------------");
			System.out.println("Name:"+bean2.getName());
			System.out.println("Number:"+bean2.getNumber());
			System.out.println("Group:"+bean2.getGroups());
			System.out.println("----------------------------------");
			System.out.println("Press 1:Call "+bean2.getName());
			System.out.println("Press 2:Message "+bean2.getName());
			System.out.println("Press 3:Go to main menu");
			System.out.println("Enter your choice");
			int option2=sc.nextInt();
			switch(option2)
			{
			case 1:System.out.println("Calling......");
			System.out.println("End Call???");
			case 2:System.out.println("Enter message");
			String message=sc.next();
			System.out.println("Sending message to......");
			System.out.println(message);
			break;
			case 3: System.out.println("Go back to menu");
			break;
			}
			break;
			case 3:System.out.println("Press 1:to add contact");
			System.out.println("Press 2:to delete contact");
			System.out.println("Press 3:to edit contact");
			int choice3=sc.nextInt();
			switch(choice3)
			{
			case 1:ContactDao dao=ContactManager.getAllContact();
			ContactBean bean=new ContactBean();
			System.out.println("Enter the name");
			String name1=sc.next();
			bean.setName(name1);


			System.out.println("Enter the number");
			int number=sc.nextInt();
			bean.setNumber(number);
			System.out.println("Enter the group");
			String group=sc.next();
			bean.setGroups(group);
			int count=dao.insertContact(bean);
			System.out.println(count+"Inserted!!!");
			break;
			case 2:ContactDao dao3=ContactManager.getAllContact();
			ContactBean bean3=new ContactBean();
			System.out.println("Enter the name");
			String name2=sc.next();
			bean3.setName(name2);
			int count2=dao3.deleteContact(name2);
			System.out.println(count2+"Rows deleted!!!!");
			case 3:
				ContactDao dao5=ContactManager.getAllContact();
				ContactBean bean4=new ContactBean();
				System.out.println("Enter the name to update the contact");
				String name3=sc.next();
				bean4.setName(name3);


				System.out.println("Set new number");
				int numb4=sc.nextInt();
				bean4.setNumber(numb4);

				System.out.println("Set new groups");
				String group4=sc.next();
				bean4.setGroups(group4);

				int count3=dao5.updateContact(bean4);
				System.out.println(count3+"Rows updated!!!");
			}

			}
		}
	}
}
