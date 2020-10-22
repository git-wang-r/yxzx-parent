package com.yxzx.teacher.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxzx.teacher.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yxzx.teacher.entity.query.Theacherquery;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author daidai
 * @since 2020-10-20
 */
@Service
public interface EduTeacherService extends IService<EduTeacher> {
    /*添加条件查询*/
    public void pageQuery (Page<EduTeacher> pageParam, Theacherquery theacherquery);

}
