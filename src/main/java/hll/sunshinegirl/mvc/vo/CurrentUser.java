package hll.sunshinegirl.mvc.vo;

import hll.sunshinegirl.mvc.model.User;
import hll.sunshinegirl.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class CurrentUser {

    @Autowired
    private IUserService userService;

    private User currentUser;

    public void setCurrentUser(Integer uId){
        User user = userService.selectByPrimaryKey(uId);
        currentUser = user;
    }

    public  User currentUser(){
        return currentUser;
    }
}
