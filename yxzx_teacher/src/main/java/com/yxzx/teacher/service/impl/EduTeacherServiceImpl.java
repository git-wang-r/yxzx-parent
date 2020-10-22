package com.yxzx.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxzx.teacher.entity.EduTeacher;
import com.yxzx.teacher.entity.query.Theacherquery;
import com.yxzx.teacher.mapper.EduTeacherMapper;
import com.yxzx.teacher.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author daidai
 * @since 2020-10-20
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    //实现条件查询
    public void pageQuery (Page<EduTeacher> pageParam, Theacherquery theacherquery){
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("sort");
        if (theacherquery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        String name =theacherquery.getName();
        Integer level = theacherquery.getLevel();
        String begin = theacherquery.getBegin();
        String end = theacherquery.getEnd();
        if (name!=null){
            queryWrapper.like("name",name);
        }
        if (level!=null){
            queryWrapper.eq("level",level);
        }
        if (begin!=null){
            queryWrapper.ge("gmt_create", begin);
        }
        if (end!=null){
            queryWrapper.le("gmt_create", end);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
