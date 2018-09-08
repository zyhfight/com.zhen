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
public class VisitorClient {

    public static void main(String[] args) {
       //创建元素
        EmployeeList employeeList = new EmployeeList();
        Employee employee1 = new FulltimeEmployee("张无忌",8500,45);
        Employee employee2 = new FulltimeEmployee("杨过",9500,40);
        Employee employee3 = new FulltimeEmployee("洪七公",10500,38);
        Employee employee4= new ParttimeEmployee("郭靖",60,18);

        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        employeeList.addEmployee(employee3);
        employeeList.addEmployee(employee4);

        //创建访问者
        Department department = new FADepartment();
        //访问元素
        employeeList.accept(department);



    }

}
