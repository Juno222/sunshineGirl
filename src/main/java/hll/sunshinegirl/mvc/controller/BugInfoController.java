package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.model.BugInfo;
import hll.sunshinegirl.mvc.model.BugMan;
import hll.sunshinegirl.mvc.model.Status;
import hll.sunshinegirl.mvc.vo.FullBugVo;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/buginfo")
public class BugInfoController extends BaseController{

    @RequestMapping(value = "new",method = RequestMethod.POST)
    @ResponseBody
    public Status add(BugInfo bugInfo,Integer uId){
        String mBId = bugInfoService.insert(bugInfo)+"";
        BugMan bugman = new BugMan();
        bugman.setmBId(mBId);
        bugman.setuId(uId+"");
        bugManService.insert(bugman);
        return Status(SUCCESS);
    }

    @RequestMapping(value = "full",method = RequestMethod.GET)
    @ResponseBody
    public PaginationVo<List> full(Integer moId,@RequestParam(value = "p", defaultValue = "1")Integer pagenum){
        return bugInfoService.fullBugInfoList(moId,pagenum);
    }

    @RequestMapping(value = "my",method = RequestMethod.GET)
    @ResponseBody
    public List<FullBugVo> my(){
        Integer mId = currentUser.currentUser().getuId();
        return bugInfoService.myBugInfoList(mId);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Status update(BugInfo bugInfo){
        bugInfoService.updateByPrimaryKeySelective(bugInfo);
        return Status(SUCCESS);
    }
}
