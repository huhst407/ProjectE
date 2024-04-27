package org.example.controller;

import org.example.pojo.Emp;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmpController {

//    @Qualifier("empServiceA") 必须跟Autowired注解一起使用
//    @Autowired //运行时, IOC容器会提供该类型的bean对象,并赋值给该变量 - 依赖注入
//    private EmpService empService ;
    @Resource(name = "empServiceB")
    private EmpService empService ;

    @RequestMapping("/listEmp")
    public Result list(){
        //1. 调用service, 获取数据
        List<Emp> empList = empService.listEmp();

        //3. 响应数据
        return Result.success(empList);
        ///http://localhost:8080/emp.html
    }
}
