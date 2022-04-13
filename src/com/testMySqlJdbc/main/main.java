package com.testMySqlJdbc.main;

import java.util.ArrayList;

import com.testMysqlJdbc.dom.dbscaleShowStrBean;
import com.testMysqlJdbc.dom.paraFileBean;
import com.testMysqlJdbc.function.commonkit;
import com.testMysqlJdbc.function.createTB;
import com.testMysqlJdbc.function.dbscaleShow;
import com.testMysqlJdbc.function.deleteTB;
import com.testMysqlJdbc.function.dropTB;
import com.testMysqlJdbc.function.insertTB;
import com.testMysqlJdbc.function.transcationTB;
import com.testMysqlJdbc.function.updateTB;

public class main {

	public static void main(String[] args) {
//		System.out.println("jdbc测试mysql的事务");
//		mysqlTranscation t = new mysqlTranscation();
//		t.exeTranscation();
		
		commonkit ck = new commonkit();
		ArrayList paraList = ck.fetchLine("./file/common");//按行读取配置文件
		String[] str = null; 
		
		paraFileBean pfb0 = (paraFileBean)paraList.get(0);
		str = pfb0.getFileLine().split(":");
		String host = str[1];
		
		paraFileBean pfb1 = (paraFileBean)paraList.get(1);
		str = pfb1.getFileLine().split(":");
		String user = str[1];
		
		paraFileBean pfb2 = (paraFileBean)paraList.get(2);
		str = pfb2.getFileLine().split(":");
		String pass = str[1];
		
		paraFileBean pfb3 = (paraFileBean)paraList.get(3);
		str = pfb3.getFileLine().split(":");
		String port = str[1];
		
		paraFileBean pfb4 = (paraFileBean)paraList.get(4);
		str = pfb4.getFileLine().split(":");
		String db = str[1];
		
		paraFileBean pfb5 = (paraFileBean)paraList.get(5);
		str = pfb5.getFileLine().split(":");
		String tbnum = str[1];
		
		paraFileBean pfb6 = (paraFileBean)paraList.get(6);
		str = pfb6.getFileLine().split(":");
		String ctType = str[1];
		
		//操作类型
		paraFileBean pfb7 = (paraFileBean)paraList.get(7);
		str = pfb7.getFileLine().split(":");
		String opType = str[1];
		
		//ssl证书密码
		paraFileBean pfb8 = (paraFileBean)paraList.get(8);
		str = pfb8.getFileLine().split(":");
		String ctPass = str[1];
		
		//ssl证书位置
		paraFileBean pfb9 = (paraFileBean)paraList.get(9);
		String ctLocal = pfb9.getFileLine();
		
		//操作类型为建表
		if(opType.equals("createtb")) {
			createTB ctb = new createTB(host,user,pass,port,db,tbnum);
			//普通连接
			if(ctType.equals("1")) {
				ctb.cmLinkCtb();
			}
			//ssl加密连接
			if(ctType.equals("2")) {
				ctb.sslLinkCtb(ctPass,ctLocal);
			}
		}
		
		if(opType.equals("droptb")) {
			dropTB dtb = new dropTB(host,user,pass,port,db,tbnum);
			//普通连接
			if(ctType.equals("1")) {
				dtb.cmLinkDtb();
			}
			//ssl加密连接
			if(ctType.equals("2")) {
				dtb.sslLinkCtb(ctPass,ctLocal);
			}
		}
		
		if(opType.equals("inserttb")) {
			insertTB itb = new insertTB(host,user,pass,port,db,tbnum);
			
			if(ctType.equals("1")) {
				itb.cmLinkItb();
			}
			if(ctType.equals("2")) {
				itb.sslLinkItb(ctPass, ctLocal);
			}
		}
		
		if(opType.equals("updatetb")) {
			updateTB utb = new updateTB(host,user,pass,port,db,tbnum);
			if(ctType.equals("1")) {
				utb.cmLinkUtb();
			}
			if(ctType.equals("2")) {
				utb.sslLinkUtb(ctPass, ctLocal);
			}
		}
		
		if(opType.equals("deletetb")) {
			deleteTB dltb = new deleteTB(host,user,pass,port,db,tbnum);
			if(ctType.equals("1")) {
				dltb.cmLinkDltb();
			}
			if(ctType.equals("2")) {
				dltb.sslLinkDltb(ctPass, ctLocal);
			}
		}
		
		if(opType.equals("transcation")) {
			transcationTB ttb = new transcationTB(host,user,pass,port,db,tbnum);
			if(ctType.equals("1")) {
				ttb.cmTranscation();
			}
			if(ctType.equals("2")) {
				ttb.sslTranscation(ctPass, ctLocal);
			}
		}
		if(opType.equals("dbscaleshow")) {
			dbscaleShow dbscaleshow = new dbscaleShow(host,user,pass,port,db,tbnum);
			
			ArrayList dbscaleshowList = ck.fetchDbscaleShow("./file/dbscaleShow");//按行读取配置文件
			for(int i=0;i<dbscaleshowList.size();i++) {
				dbscaleShowStrBean showStr = (dbscaleShowStrBean)dbscaleshowList.get(i);
				if(ctType.equals("1")) {
					dbscaleshow.cmLinkDbscaleshow(showStr.getDbscaleShowStr());
				}
				if(ctType.equals("2")) {
					dbscaleshow.sslLinkDbscaleshow(ctPass, ctLocal, showStr.getDbscaleShowStr());
				}
				System.out.println("\n");
			}
			
			
		}
	}

}
