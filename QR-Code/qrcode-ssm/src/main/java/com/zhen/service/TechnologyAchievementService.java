package com.zhen.service;

import com.zhen.model.TechnologyAchievements;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/9.
 */
public interface TechnologyAchievementService {

    List<TechnologyAchievements> selectTechnologyAchievementsById(String studentId);

    List<TechnologyAchievements> selectAllTechnologyAchievements();

    TechnologyAchievements   selectTechnologyAchievement(String studentId,String achievementId);

    boolean deleteTechnologyAchievements(String studentId,String achievementId);

    boolean deleteTechnologyAchievementById(String studentId);

    boolean updateTechnologyAchievements(TechnologyAchievements technologyAchievements);

    boolean addTechnologyAchievements(TechnologyAchievements technologyAchievements);
}
