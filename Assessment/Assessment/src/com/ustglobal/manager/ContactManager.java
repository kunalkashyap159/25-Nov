package com.ustglobal.manager;

import com.ustglobal.dao.ContactDao;
import com.ustglobal.dao.ContactDaoImp;

public class ContactManager {
private ContactManager()
{
	
}

public static ContactDao getAllContact()
{
 return new ContactDaoImp();	
}
}
