package com.momo.springboot.controller;

import com.momo.springboot.dao.DepartmentDao;
import com.momo.springboot.dao.EmployeeDao;
import com.momo.springboot.entities.Department;
import com.momo.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author momo
 * @create 2019-06-04 下午 18:38
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //来到添加页面
    @GetMapping("/emp")
    public String toAdd(Map<String,Object> map){
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String add(Employee employee){
        System.out.println(employee);
        //保存员工
        employeeDao.save(employee);
        //  /表示当前项目的路径
        return "redirect:/emps";
    }

    //来到修改页面，重用添加页面
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee employee = employeeDao.get(id);
        map.put("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        return "emp/add";
    }

    //修改员工
//    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    @PutMapping("/emp")
    public String update(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
