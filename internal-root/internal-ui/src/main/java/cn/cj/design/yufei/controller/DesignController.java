package cn.cj.design.yufei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cj.design.yufei.beans.LoadBean;
import cn.cj.design.yufei.beans.ResultBean;
import cn.cj.design.yufei.bll.LoadBll;

@Controller
@RequestMapping(value = "/design")
public class DesignController {
	/**
	 * 进入主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String designIndex() {

		return "design/designIndex";
	}

	/**
	 * 对登录的处理
	 * @param userAcount
	 * @param userPwd
	 * @param type
	 * @return resultBean
	 */
	@RequestMapping(value = "/load",method=RequestMethod.POST)
	@ResponseBody
	public ResultBean<LoadBean> designLoad(
			@RequestParam(value = "userAccount") String userAcount,
			@RequestParam(value = "userPwd") String userPwd,
			@RequestParam(value = "type") String type, HttpServletRequest request) {
		ResultBean<LoadBean> resultBean=new ResultBean<LoadBean>();
		//不存在空值和空字符
        if(userAcount!=null&&!userAcount.equals("")&&userPwd!=null&&!userPwd.equals("")&&type!=null&&!type.equals("")){
		LoadBll loadBll = new LoadBll();
	     resultBean=loadBll.peopleLoad(userAcount, userPwd, type);
	     //如果登陆成功
	     if(resultBean.getIsSuccess()==true){
			HttpSession session = request.getSession(); 
			session.setAttribute("userInfo", resultBean.getData()); 
	     }
	     
        }
        //存在的话
        else{
        	resultBean.setIsSuccess(false);
        	resultBean.setMessage("登录失败");
        }
        return resultBean;
	}
	/**
	 * 进入用户界面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userPage")
	public String userPage(Model model ,HttpServletRequest request){
		HttpSession session = request.getSession(); 
		LoadBean loadBean=(LoadBean) session.getAttribute("userInfo");
		if(loadBean==null){
			return "design/designIndex";
		}
		else{
		model.addAttribute("userInfo", loadBean);
		return "design/userPage";
		}
		
	}
	/**
	 * 注销操作
	 * @param request
	 * @return
	 */
	public ResultBean<String> removeLoad(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		session.removeAttribute("userInfo");
		ResultBean<String> resultBean= new ResultBean<String>();
		resultBean.setIsSuccess(true);
		resultBean.setMessage("注销成功");
		return resultBean;
		
	}
	/**
	 * 获得投诉的页面
	 * @param model
	 * @return投诉页面
	 */
	@RequestMapping(value = "/complain")
	public String getcomplain(Model model){
		return "design/userPagePart/complain";
		
	}
	/**
	 * 得到相关规定页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/statute")
	public String getStatute(Model model){
		return "design/userPagePart/statute";
		
	
	}
	
}
