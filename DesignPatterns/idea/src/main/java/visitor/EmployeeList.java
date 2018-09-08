package visitor;


import java.util.ArrayList;
import java.util.List;

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
public class EmployeeList {
    //定义一个集合用于存储抽象元素对象
    private List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee employee){
        list.add(employee);
    }

    public void accept(Department handler){
        for(Employee employee: list){
            employee.accept(handler);
        }
    }

}
