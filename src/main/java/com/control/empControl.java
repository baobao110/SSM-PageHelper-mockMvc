package com.control;

import com.ajax.ajaxDAO;
import com.domain.emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.empMapper;
import com.service.empService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 处理员工
 */
@Controller
@RequestMapping("/emp")
public class empControl {

    @Autowired
    private empService emp;

  /*  @Autowired
    private empMapper mapper;*/

    @RequestMapping("/toList")
    public String toList() {
        return "list";
    }

    /*  从这里知道是ajax就是用json串返回，所以用fastjson的依赖，如果不用依赖返回的是页面而不是Json字符串*/
    @RequestMapping("/all")
    @ResponseBody
    public ajaxDAO list(@RequestParam(value="pn",defaultValue = "1") Integer pn){
      /*  使用Mybatis的分页查询工具PageHelper进行分页查询，方法的前一个参数是查询第几页，以及每页多少条记录*/
        PageHelper.startPage(pn,5);
        List<emp> list=emp.getAll();
        //用PageInfo对结果进行包装,只需要将PageInfo交给前端,导航显示页码数为5
        PageInfo page = new PageInfo(list,5);
       return ajaxDAO.success(page);
    }

    /*这里的作用见SpringMVC模拟请求发送*/
   /* @RequestMapping("/all")
    public String  list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<emp> list = mapper.GetAll();
        PageInfo pag=new PageInfo(list);
        model.addAttribute("pagInfo",pag);
        return "list";
    }*/


}