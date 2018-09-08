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
public class HRDepartment extends Department {
    @Override
    public void visit(FulltimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("正式员工： " + employee.getName() + "实际工作时间： " + workTime);
        if(workTime > 40){
            System.out.println("正式员工： " + employee.getName() +  "加班： " + (workTime - 40) + "小时");
        }else if(workTime < 40){
            System.out.println("正式员工： " + employee.getName() + "请假： " + (40 -workTime) + "小时");
        }
    }

    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("临时工： " + employee.getName() + "实际工作时间： "  + workTime + "小时");
    }
}
