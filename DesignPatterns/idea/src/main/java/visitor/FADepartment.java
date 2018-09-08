package visitor;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public class FADepartment extends Department{
    @Override
    public void visit(FulltimeEmployee employee) {
       int workTime = employee.getWorkTime();
       double weekWage = employee.getWeeklyWage();
       if(workTime >= 40){
           weekWage = weekWage + (workTime -40) * 100;
       }else if(workTime < 40){
           weekWage = weekWage - (40 - workTime) * 80;
           if(weekWage < 0){
               weekWage = 0;
           }
       }
       System.out.println("正式员工：" + employee.getName() + "实际工资： " + weekWage);

    }

    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println("临时工：" + employee.getName() + "实际工资为：" + employee.getHourWage()*workTime);
    }
}
