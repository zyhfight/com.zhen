package com.zhen.dao;

import com.zhen.model.Evaluate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Repository
public interface EvaluateDao {

    //根据学生学号查询
    Evaluate selectEvaluateById(String studentId);

    List<Evaluate> selectAllEvaluate();

    int deleteEvaluate(String studentId);

    int updateEvaluate(Evaluate evaluate);

    int addEvaluate(Evaluate evaluate);

}
