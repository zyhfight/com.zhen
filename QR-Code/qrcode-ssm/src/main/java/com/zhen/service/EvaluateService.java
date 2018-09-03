package com.zhen.service;

import com.zhen.model.Evaluate;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
public interface EvaluateService {

    Evaluate selectEvaluateById(String studentId);

    List<Evaluate> selectAllEvaluate();

    boolean deleteEvaluate(String studentId);

    boolean updateEvaluate(Evaluate evaluate);

    boolean  addEvaluate(Evaluate evaluate);

}
