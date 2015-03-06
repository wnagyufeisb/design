/**
 * --------------------------------------------------- 
 * 
 * 作者：王宇飞 
 * 联系方式：wangyufei@gyyx.cn 
 * 创建时间：2015年3月3日下午5:09:21
 * 版本号：v1.0
 * 本类主要用途叙述：登录所用bean
 */



package cn.cj.design.yufei.beans;

public class LoadBean {
	/**
	 * 自增主键
	 */
	public int  code;
	/**
	 * 账户
	 */
	public String account;
	/**
	 * 密码
	 */
	public String password;
	/**
	 * 姓名
	 */
	public String name;
	/**
	 * 账户类型
	 */
	public String type;
	/**
	 * 自增之间get方法
	 * @return
	 */
	public int getCode() {
		return code;
	}
	/**
	 * 自增主键set方法
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/*
	 * 账户get方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 账户set方法
	 * @param account
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 密码get方法
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 密码set方法
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 姓名get方法
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 姓名set方法
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 类型get方法
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * 类型set方法
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	

} 
