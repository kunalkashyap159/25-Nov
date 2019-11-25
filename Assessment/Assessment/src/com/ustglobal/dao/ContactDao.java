package com.ustglobal.dao;

import java.util.ArrayList;

import com.ustglobal.bean.ContactBean;

public interface ContactDao {

	public int insertContact(ContactBean bean);
	public int deleteContact(String name);
	public ContactBean searchContact(String name);
	public ArrayList<ContactBean> contactDetails();
	public int updateContact(ContactBean bean);
	
}
