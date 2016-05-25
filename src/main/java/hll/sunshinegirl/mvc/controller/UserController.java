package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping(value = "all",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll(){
        List<User> lists = userService.selectPage(1,null);
        return lists;
    }
}
