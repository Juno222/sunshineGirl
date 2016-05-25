package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.model.ModandPro;
import hll.sunshinegirl.mvc.model.Modle;
import hll.sunshinegirl.mvc.model.Project;
import hll.sunshinegirl.mvc.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/modle")
public class ModleController extends BaseController{

    @RequestMapping
    public String index(){
        return "modle";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public List<Modle> list(@RequestParam(value = "p", defaultValue = "1")Integer pagenum){
        List<Modle> list = modleService.selectPage(pagenum,PAGESIZE);
        return list;
    }

    @RequestMapping(value = "all",method = RequestMethod.GET)
    @ResponseBody
    public List<Modle> getAll(){
        List<Modle> all = modleService.selectPage(1, null);
        return all;
    }

    @RequestMapping(value = "new",method = RequestMethod.POST)
    @ResponseBody
    public Status add(Modle modle,Integer pId){
        Integer moId = modleService.insert(modle);
        ModandPro modandPro = new ModandPro();
        modandPro.setMoId(moId+"");
        modandPro.setpId(pId+"");
        modandProService.insert(modandPro);
        return Status(SUCCESS);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Modle get(@PathVariable Integer id){
        return modleService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Status edit(Modle modle){
        int status = modleService.updateByPrimaryKeySelective(modle);
        return Status(status);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Status del(@PathVariable Integer id){
        int status = modleService.deleteByPrimaryKey(id);
        return Status(status);
    }
}
