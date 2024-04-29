package org.example;

import org.example.mapper.EmpMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.Emp;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MysqlTestApplicationTests {
    //UserMapper
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }
    //EmpMapper
    @Autowired
    private EmpMapper empMapper;

    //注解
    //根据ID删除
    @Test
    public void testDelete(){
        empMapper.delete(16);
    }

    //新增员工
    @Test
    public void testInsert(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setUsername("Tom3");
        emp.setName(null);
        emp.setImage("1.jpg");
        emp.setGender(null);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行新增员工信息操作
        empMapper.insert(emp);
        //测试打印返回的主键值
        System.out.println("主键值:"+emp.getId());
    }

    //更新员工
    @Test
    public void testUpdate(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行更新员工操作
        empMapper.update(emp);
    }

    //根据ID查询员工
    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(20);
        System.out.println(emp);
    }

    //XML
    //根据条件查询员工
    @Test
    public void testList(){
        List<Emp> empList = empMapper.list(null, null, null, null);
        System.out.println(empList);
    }

    //动态更新员工
    @Test
    public void testUpdate2(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(15);
        emp.setUsername("lwi");
        //执行更新员工操作
        empMapper.update2(emp);
    }

    //批量删除员工 - 14,15
    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList( 14, 15);
        empMapper.deleteByIds(ids);
    }
}
