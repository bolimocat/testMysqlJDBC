package com.testMysqlJdbc.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.testMysqlJdbc.resource.createTbField;


public class transcationTB extends createTbField{

	private String host;
	private String user;
	private String pass;
	private String port;
	private String database;
	private String record_num;
	
	//定义数据库操作
		PreparedStatement ps = null;
		Connection ct = null;
		ResultSet rs = null;
		
		public transcationTB(String h,String u,String ps,String pt,String db,String num) {
			host = h;
			user = u;
			pass = ps;
			port = pt;
			database = db;
			record_num = num;
		}
		
		/**
		 * 普通连接执行事务
		 */
	public void cmTranscation() {
		System.out.println("普通连接，开始执行一个事务 ... ");
		int n = 0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://"+host+":"+port+"/"+database+";";
			ct = DriverManager.getConnection(url, user, pass);
			ct.setAutoCommit(false);
			
			//操作1，给一个随机表增加一条记录
			Random r = new Random();
			String inserttb = "insert into "+CMTBNAME+r.nextInt(100)+"  values "+ ISTTBVALUE;
			ps = ct.prepareStatement(inserttb);
			System.out.println("普通连接，事务中的操作1 ：  "+inserttb);
			n = ps.executeUpdate();
			
			//操作2，给一个随机表更新一条记录
			r = new Random();
			String updatetb = "update "+CMTBNAME+r.nextInt(100)+" set char_type2 = 'update-"+r.nextInt(100)+"' where id = "+r.nextInt(100);
			ps = ct.prepareStatement(updatetb);
			System.out.println("普通连接，事务中的操作2 ：  "+updatetb);
			n = n + ps.executeUpdate();
			
			ct.commit();
			if(n>0) {
				System.out.println("事务提交成功");
			}
			else {
				System.out.println("事务提交失败");
			}
		} catch (Exception e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (Exception eCloseDb) {
				eCloseDb.printStackTrace();
			}
		}
		System.out.println("普通连接，完成执行一个事务 ... ");
	}
	
	/**
	 * 连接执行事务
	 * @param sslksPass
	 * @param sslksStore
	 */
	public void sslTranscation(String sslksPass,String sslksStore) {
		System.out.println("ssl连接，开始执行一个事务 ... ");
		int n = 0;
		try {
			String urlWithCe = "jdbc:mysql://"+host+":"+port+"/"+database+"?useSSL=true&trustCertificateKeyStorePassword="+sslksPass+"&trustCertificateKeyStoreUrl="+sslksStore+"&" +
	                "allowMultiQueries=true&" +
	                "useUnicode&characterEncoding=UTF-8&" +
	                "verifyServerCertificate=true&requireSSL=true";
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection(urlWithCe, user, pass);
			ct.setAutoCommit(false);
			
			//操作1，给一个随机表增加一条记录
			Random r = new Random();
			String inserttb = "insert into "+CMTBNAME+"ssl_"+r.nextInt(100)+"  values "+ ISTTBVALUE;
			ps = ct.prepareStatement(inserttb);
			System.out.println("ssl连接，事务中的操作1 ：  "+inserttb);
			n = ps.executeUpdate();
			
			//操作2，给一个随机表更新一条记录
			r = new Random();
			String updatetb = "update "+CMTBNAME+"ssl_"+r.nextInt(100)+" set char_type2 = 'update-"+r.nextInt(100)+"' where id = "+r.nextInt(100);
			ps = ct.prepareStatement(updatetb);
			System.out.println("ssl连接，事务中的操作2 ：  "+updatetb);
			n = n + ps.executeUpdate();
			
			ct.commit();
			if(n>0) {
				System.out.println("事务提交成功");
			}
			else {
				System.out.println("事务提交失败");
			}
		} catch (Exception e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (Exception eCloseDb) {
				eCloseDb.printStackTrace();
			}
		}
		System.out.println("ssl连接，完成执行一个事务 ... ");
	}
	
}
				
				
			
	
