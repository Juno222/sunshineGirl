package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.enums.BugSolveStatusEnum;
import hll.sunshinegirl.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/index")
public class IndexController extends BaseController{
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        User user = currentUser.currentUser();
        Integer bugAboutMeCount = bugManService.bugAboutMeCount(user.getuId());
        Integer bugSolvedCount = bugManService.bugSolvedCount(user.getuId(), BugSolveStatusEnum.SOLEVD.value());
        Integer userCount = userService.userCount();

        map.put("uName",user.getuName());
        map.put("about",bugAboutMeCount);
        map.put("sloved",bugSolvedCount);
        map.put("all",userCount);
        return "index";
    }
}
