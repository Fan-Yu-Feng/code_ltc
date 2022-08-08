package com.constants;

import java.util.regex.Pattern;

public class Constants {
	//------身份证正则校验-start
	//18位
	private static final String id_no_18 = "^[1-9][0-9]{5}(18|19|20)[0-9]{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)[0-9]{3}([0-9]|(X|x))";
	//预编译(阿里开发手册建议预编译代码不写在方法体内)匹配日期表达式，日期格式：yyyyMMdd
	public final static Pattern patten_id_no_18 = Pattern.compile(id_no_18);
	//15位
	private static final String id_no_15 = "^[1-9][0-9]{5}[0-9]{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)[0-9]{2}[0-9]";
	public final static Pattern patten_id_no_15 = Pattern.compile(id_no_15);
	private static final String num_1to9 = "^([1-9]+(,[1-9]+)*)?$";
	public final static Pattern patten_num_1to9 = Pattern.compile(num_1to9);
	//------身份证正则校验-end
}
