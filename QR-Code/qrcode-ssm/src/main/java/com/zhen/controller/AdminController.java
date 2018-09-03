package com.zhen.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhen.model.*;
import com.zhen.service.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger log = Logger.getLogger(AdminController.class);

    @Resource
    private StudentInfoService studentInfoService;

    @Resource
    private SubjectScoreService scoreService;

    @Resource
    TechnologyAchievementService achievementService;

    @Resource
    EvaluateService evaluateService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        Evaluate evaluate = evaluateService.selectEvaluateById("B13040335");

        System.out.println(evaluate);

        return "index";
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAllUser(){

        List<StudentInfo> studentInfos = studentInfoService.selectAllStudentInfo();

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(studentInfos);

        map.put("data",result);

        return map;

    }

    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getStudentInfo(String studentId){

        StudentInfo studentInfo = studentInfoService.selectStudentInfoById(studentId);

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(studentInfo);

        map.put("data",result);

        return map;

    }

    @RequestMapping(value = "/deleteStudentInfo",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> deleteStudentInfo(String studentId){

        System.out.println(studentId);

        boolean flag = studentInfoService.deleteStudentInfo(studentId);
        evaluateService.deleteEvaluate(studentId);
        scoreService.deleteSubjectScore(studentId);
        achievementService.deleteTechnologyAchievementById(studentId);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }

    @RequestMapping(value = "/addStudentInfo",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addStudentInfo(StudentInfo studentInfo){

        System.out.println(studentInfo);

        studentInfo.setCreateTime(new Date());
        studentInfo.setUpdateTime(new Date());


        boolean flag = studentInfoService.addStudentInfo(studentInfo);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }

    @RequestMapping(value = "/updateStudentInfo",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> updateStudentInfo(StudentInfo studentInfo){

        System.out.println(studentInfo);

        studentInfo.setUpdateTime(new Date());

        boolean flag = studentInfoService.updateStudentInfo(studentInfo);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }

    @RequestMapping(value = "/getSubjectScoreById",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getSubjectScoreById(String studentId){

        SubjectScore subjectScore = scoreService.selectSubjectScoreById(studentId);

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(subjectScore);

        map.put("data",result);

        return map;

    }

    @RequestMapping(value = "/getAchievementsById",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAchievementsById(String studentId){

       List<TechnologyAchievements>  achievements = achievementService.selectTechnologyAchievementsById(studentId);

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(achievements);

        map.put("data",result);

        return map;
    }

    @RequestMapping(value = "/getEvaluate",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getEvaluate(String studentId){

         Evaluate evaluate = evaluateService.selectEvaluateById(studentId);

         Map<String, Object> map = new HashMap<String, Object>();

         String result = JSONObject.toJSONString(evaluate);

         map.put("data",result);

        return map;
    }


    @RequestMapping(value = "/getAllSubjectScore",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAllSubjectScore(){

        List<SubjectScore> scoreList = scoreService.selectAllSubjectScore();

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(scoreList);

        map.put("data",result);

        return map;

    }

    @RequestMapping(value = "/deleteSubjectScore",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> deleteSubjectScore(String studentId){

        System.out.println(studentId);

        boolean flag = scoreService.deleteSubjectScore(studentId);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }


    @RequestMapping(value = "/updateSubjectScore",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> updateSubjectScore(SubjectScore subjectScore){

        System.out.println(subjectScore);

        subjectScore.setUpdateTime(new Date());

        boolean flag = scoreService.updateSubjectScore(subjectScore);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }
    @RequestMapping(value = "/addSubjectScore",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addSubjectScore(SubjectScore subjectScore){

        System.out.println(subjectScore);

        Map<String, Object> map = new HashMap<String, Object>();
        StudentInfo studentInfo = studentInfoService.selectStudentInfoById(subjectScore.getStudentId());
        if(studentInfo==null){
            map.put("data","NO");
            return  map;
        }

        subjectScore.setCreateTime(new Date());
        subjectScore.setUpdateTime(new Date());

        boolean flag = scoreService.addSubjectScore(subjectScore);



        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }

    @RequestMapping(value = "/getAllEvaluate",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAllEvaluate(){

        List<Evaluate> evaluates = evaluateService.selectAllEvaluate();

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(evaluates);

        map.put("data",result);

        return map;

    }

    @RequestMapping(value = "/deleteEvaluate",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> deleteEvaluate(String studentId){

        System.out.println(studentId);

        boolean flag = evaluateService.deleteEvaluate(studentId);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }

    @RequestMapping(value = "/updateEvaluate",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> updateEvaluate(Evaluate evaluate){

        System.out.println(evaluate);

        evaluate.setUpdateTime(new Date());

        boolean flag = evaluateService.updateEvaluate(evaluate);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }


    @RequestMapping(value = "/addEvaluate",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addEvaluate(Evaluate evaluate){

        System.out.println(evaluate);

        Map<String, Object> map = new HashMap<String, Object>();

        StudentInfo studentInfo = studentInfoService.selectStudentInfoById(evaluate.getStudentId());
        if(studentInfo==null){
            map.put("data","NO");
            return  map;
        }

        evaluate.setCreateTime(new Date());
        evaluate.setUpdateTime(new Date());

        boolean flag = evaluateService.addEvaluate(evaluate);

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }

    @RequestMapping(value = "/getAllAchievements",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAllAchievements(){

        List<TechnologyAchievements> achievementss = achievementService.selectAllTechnologyAchievements();

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(achievementss);

        map.put("data",result);

        return map;

    }

    @RequestMapping(value = "/getAchievement",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAchievement(String studentId,String achievementId){

        TechnologyAchievements  achievements = achievementService.selectTechnologyAchievement(studentId,achievementId);

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(achievements);

        map.put("data",result);

        return map;
    }


    @RequestMapping(value = "/updateAchievements",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> updateAchievements(TechnologyAchievements achievement){

        System.out.println(achievement);

        achievement.setUpdateTime(new Date());

        boolean flag = achievementService.updateTechnologyAchievements(achievement);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }


    @RequestMapping(value = "/addAchievements",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addAchievements(TechnologyAchievements achievement){

        System.out.println(achievement);

        Map<String, Object> map = new HashMap<String, Object>();
        StudentInfo studentInfo = studentInfoService.selectStudentInfoById(achievement.getStudentId());
        if(studentInfo==null){
            map.put("data","NO");
            return  map;
        }

        achievement.setCreateTime(new Date());
        achievement.setUpdateTime(new Date());

        boolean flag = achievementService.addTechnologyAchievements(achievement);

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }

    @RequestMapping(value = "/deleteAchievement",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> deleteEvaluate(String studentId,String achievementId){

        System.out.println(studentId);

        boolean flag = achievementService.deleteTechnologyAchievements(studentId,achievementId);

        Map<String, Object> map = new HashMap<String, Object>();

        if(flag){
            map.put("data","OK");
        }else{
            map.put("data","NO");
        }

        return map;

    }




    @RequestMapping(value = "/getAllSum",method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAllSum(){

        List<StudentInfo> studentInfos = studentInfoService.selectAllStudentInfo();

        List<Ability> abilityList = new ArrayList<Ability>();


        for(StudentInfo studentInfo : studentInfos){

            Ability ability =new Ability();

            String studentId = studentInfo.getStudentId();
            SubjectScore subjectScore =  scoreService.selectSubjectScoreById(studentId);
            int subjectSumScore = 0;

            if(subjectScore!=null){
                subjectSumScore= subjectScore.getMath()+subjectScore.getPhysical()+subjectScore.getEnglish();
            }



            Evaluate evaluate = evaluateService.selectEvaluateById(studentId);

            int evaluateSumScore =0;
            if(evaluate!=null){
                evaluateSumScore =evaluate.getEvaluateScore();
            }


            int achievementSumScore = 0;
            List<TechnologyAchievements> achievementsList = achievementService.selectTechnologyAchievementsById(studentId);

            if(achievementsList!=null){
                for(TechnologyAchievements achievement : achievementsList){
                    achievementSumScore+=achievement.getAchievementScore();
                }
            }

            double sumScore =  getSumScore(studentId);

            ability.setStudentId(studentId);
            ability.setSubjectSumScore(subjectSumScore);
            ability.setEvaluateSumScore(evaluateSumScore);
            ability.setAchievementSumScore(achievementSumScore);
            ability.setSumScore(sumScore);

            abilityList.add(ability);
        }

        Collections.sort(abilityList, new Comparator<Ability>() {
            public int compare(Ability o1, Ability o2) {
                return o1.getSumScore()<o2.getSumScore() ? 1:o1.getSumScore()>o2.getSumScore()?-1:0;
            }
        });

        Map<String, Object> map = new HashMap<String, Object>();

        String result = JSONObject.toJSONString(abilityList);

        map.put("data",result);

        return map;
    }


    //获取综合能力得分
    private double getSumScore(String studentId){

        Evaluate evaluate = evaluateService.selectEvaluateById(studentId);

        List<TechnologyAchievements>  achievements = achievementService.selectTechnologyAchievementsById(studentId);

        SubjectScore subjectScore = scoreService.selectSubjectScoreById(studentId);

        double evaluatScore=0;
        if(evaluate!=null){
            evaluatScore =evaluate.getEvaluateScore()*1.2;
        }

        double score=0;
        if(subjectScore!=null){
            score = subjectScore.getEnglish()+subjectScore.getMath()+subjectScore.getPhysical();
        }

        double achievementsScore=0;
        if(achievements!=null){
            for(TechnologyAchievements achievement: achievements){
                achievementsScore+=achievement.getAchievementScore()*0.8;
            }
        }


        return evaluatScore+achievementsScore+score;
    }

}
