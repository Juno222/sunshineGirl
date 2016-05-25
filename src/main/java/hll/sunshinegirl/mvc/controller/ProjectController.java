package hll.sunshinegirl.mvc.controller;

import hll.sunshinegirl.mvc.enums.StatusEnum;
import hll.sunshinegirl.mvc.model.Project;
import hll.sunshinegirl.mvc.model.Status;
import hll.sunshinegirl.mvc.model.User;
import hll.sunshinegirl.mvc.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;



@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{

    @RequestMapping
    public String index(ModelMap map){
        User user = currentUser.currentUser();
        map.put("uName",user.getuName());
        return "project";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getProjects(@RequestParam(value = "p", defaultValue = "1")Integer pagenum){
        List<Project> projects = projectService.selectPage(pagenum,PAGESIZE);
        return projects;
    }

    @RequestMapping(value = "all",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getAll(){
        List<Project> projects = projectService.selectPage(1,null);
        return projects;
    }

    @RequestMapping(value = "new",method = RequestMethod.POST)
    @ResponseBody
    public Status addProject(Project project){
        projectService.insert(project);
        return Status(SUCCESS);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Project get(@PathVariable Integer id){
        return projectService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Status edit(Project project){
        int status = projectService.updateByPrimaryKeySelective(project);
        return Status(status);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Status del(@PathVariable Integer id){
        int status = projectService.deleteByPrimaryKey(id);
        return Status(status);
    }

}
