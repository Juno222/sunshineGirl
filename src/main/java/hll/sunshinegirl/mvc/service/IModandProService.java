package hll.sunshinegirl.mvc.service;



import hll.sunshinegirl.mvc.model.ModandPro;
import hll.sunshinegirl.mvc.model.Modle;

import java.util.List;


public interface IModandProService extends IBaseService<ModandPro> {
    List<Modle> selectByProject(Integer pId);
}
