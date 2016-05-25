package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.BugInfoMapper;
import hll.sunshinegirl.mvc.dao.BugReplyMapper;
import hll.sunshinegirl.mvc.model.BugInfo;
import hll.sunshinegirl.mvc.model.BugReply;
import hll.sunshinegirl.mvc.service.IBugInfoService;
import hll.sunshinegirl.mvc.service.IBugReplyService;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("bugReplyService")
public class BugReplyService implements IBugReplyService {
    @Autowired
    private BugReplyMapper bugReplyMapper;

    @Override
    public List<BugReply> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<BugReply> pageVo=new PaginationVo<BugReply>();
        if(pagesize != null) {
            pageVo.setCount(bugReplyMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return bugReplyMapper.selectPage(pagenum,pagesize);

    }

    @Override
    public BugReply getUserById(Integer id) {
        return bugReplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bugReplyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BugReply record) {
        return bugReplyMapper.insert(record);
    }

    @Override
    public int insertSelective(BugReply record) {
        return bugReplyMapper.insertSelective(record);
    }

    @Override
    public BugReply selectByPrimaryKey(Integer id) {
        return bugReplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BugReply record) {
        return bugReplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BugReply record) {
        return bugReplyMapper.updateByPrimaryKey(record);
    }

}
