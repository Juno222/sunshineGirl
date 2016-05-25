package hll.sunshinegirl.mvc.service.impl;

import hll.sunshinegirl.mvc.dao.UserMapper;
import hll.sunshinegirl.mvc.model.User;
import hll.sunshinegirl.mvc.service.IUserService;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserService implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User user) {
        userMapper.insert(user);
        return user.getuId();
    }

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User login(User user){
        return userMapper.login(user);
    }

    @Override
    public List<User> selectPage(Integer pagenum, Integer pagesize) {
        PaginationVo<User> pageVo=new PaginationVo<User>();
        if(pagesize != null) {
            pageVo.setCount(userMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        return userMapper.selectPage(pagenum,pagesize);
    }

    @Override
    public PaginationVo<User> selectPageVo(Integer pagenum, Integer pagesize) {
        PaginationVo<User> pageVo=new PaginationVo<User>();
        if(pagesize != null) {
            pageVo.setCount(userMapper.selectCount());
            pageVo.setRows(pagesize);
            pageVo.setPageNum(pagenum);
        }
        List<User> users = userMapper.selectPage(pageVo.getOffset(), pagesize);
        pageVo.setList(users);
        return pageVo;
    }

    @Override
    public Integer userCount (){
        return userMapper.selectCount();
    }
}
