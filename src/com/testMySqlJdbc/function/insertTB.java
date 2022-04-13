package com.testMysqlJdbc.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.testMysqlJdbc.resource.createTbField;

public class insertTB  extends createTbField {

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
			
			
			public insertTB(String h,String u,String ps,String pt,String db,String num) {
				host = h;
				user = u;
				pass = ps;
				port = pt;
				database = db;
				tb_num = num;
			}
			
	/**
	 * 使用普通方式连接数据库插入数据
	 */
			public void cmLinkItb() {
				String inserttb = "";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://"+host+":"+port+"/"+database+"";
					ct = DriverManager.getConnection(url, user, pass);
					System.out.println("使用普通连接方式，向表中插入固定内容。");
					for(int i=0;i<Integer.valueOf(tb_num);i++) {
						inserttb = "insert into "+CMTBNAME+i+"  values "+ ISTTBVALUE;
						ps = ct.prepareStatement(inserttb);
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
				System.out.println("普通连接，插入数据完成... ...");
			}
			
			
			/**
			 * 使用ssl方式连接数据库插入数据
			 */
			public void sslLinkItb(String sslksPass,String sslksStore) {
				String inserttb = "";
				try {
					 String urlWithCe = "jdbc:mysql://"+host+":"+port+"/"+database+"?useSSL=true&trustCertificateKeyStorePassword="+sslksPass+"&trustCertificateKeyStoreUrl="+sslksStore+"&" +
				                "allowMultiQueries=true&" +
				                "useUnicode&characterEncoding=UTF-8&" +
				                "verifyServerCertificate=true&requireSSL=true";
					
					Class.forName("com.mysql.jdbc.Driver");
					ct = DriverManager.getConnection(urlWithCe, user, pass);
					System.out.println("使用ssl连接方式，在表上插入记录。");
					for(int i=0;i<Integer.valueOf(tb_num);i++) {
						inserttb = "insert into "+CMTBNAME+"ssl_"+i+"  values "+ ISTTBVALUE;
						ps = ct.prepareStatement(inserttb);
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
				System.out.println("ssl连接，插入记录完成... ...");
			}
			
}
