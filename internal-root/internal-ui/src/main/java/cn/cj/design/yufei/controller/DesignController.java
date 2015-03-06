package cn.cj.design.yufei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping(value = "/load")
	@ResponseBody
	public ResultBean<LoadBean> designLoad(
			@RequestParam(value = "userAccount") String userAcount,
			@RequestParam(value = "userPwd") String userPwd,
			@RequestParam(value = "type") String type) {
		ResultBean<LoadBean> resultBean=new ResultBean<LoadBean>();
		//不存在空值和空字符
        if(userAcount!=null&&!userAcount.equals("")&&userPwd!=null&&!userPwd.equals("")&&type!=null&&!type.equals("")){
		LoadBll loadBll = new LoadBll();
	     resultBean=loadBll.peopleLoad(userAcount, userPwd, type);
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
		String userName=request.getParameter("userName");
		String userLoadCode=request.getParameter("userLoadCode");
		model.addAttribute("userName", userName);
		model.addAttribute("userLoadCode", userLoadCode);
		return "design/userPage";
		
	}
	
}
