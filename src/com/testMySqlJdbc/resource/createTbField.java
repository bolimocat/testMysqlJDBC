package com.testMysqlJdbc.resource;

public class createTbField {

	//普通表建表字段
	public static String COMMONTBFILED = "char_type2 char(100) not null,char_type char(20) default 'char',id int AUTO_INCREMENT,  bigid bigint,  "
			+ "smallid smallint,  tinyid tinyint,  mediumid mediumint,  double_type double default 1.00,  float_type float,   date_type date,  "
			+ "decimal_type decimal(32,30),  blob_type char(20),  varchar_type varchar(32),  int8_type int8,  boolean_type boolean,  datetime_mh datetime,  "
			+ "time_type time,  year_type year,  timestamp_type timestamp  DEFAULT CURRENT_TIMESTAMP on update current_timestamp, tinyblob_type char(20),  "
			+ "tinytext_type tinytext,  text_type text,  mediumtext_type mediumtext,  longblob_type char(20),  longtext_type longtext,    "
			+ "primary key(id))ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=utf8";
//	public static String COMMONTBFILED = "id int AUTO_INCREMENT,name char(2), primary key(id))ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=utf8";
	
			

		//普通表插入字段
		public static String ISTFILED ="(char_type2,char_type,bigid,smallid,tinyid,mediumid,double_type,float_type,date_type ,decimal_type ,blob_type,varchar_type,int8_type,boolean_type,datetime_mh,time_type,year_type,timestamp_type,tinyblob_type,tinytext_type,  text_type,mediumtext_type,longblob_type,longtext_type) ";
//		public static String ISTFILED ="(id,name) ";
		
		//普通表插入数值
		public static String ISTTBVALUE ="('char_type2','char_type',NULL,1,0,0,0,0.00,0.00,'2021-03-25',0.00,'','vchar1',1,0,'2021-03-25','05:58:00',2021,'2021/5/10 16:44:00','tinyblob_type','tinytext_type','text_type','mediumtext_type','ongblob_type','longtext_type longtext');";
//		public static String ISTTBVALUE ="(null,'ml');";

		//普通表表名
		public static String CMTBNAME = "tb_";
		
		
		
		//查询字段
		public static String SELECTFILED = "id,char_type2";
		
		//查询字段条件
		public static String SELECTCONDITION = "ID < 10";
		
	
//		dbscale dynamic add hash_type partition_scheme "par" partition = "sd_part1" partition = "rep_part2" is_shard shard_nums 3;
}
