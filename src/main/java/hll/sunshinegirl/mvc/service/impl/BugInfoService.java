package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.BugInfoMapper;
import hll.sunshinegirl.mvc.dao.BugManMapper;
import hll.sunshinegirl.mvc.dao.LogMapper;
import hll.sunshinegirl.mvc.enums.BugInfoStatusEnum;
import hll.sunshinegirl.mvc.enums.BugSolveStatusEnum;
import hll.sunshinegirl.mvc.model.BugInfo;
import hll.sunshinegirl.mvc.model.BugMan;
import hll.sunshinegirl.mvc.model.Log;
import hll.sunshinegirl.mvc.model.User;
import hll.sunshinegirl.mvc.service.IBugInfoService;
import hll.sunshinegirl.mvc.service.IBugManService;
import hll.sunshinegirl.mvc.service.ILogService;
import hll.sunshinegirl.mvc.service.IUserService;
import hll.sunshinegirl.mvc.vo.FullBugVo;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import hll.sunshinegirl.mvc.vo.SingleManBugsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("bugInfoService")
public class BugInfoService implements IBugInfoService{
    @Autowired
    private BugInfoMapper bugInfoMapper;
    @Autowired
    private IBugManService bugManService;

    private final Integer DEFAULT = 4;

    @Override
    public List<BugInfo> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<BugInfo> pageVo=new PaginationVo<BugInfo>();
        if(pagesize != null) {
            pageVo.setCount(bugInfoMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return bugInfoMapper.selectPage(pagenum,pagesize);
    }

    @Override
    public BugInfo getUserById(Integer id) {
        return bugInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bugInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BugInfo record) {
        record.setbInfoStatus(BugInfoStatusEnum.UNCONFIRMED.value());
        record.setbSolveStatus(BugSolveStatusEnum.UNSOLEVD.value());
        bugInfoMapper.insert(record);
        return record.getbInfoId();
    }

    @Override
    public int insertSelective(BugInfo record) {
        return bugInfoMapper.insertSelective(record);
    }

    @Override
    public BugInfo selectByPrimaryKey(Integer id) {
        return bugInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BugInfo record) {
        return bugInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BugInfo record) {
        return bugInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public PaginationVo<List> fullBugInfoList(Integer moId,Integer pagenum) {
        PaginationVo<List> fullsVo = new PaginationVo<List>();
        PaginationVo<BugMan> bugMans = bugManService.selectPageVo(pagenum, DEFAULT);

        fullsVo.setCount(bugMans.getCount());
        fullsVo.setRows(bugMans.getRows());
        fullsVo.setPageNum(bugMans.getPageNum());
        List<List> fulls = new ArrayList<List>();
        for(BugMan m:bugMans.getList()){
            List<FullBugVo> singleFulls = bugInfoMapper.fullBugInfoList(moId,Integer.parseInt(m.getuId()));
            fulls.add(singleFulls);
        }
        fullsVo.setList(fulls);
        return fullsVo;
    }

    @Override
    public List<FullBugVo> myBugInfoList(Integer uId) {
        return bugInfoMapper.myBugInfoList(uId);
    }
}
