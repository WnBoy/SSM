package com.xupt.springmvc.crud.handlers;

import com.xupt.springmvc.crud.dao.DepartmentDao;
import com.xupt.springmvc.crud.dao.EmployeeDao;
import com.xupt.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-07 19:38
 */
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 从数据库中获取数据
     *
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id,
                            Map<String, Object> map) {
        if (id != null) {//ID不为空，说明是修改操作，需要从数据库中获取employee对象
            Employee employee = employeeDao.get(id);
            map.put("employee", employee);
        }
    }

    /**
     * 修改操作
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(@ModelAttribute("employee") Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 跳转到修改页面的方法
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments());
        return "input";
    }

    /**
     * 删除操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    /**
     * 添加操作
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {//如果有错误，就打印错误信息
            for (FieldError error : result.getFieldErrors()) {
                System.out.println(error.getField() + "::" + error.getDefaultMessage());
            }
            return "input";
        }
        employeeDao.save(employee);
        return "redirect:/emps";

    }

    /**
     * 获取添加页面
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "emp", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }

    /**
     * 列表显示
     *
     * @param map
     * @return
     */
    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {
        map.put("emps", employeeDao.getAll());
        return "list";
    }

}
