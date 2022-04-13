package com.testMysqlJdbc.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.testMysqlJdbc.resource.createTbField;


public class createTB extends createTbField {

	private String host;
	private String user;
	private String pass;
	private String port;
	private String database;
	private String tb_num;
	
	//定义数据库操作
			PreparedStatement ps = null;
			Connection ct = null;
			ResultSet rs = null;
			
			
			public createTB(String h,String u,String ps,String pt,String db,String num) {
				host = h;
				user = u;
				pass = ps;
				port = pt;
				database = db;
				tb_num = num;
			}
			
	/**
	 * 使用普通方式连接数据库建表
	 */
			public void cmLinkCtb() {
				String createtb = "";
				try {
					Class.forName("com.mysql.jdbc.Driver");
//					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://"+host+":"+port+"/"+database+"";
					ct = DriverManager.getConnection(url, user, pass);
					System.out.println("使用普通连接方式，创建新表。");
					for(int i=0;i<Integer.valueOf(tb_num);i++) {
						createtb = "create table  "+CMTBNAME+i+" ("+COMMONTBFILED+";";
						ps = ct.prepareStatement(createtb);
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
				System.out.println("普通连接，建表完成... ...");
			}
			
			
			/**
			 * 使用ssl方式连接数据库建表
			 */
			public void sslLinkCtb(String sslksPass,String sslksStore) {
				String createtb = "";
				try {
//					http://192.168.2.19:8080/ssl/mysql.ks
					 String urlWithCe = "jdbc:mysql://"+host+":"+port+"/"+database+"?useSSL=true&trustCertificateKeyStorePassword="+sslksPass+"&trustCertificateKeyStoreUrl="+sslksStore+"&" +
				                "allowMultiQueries=true&" +
				                "useUnicode&characterEncoding=UTF-8&" +
				                "verifyServerCertificate=true&requireSSL=true";
					
					
					 Class.forName("com.mysql.jdbc.Driver");
					ct = DriverManager.getConnection(urlWithCe, user, pass);
					System.out.println("使用ssl连接方式，创建新表。");
					for(int i=0;i<Integer.valueOf(tb_num);i++) {
						createtb = "create table  "+CMTBNAME+"ssl_"+i+" ("+COMMONTBFILED+";";
						ps = ct.prepareStatement(createtb);
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
				System.out.println("ssl连接，建表完成... ...");
			}
			
}
