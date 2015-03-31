/**
 * --------------------------------------------------- 
 *  版权所有：北京光宇在线科技有限责任公司
 * 作者：王宇飞 
 * 联系方式：wangyufei@gyyx.cn 
 * 创建时间：2015年3月6日上午9:43:34
 * 版本号：v1.0
 * 本类主要用途叙述：处理用户相关请求，包括登陆和注册
 */



package cn.cj.design.yufei.bll;

import cn.cj.design.yufei.beans.LoadBean;
import cn.cj.design.yufei.beans.ResultBean;
import cn.cj.design.yufei.dao.ILoad;
import cn.cj.design.yufei.dao.LoadDao;

public class LoadBll {
	/**
	 * 获得登录信息
	 * @param account
	 * @param password
	 * @param type
	 * @return
	 */
	public ResultBean<LoadBean> peopleLoad(String account, String password, String type ){
		//实例化
		ILoad load=new LoadDao();
		ResultBean<LoadBean> resultBean=new ResultBean<LoadBean>();
		LoadBean loadBean=new LoadBean();
		loadBean=load.selectLoadInfo(account, password, type);
		//如果存在这个用户
		if(loadBean!=null){
			resultBean.setIsSuccess(true);
			resultBean.setMessage("登陆成功");
			resultBean.setData(loadBean);
			
		}
		//如果不存在
		else{
			resultBean.setIsSuccess(false);
			resultBean.setMessage("密码账户不存在");
		}
		return resultBean;
		
	}

}
