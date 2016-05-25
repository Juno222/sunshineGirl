package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.model.ModandPro;
import hll.sunshinegirl.mvc.model.Modle;
import hll.sunshinegirl.mvc.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/mp")
public class ModandProController extends BaseController{

    @RequestMapping
    public String index(){
        return "mp";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public List<Modle> list(Integer pId){
        List<Modle> list = modandProService.selectByProject(pId);
        return list;
    }

    @RequestMapping(value = "all",method = RequestMethod.GET)
    @ResponseBody
    public List<ModandPro> getAll(){
        List<ModandPro> all = modandProService.selectPage(1, null);
        return all;
    }

    @RequestMapping(value = "new",method = RequestMethod.POST)
    @ResponseBody
    public Status add(ModandPro modandPro){
        modandProService.insert(modandPro);
        return Status(SUCCESS);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ModandPro get(@PathVariable Integer id){
        return modandProService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Status edit(ModandPro modandPro){
        int status = modandProService.updateByPrimaryKeySelective(modandPro);
        return Status(status);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Status del(@PathVariable Integer id){
        int status = modandProService.deleteByPrimaryKey(id);
        return Status(status);
    }
}
