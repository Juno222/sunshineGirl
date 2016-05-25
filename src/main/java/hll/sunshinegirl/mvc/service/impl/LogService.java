package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.LogMapper;
import hll.sunshinegirl.mvc.dao.ModandProMapper;
import hll.sunshinegirl.mvc.model.Log;
import hll.sunshinegirl.mvc.model.ModandPro;
import hll.sunshinegirl.mvc.service.ILogService;
import hll.sunshinegirl.mvc.service.IModandProService;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("logService")
public class LogService implements ILogService{
    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<Log> pageVo=new PaginationVo<Log>();
        if(pagesize != null) {
            pageVo.setCount(logMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return logMapper.selectPage(pagenum, pagesize);

    }

    @Override
    public Log getUserById(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return logMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Log record) {
        return logMapper.insert(record);
    }

    @Override
    public int insertSelective(Log record) {
        return logMapper.insertSelective(record);
    }

    @Override
    public Log selectByPrimaryKey(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Log record) {
        return logMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Log record) {
        return logMapper.updateByPrimaryKey(record);
    }

}
