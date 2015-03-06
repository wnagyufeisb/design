/**
 * --------------------------------------------------- 
 * 
 * 作者：王宇飞 
 * 联系方式：wangyufei@gyyx.cn 
 * 创建时间：2015年3月3日下午5:27:46
 * 版本号：v1.0
 * 本类主要用途叙述：登录的数据库Dao层
 * 
 */



package cn.cj.design.yufei.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.cj.design.yufei.beans.LoadBean;
public class LoadDao implements ILoad  {
	
	//获取session对象
		private SqlSession getSession() {
			SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory
					.getSqlActionDBV2SessionFactory();
			return sqlSessionFactory.openSession();
		}

		/**
		 * 登录方法的重载
		 */
	@Override
	public LoadBean selectLoadInfo(String account, String password, String type) {
		// TODO Auto-generated method stub
try (SqlSession sqlSession = getSession()) {
	ILoad iload=sqlSession.getMapper(ILoad.class);
	return iload.selectLoadInfo(account, password, type);
		
			
		}
		
	}

}
