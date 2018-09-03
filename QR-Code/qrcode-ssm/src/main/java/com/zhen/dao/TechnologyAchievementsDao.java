package com.zhen.dao;

import com.zhen.model.TechnologyAchievements;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Repository
public interface TechnologyAchievementsDao {

    List<TechnologyAchievements> selectTechnologyAchievementsById(String studentId);

    List<TechnologyAchievements> selectAllTechnologyAchievements();

    TechnologyAchievements   selectTechnologyAchievement(String studentId,String achievementId);

    int deleteTechnologyAchievements(String studentId,String achievementId);

    int updateTechnologyAchievements(TechnologyAchievements technologyAchievements);

    int addTechnologyAchievements(TechnologyAchievements technologyAchievements);

    int deleteTechnologyAchievementById(String studentId);

}
