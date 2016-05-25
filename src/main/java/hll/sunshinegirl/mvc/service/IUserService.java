package hll.sunshinegirl.mvc.service;

import hll.sunshinegirl.mvc.model.Pojo;
import hll.sunshinegirl.mvc.model.User;
import hll.sunshinegirl.mvc.vo.PaginationVo;


public interface IUserService extends IBaseService<User>{
    User login(User user);

    PaginationVo<User> selectPageVo(Integer pagenum, Integer pagesize);

    Integer userCount ();
}
