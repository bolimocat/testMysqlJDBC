package com.testMysqlJdbc.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.testMysqlJdbc.resource.createTbField;

public class deleteTB extends createTbField{
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
			
			
			public deleteTB(String h,String u,String ps,String pt,String db,String num) {
				host = h;
				user = u;
				pass = ps;
				port = pt;
				database = db;
				record_num = num;
			}
			
	/**
	 * 使用普通方式连接数据库插入数据
	 */
			public void cmLinkDltb() {
				String deletetb = "";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://"+host+":"+port+"/"+database+"";
					ct = DriverManager.getConnection(url, user, pass);
					System.out.println("使用普通连接方式，删除表记录。");
					for(int i=0;i<Integer.valueOf(record_num);i++) {
						Random r = new Random();
						deletetb = "delete from "+CMTBNAME+r.nextInt(100)+" where id = "+r.nextInt(100)+";"; 
						System.out.println("使用普通连接方式，删除表记录："+deletetb);
						ps = ct.prepareStatement(deletetb);
						ps.executeUpdate();
					}
				} catch (Exception ecmLinkCtb) {
					ecmLinkCtb.printStackTrace();
				}finally{
					try {
						if(rs!=null) rs.close();
						if(ps!=null) ps.close();
						if(ct!=null) ct.close();
					} catch (Exception eCloseDb) {
						eCloseDb.printStackTrace();
					}
				}
				System.out.println("普通连接，删除数据完成... ...");
			}
			
			
			/**
			 * 使用ssl方式连接数据库插入数据
			 */
			public void sslLinkDltb(String sslksPass,String sslksStore) {
				String deletetb = "";
				try {
					 String urlWithCe = "jdbc:mysql://"+host+":"+port+"/"+database+"?useSSL=true&trustCertificateKeyStorePassword="+sslksPass+"&trustCertificateKeyStoreUrl="+sslksStore+"&" +
				                "allowMultiQueries=true&" +
				                "useUnicode&characterEncoding=UTF-8&" +
				                "verifyServerCertificate=true&requireSSL=true";
					
					 Class.forName("com.mysql.jdbc.Driver");
					ct = DriverManager.getConnection(urlWithCe, user, pass);
					System.out.println("使用ssl连接方式，删除表记录。");
					for(int i=0;i<Integer.valueOf(record_num);i++) {
						Random r = new Random();
						deletetb = "delete from "+CMTBNAME+"ssl_"+r.nextInt(100)+" where id = "+r.nextInt(100)+";";
						System.out.println("使用ssl连接方式，删除表记录："+deletetb);
						ps = ct.prepareStatement(deletetb);
						ps.executeUpdate();
					}
				} catch (Exception ecmLinkCtb) {
					ecmLinkCtb.printStackTrace();
				}finally{
					try {
						if(rs!=null) rs.close();
						if(ps!=null) ps.close();
						if(ct!=null) ct.close();
					} catch (Exception eCloseDb) {
						eCloseDb.printStackTrace();
					}
				}
				System.out.println("ssl连接，删除表记录完成... ...");
			}
}
