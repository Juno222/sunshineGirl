package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.model.Status;
import hll.sunshinegirl.mvc.model.User;
import hll.sunshinegirl.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
@RequestMapping("/")
public class LoginController extends BaseController{

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(value = "sign",method = RequestMethod.GET)
    public String sign(){
        return "signup";
    }

    @RequestMapping(value = "dosign",method = RequestMethod.POST)
    @ResponseBody
    public Status dosign(User user,HttpServletRequest request){
        Integer uId = userService.insert(user);
        HttpSession session=request.getSession();
        session.setAttribute("uId",uId);
        return Status(SUCCESS);
    }

    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    @ResponseBody
    public Status dologin(User user ,HttpServletRequest request){
        User exsitUser = userService.login(user);
        if(exsitUser != null){
            HttpSession session=request.getSession();
            session.setAttribute("uId",exsitUser.getuId());
            return Status(SUCCESS,"登陆成功！");
        }else{
            return Status(FAILURE,"登陆失败！");
        }
    }

    @RequestMapping(value = "loginout",method = RequestMethod.GET)
    public String loginout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("uId",null);
        return "login";
    }
}
