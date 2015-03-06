/*-------------------------------------------------------------------------
* 版权所有：北京光宇在线科技有限责任公司
* 作者：guohai
* 联系方式：guohai@gyyx.cn
* 创建时间： 2014年12月1日
* 版本号：v1.0
* 本类主要用途描述：
* MyBatis连接产生器
-------------------------------------------------------------------------*/
package cn.cj.design.yufei.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.gyyx.core.prop.PropertiesParser;
import cn.gyyx.core.prop.SimpleProperties;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlActionDBV2SessionFactory;

	static{
		
		try {
			String resource = "config/mybatis-config.xml";
			String dataSql=SimpleProperties.getInstance().getStringProperty("database.path");
			Properties dataSqlProperties=new PropertiesParser(dataSql).getProperties();
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlActionDBV2SessionFactory == null) {
				
				sqlActionDBV2SessionFactory = new SqlSessionFactoryBuilder().build(reader, "design", dataSqlProperties);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 静态方法返回SQL实例
	 * @return
	 */
	public static SqlSessionFactory getSqlActionDBV2SessionFactory() {
 
        return sqlActionDBV2SessionFactory;
    }
	
	
}
