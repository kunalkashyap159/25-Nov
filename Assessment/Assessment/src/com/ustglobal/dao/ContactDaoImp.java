package com.ustglobal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ustglobal.bean.ContactBean;

public class ContactDaoImp  implements ContactDao{

	@Override
	public int insertContact(ContactBean bean) {
		
		String url="jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql="insert into contact values(?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2,bean.getNumber());
			pstmt.setString(3,bean.getGroups());
			count=pstmt.executeUpdate();
			System.out.println(count+"Row inserted");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try
			{
				if(con!=null)
				{
					con.close();
				}if(pstmt!=null)
				{
					pstmt.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return count;
		
}

	@Override
	public int deleteContact(String name) {
		String url="jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql="delete from contact where name=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			count=pstmt.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try
			{
				if(con!=null)
				{
					con.close();
				}if(pstmt!=null)
				{
					pstmt.close();
				}if(rs!=null)
				{
					rs.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return count;

	
	}

	@Override
	public ContactBean searchContact(String name) {
		String url="jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql="select *from contact where name=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				ContactBean bean=new ContactBean();
				bean.setName(rs.getString("name"));
				bean.setNumber(rs.getInt("number"));
				bean.setGroups(rs.getString("groups"));
				return bean;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try
			{
				if(con!=null)
				{
					con.close();
				}if(pstmt!=null)
				{
					pstmt.close();
				}if(rs!=null)
				{
					rs.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public ArrayList<ContactBean> contactDetails() {
		String url="jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql="select *from contact";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			ArrayList<ContactBean> result=new ArrayList<ContactBean>();
			while(rs.next())
			{
				ContactBean bean=new ContactBean();
				bean.setName(rs.getString("name"));
				bean.setNumber(rs.getInt("number"));
				bean.setGroups(rs.getString("groups"));
			
				result.add(bean);
			}
			return result;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}if(stmt!=null)
				{
					stmt.close();
				}if(rs!=null)
				{
					rs.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public int updateContact(ContactBean bean) {
		String url="jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql="update contact set number=?,groups=? where name=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bean.getNumber());
			pstmt.setString(2, bean.getGroups());
			pstmt.setString(3, bean.getName());
			
			count=pstmt.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try
			{
				if(con!=null)
				{
					con.close();
				}if(pstmt!=null)
				{
					pstmt.close();
				}if(rs!=null)
				{
					rs.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return count;

		}

}
