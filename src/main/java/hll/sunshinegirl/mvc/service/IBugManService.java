package hll.sunshinegirl.mvc.service;

import hll.sunshinegirl.mvc.model.BugMan;
import hll.sunshinegirl.mvc.vo.PaginationVo;


public interface IBugManService extends IBaseService<BugMan> {
    PaginationVo<BugMan> selectPageVo(Integer pagenum, Integer pagesize);

    Integer bugAboutMeCount(Integer uId);

    Integer bugSolvedCount(Integer uId,byte bSolveStatus);
}
