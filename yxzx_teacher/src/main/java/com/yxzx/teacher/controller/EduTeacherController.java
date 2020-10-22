package com.yxzx.teacher.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.yxzx.common.result.Result;
import com.yxzx.teacher.entity.EduTeacher;
import com.yxzx.teacher.entity.query.Theacherquery;
import com.yxzx.teacher.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.net.www.protocol.ftp.Handler;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author daidai
 * @since 2020-10-20
 */
@RestController
@RequestMapping("/teacher")
public class EduTeacherController {

    //注入service
    @Autowired
    private EduTeacherService   eduTeacherService;

    //测试

    @GetMapping("/test")
    public void  test(@RequestHeader Map s){
        System.out.println(s);
    }
//    查询所有讲师

    @RequestMapping("/list")
    public Result selectTlist(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.ok().data("list",list);
    }

    //通过id查讲师
    @GetMapping("{id}")
    public String add(@PathVariable String id){

        boolean removeById = eduTeacherService.removeById(id);
        if (removeById){
            return "true";
        }else {
            return "false";
        }
    }
    //分页查询  传入一个当前页和每页显示的条数
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public Result pageList(@PathVariable Long page, @PathVariable Long limit, Theacherquery teacherQuery){
//创建分页条件
        Page<EduTeacher> pageParam = new Page<>(page, limit);
//

        eduTeacherService.pageQuery(pageParam,teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

  /*      eduTeacherService.page(pageParam, null);
//获取某页的集合数据
        List<EduTeacher> records = pageParam.getRecords();
        //总记录数
        long total = pageParam.getTotal();
*/
        return  Result.ok().data("total", total).data("rows", records);
    }
    //添加教师

    @PostMapping("/add")
    public Result add(@RequestBody EduTeacher teacher){
        eduTeacherService.save(teacher);
        return Result.ok();

    }
    //通过id查询
    @GetMapping("/findteacher/{id}")
    public Result findteacher(@PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return Result.ok().data("item",teacher);

    }

    //修改教师

    @PostMapping("/update")
    public Result update(@PathVariable String id,@RequestBody EduTeacher teacher){
        teacher.setId(id);
        eduTeacherService.updateById(teacher);
        return Result.ok();

    }


}

