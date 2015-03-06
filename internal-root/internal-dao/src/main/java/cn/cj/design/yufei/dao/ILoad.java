/**
 * --------------------------------------------------- 
 * 
 * 作者：王宇飞 
 * 联系方式：wangyufei@gyyx.cn 
 * 创建时间：2015年3月3日下午5:21:04
 * 版本号：v1.0
 * 本类主要用途叙述：登录的接口
 */



package cn.cj.design.yufei.dao;

import org.apache.ibatis.annotations.Param;

import cn.cj.design.yufei.beans.LoadBean;

public interface ILoad {
	/**
	 * 根据账号密码查询登录信息
	 * @param account
	 * @param password
	 * @param type
	 * @return LoadBean 登录信息
	 */
	public LoadBean selectLoadInfo(@Param("account") String account,@Param("password") String password,@Param("type")  String type);

}
