package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.ModleMapper;
import hll.sunshinegirl.mvc.dao.ProjectMapper;
import hll.sunshinegirl.mvc.model.Modle;
import hll.sunshinegirl.mvc.model.Project;
import hll.sunshinegirl.mvc.service.IModleService;
import hll.sunshinegirl.mvc.service.IProjectService;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("modelService")
public class ModelService implements IModleService{
    @Autowired
    private ModleMapper modelMapper;

    @Override
    public List<Modle> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<Modle> pageVo=new PaginationVo<Modle>();
        if(pagesize != null) {
            pageVo.setCount(modelMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return modelMapper.selectPage(pagenum,pagesize);
    }

    @Override
    public Modle getUserById(Integer id) {
        return modelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return modelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Modle modle) {
        modelMapper.insert(modle);
        return modle.getMoId();
    }

    @Override
    public int insertSelective(Modle modle) {
        return modelMapper.insertSelective(modle);
    }

    @Override
    public Modle selectByPrimaryKey(Integer id) {
        return modelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Modle modle) {
        return modelMapper.updateByPrimaryKeySelective(modle);
    }

    @Override
    public int updateByPrimaryKey(Modle modle) {
        return modelMapper.updateByPrimaryKey(modle);
    }


}
