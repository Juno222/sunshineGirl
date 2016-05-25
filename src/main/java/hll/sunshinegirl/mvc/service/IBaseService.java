package hll.sunshinegirl.mvc.service;

import hll.sunshinegirl.mvc.model.Pojo;

import java.util.List;


public interface IBaseService<T extends Pojo> {
    T getUserById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    List<T> selectPage(Integer pagenum,Integer pagesize);
}
