/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司 
* 作者：姜晗
* 联系方式：jianghan@gyyx.cn 
* 创建时间：2015年1月9日 上午11:41:42 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/

package jh.test;

import org.internal.bll.bugsystem.BugLogBll;

import cn.gyyx.oa.internal.beans.bugsystem.BugLogBean;
import junit.framework.TestCase;

public class BugLogBllTest extends TestCase {

	public void testInsertBugLog() {
		//fail("Not yet implemented");
		BugLogBll bugLogBll = new BugLogBll();
		BugLogBean bugLogBean = new BugLogBean();
		bugLogBean.setBugInfoCode(1);
		bugLogBll.insertBugLog(bugLogBean);
	}

}
