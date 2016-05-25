package hll.sunshinegirl.mvc.service;

import hll.sunshinegirl.mvc.model.BugInfo;
import hll.sunshinegirl.mvc.vo.FullBugVo;
import hll.sunshinegirl.mvc.vo.PaginationVo;

import java.util.List;



public interface IBugInfoService extends IBaseService<BugInfo>{

    PaginationVo<List> fullBugInfoList(Integer moId,Integer pagenum);

    List<FullBugVo> myBugInfoList(Integer uId);
}
