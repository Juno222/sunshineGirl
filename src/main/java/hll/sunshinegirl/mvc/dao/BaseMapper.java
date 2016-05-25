package hll.sunshinegirl.mvc.dao;

import hll.sunshinegirl.mvc.model.Pojo;
import hll.sunshinegirl.mvc.vo.PaginationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;




public interface BaseMapper<T extends Pojo> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectPage(@Param("offset")Integer offset,@Param("pagesize")Integer pagesize);

    int selectCount();
}
