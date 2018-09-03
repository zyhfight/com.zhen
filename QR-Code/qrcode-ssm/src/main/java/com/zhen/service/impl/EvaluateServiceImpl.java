package com.zhen.service.impl;

import com.zhen.dao.EvaluateDao;
import com.zhen.model.Evaluate;
import com.zhen.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Service
public class EvaluateServiceImpl implements EvaluateService{

    @Resource
    EvaluateDao evaluateDao;


    public Evaluate selectEvaluateById(String studentId) {
        return evaluateDao.selectEvaluateById(studentId);
    }

    public List<Evaluate> selectAllEvaluate() {
        return evaluateDao.selectAllEvaluate();
    }

    public boolean deleteEvaluate(String studentId) {
        int cnt = evaluateDao.deleteEvaluate(studentId);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean updateEvaluate(Evaluate evaluate){

        int cnt = evaluateDao.updateEvaluate(evaluate );
        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean  addEvaluate(Evaluate evaluate){
        int cnt = evaluateDao.addEvaluate(evaluate);

        if(cnt>0){
            return true;
        }

        return false;
    }
}
