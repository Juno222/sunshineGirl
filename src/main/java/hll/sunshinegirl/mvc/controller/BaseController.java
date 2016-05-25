package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.enums.StatusEnum;
import hll.sunshinegirl.mvc.model.Status;
import hll.sunshinegirl.mvc.service.*;
import hll.sunshinegirl.mvc.vo.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
public class BaseController {
    protected final Integer PAGESIZE = 10;
    protected final StatusEnum SUCCESS = StatusEnum.SUCCESS;
    protected final StatusEnum FAILURE = StatusEnum.FAILURE;

    protected Status Status(StatusEnum status){
        return new Status(status.value(),status.description());
    }

    protected Status Status(int type){
        if(type == 0){
            return Status(FAILURE);
        }else{
            return Status(SUCCESS);
        }
    }

    protected Status Status(int type,String msg){
        if(type == 0){
            return Status(FAILURE,msg);
        }else{
            return Status(SUCCESS,msg);
        }
    }

    protected Status Status(StatusEnum status,String msg){
        return new Status(status.value(),msg);
    }

    @Autowired
    IBugInfoService bugInfoService;

    @Autowired
    IBugManService bugManService;

    @Autowired
    IBugReplyService bugReplyService;

    @Autowired
    ILogService logService;

    @Autowired
    IModandProService modandProService;

    @Autowired
    IModleService modleService;

    @Autowired
    IProjectService projectService;

    @Autowired
    IUserService userService;

    @Autowired
    CurrentUser currentUser;
}
