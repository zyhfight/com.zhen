package com.zhen.service.impl;

import com.zhen.dao.TechnologyAchievementsDao;
import com.zhen.model.TechnologyAchievements;
import com.zhen.service.TechnologyAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/9.
 */
@Service
public class TechnologyAchievementServiceImpl implements TechnologyAchievementService {

    @Autowired
    TechnologyAchievementsDao achievementsDao;

    public List<TechnologyAchievements> selectTechnologyAchievementsById(String studentId) {
        return achievementsDao.selectTechnologyAchievementsById(studentId);
    }

    public List<TechnologyAchievements> selectAllTechnologyAchievements() {
        return achievementsDao.selectAllTechnologyAchievements();
    }

    public TechnologyAchievements selectTechnologyAchievement(String studentId, String achievementId) {
        return achievementsDao.selectTechnologyAchievement(studentId,achievementId);
    }

    public boolean updateTechnologyAchievements(TechnologyAchievements technologyAchievements) {

        int cnt = achievementsDao.updateTechnologyAchievements(technologyAchievements);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean addTechnologyAchievements(TechnologyAchievements technologyAchievements) {

        int cnt = achievementsDao.addTechnologyAchievements(technologyAchievements);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean deleteTechnologyAchievements(String studentId,String achievementId) {
        int cnt = achievementsDao.deleteTechnologyAchievements(studentId,achievementId);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean deleteTechnologyAchievementById(String studentId) {
        int cnt = achievementsDao.deleteTechnologyAchievementById(studentId);

        if(cnt>0){
            return true;
        }

        return false;
    }
}
