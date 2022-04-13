package com.testMysqlJdbc.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.testMysqlJdbc.dom.dbscaleShowStrBean;
import com.testMysqlJdbc.dom.paraFileBean;



public class commonkit {

	/**
	 * 生成随机数
	 * @return
	 */
	public int random() {
		int max=100,min=1;
		int result = 0;
		result = (int) (Math.random()*(max-min)+min);
		return result;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public Long Time(){
		Date dt= new Date();
		long start = dt.getTime();
		return start;
	}
	
	/**
	 * 获取时间差的毫秒数
	 * @param t1
	 * @param t2
	 * @return
	 */
	public Long timer(Long t1, Long t2){
		long timer = t2 - t1;
		return timer;
	}
	
	/**
	 * 按行读取配置文件
	 * @param filePath
	 * @return
	 */
		@SuppressWarnings("resource")
		public ArrayList<paraFileBean> fetchLine(String filePath) {
			ArrayList<paraFileBean> result = new ArrayList<paraFileBean>();
			try {
				File file = new File(filePath);
				BufferedReader reader = null;
				String line = null;
				reader = new BufferedReader(new FileReader(filePath));
				while((line = reader.readLine())!=null) {
					paraFileBean pfb = new paraFileBean();
					pfb.setFileLine(line);
					result.add(pfb);
				}
			} catch (Exception efetchLine) {
				efetchLine.printStackTrace();
			}
			return result;
		}
		

//		按行读取dbscale show的执行内容。
		public ArrayList<dbscaleShowStrBean> fetchDbscaleShow(String filePath) {
			ArrayList<dbscaleShowStrBean> result = new ArrayList<dbscaleShowStrBean>();
			try {
				File file = new File(filePath);
				BufferedReader reader = null;
				String line = null;
				reader = new BufferedReader(new FileReader(filePath));
				while((line = reader.readLine())!=null) {
					dbscaleShowStrBean sb = new dbscaleShowStrBean();
					sb.setDbscaleShowStr(line);
					result.add(sb);
				}
			} catch (Exception fetchDbscaleShow) {
				fetchDbscaleShow.printStackTrace();
			}
			return result;
		}

}
