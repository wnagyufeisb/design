/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司 
* 作者：姜晗
* 联系方式：jianghan@gyyx.cn 
* 创建时间：2015年1月12日 下午5:09:01 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/

package jh.test;

import junit.framework.TestCase;

import org.internal.bll.bugsystem.BugInfoBll;

import cn.gyyx.oa.internal.beans.bugsystem.BugInfoBean;

public class BugInfoBllTest extends TestCase {

	public void testUpdateSolution() {
		//fail("Not yet implemented");
		BugInfoBll bugInfoBll = new BugInfoBll();
		BugInfoBean bugInfoBean = new BugInfoBean();
		bugInfoBean.setCode(29);
		bugInfoBean.setSolveContent("jh");
		bugInfoBll.updateSolution(bugInfoBean);
	}

	public void testUpdateBugStatus() {
		//fail("Not yet implemented");
		BugInfoBll bugInfoBll = new BugInfoBll();
		BugInfoBean bugInfoBean = new BugInfoBean();
		bugInfoBean.setCode(6);
		bugInfoBean.setBugStatus(0);
		bugInfoBll.updateBugStatus(bugInfoBean);
	}

}
