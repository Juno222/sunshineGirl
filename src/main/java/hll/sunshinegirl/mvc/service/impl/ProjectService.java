package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.ProjectMapper;
import hll.sunshinegirl.mvc.dao.UserMapper;
import hll.sunshinegirl.mvc.model.Project;
import hll.sunshinegirl.mvc.model.User;
import hll.sunshinegirl.mvc.service.IProjectService;
import hll.sunshinegirl.mvc.service.IUserService;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("projectService")
public class ProjectService implements IProjectService{
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<Project> pageVo = new PaginationVo<Project>();
        if(pagesize != null) {
            pageVo.setCount(projectMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return projectMapper.selectPage(pageVo.getOffset(),pagesize);
    }

    @Override
    public Project getUserById(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Project project) {
        return projectMapper.insert(project);
    }

    @Override
    public int insertSelective(Project project) {
        return projectMapper.insertSelective(project);
    }

    @Override
    public Project selectByPrimaryKey(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Project project) {
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public int updateByPrimaryKey(Project project) {
        return projectMapper.updateByPrimaryKey(project);
    }

}
