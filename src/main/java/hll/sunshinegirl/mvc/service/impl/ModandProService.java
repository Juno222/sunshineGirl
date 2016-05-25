package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.ModandProMapper;
import hll.sunshinegirl.mvc.dao.ProjectMapper;
import hll.sunshinegirl.mvc.model.ModandPro;
import hll.sunshinegirl.mvc.model.Modle;
import hll.sunshinegirl.mvc.model.Project;
import hll.sunshinegirl.mvc.service.IModandProService;
import hll.sunshinegirl.mvc.service.IProjectService;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("modandProService")
public class ModandProService implements IModandProService{
    @Autowired
    private ModandProMapper modandProMapper;
    @Autowired
    private ModelService modelService;

    @Override
    public List<ModandPro> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<ModandPro> pageVo=new PaginationVo<ModandPro>();
        if(pagesize != null) {
            pageVo.setCount(modandProMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return modandProMapper.selectPage(pagenum, pagesize);

    }

    @Override
    public ModandPro getUserById(Integer id) {
        return modandProMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return modandProMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ModandPro modandPro) {
        return modandProMapper.insert(modandPro);
    }

    @Override
    public int insertSelective(ModandPro modandPro) {
        return modandProMapper.insertSelective(modandPro);
    }

    @Override
    public ModandPro selectByPrimaryKey(Integer id) {
        return modandProMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ModandPro modandPro) {
        return modandProMapper.updateByPrimaryKeySelective(modandPro);
    }

    @Override
    public int updateByPrimaryKey(ModandPro modandPro) {
        return modandProMapper.updateByPrimaryKey(modandPro);
    }

    @Override
    public List<Modle> selectByProject(Integer pId) {
        List<Modle> modles = new ArrayList<Modle>();
        List<ModandPro> modandPros = modandProMapper.selectByProject(pId);
        for(ModandPro m:modandPros){
            Integer moId = Integer.parseInt(m.getMoId());
            modles.add(modelService.selectByPrimaryKey(moId));
        }
        return modles;
    }
}
