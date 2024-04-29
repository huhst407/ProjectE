package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //根据ID删除数据
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    //新增员工
    @Options(useGeneratedKeys = true, keyProperty = "id")
    //主键值返回
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    //更新员工
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}," +
            " job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

    //根据ID查询员工
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    //动态条件查询
    public List<Emp> list(@Param("name")String name, @Param("gender")Short gender, @Param("begin")LocalDate begin , @Param("end")LocalDate end);


    //动态更新员工
    public void update2(Emp emp);


    //批量删除员工
    public void deleteByIds(List<Integer> ids);
}
