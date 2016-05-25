package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.BugInfoMapper;
import hll.sunshinegirl.mvc.dao.BugManMapper;
import hll.sunshinegirl.mvc.model.BugInfo;
import hll.sunshinegirl.mvc.model.BugMan;
import hll.sunshinegirl.mvc.service.IBugInfoService;
import hll.sunshinegirl.mvc.service.IBugManService;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("bugManService")
public class BugManService implements IBugManService{
    @Autowired
    private BugManMapper bugManMapper;

    @Override
    public List<BugMan> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<BugMan> pageVo=new PaginationVo<BugMan>();
        if(pagesize != null) {
            pageVo.setCount(bugManMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return bugManMapper.selectPage(pageVo.getOffset(),pagesize);
    }

    @Override
    public BugMan getUserById(Integer id) {
        return bugManMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bugManMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BugMan record) {
        return bugManMapper.insert(record);
    }

    @Override
    public int insertSelective(BugMan record) {
        return bugManMapper.insertSelective(record);
    }

    @Override
    public BugMan selectByPrimaryKey(Integer id) {
        return bugManMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BugMan record) {
        return bugManMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BugMan record) {
        return bugManMapper.updateByPrimaryKey(record);
    }

    @Override
    public PaginationVo<BugMan> selectPageVo(Integer pagenum, Integer pagesize) {
        PaginationVo<BugMan> pageVo=new PaginationVo<BugMan>();
        if(pagesize != null) {
            pageVo.setCount(bugManMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        List<BugMan> bugMans = bugManMapper.selectBugMans(pageVo.getOffset(), pagesize);
        pageVo.setList(bugMans);
        return pageVo;
    }

    @Override
    public Integer bugAboutMeCount(Integer uId) {
        return bugManMapper.bugAboutMeCount(uId);
    }

    @Override
    public Integer bugSolvedCount(Integer uId, byte bSolveStatus) {
        return bugManMapper.bugSolvedCount(uId,bSolveStatus);
    }
}
