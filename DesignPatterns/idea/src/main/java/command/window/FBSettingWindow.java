package command.window;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 功能键设置窗口类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-21     zyh           v1.0.0               修改原因
 */
public class FBSettingWindow {
    private String title;
    private List<FunctionButton> functionButtons = new ArrayList<>();

    public FBSettingWindow(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addFunctionButton(FunctionButton fb){
        functionButtons.add(fb);
    }

    public void removeFuntionButton(FunctionButton fb){
        functionButtons.remove(fb);
    }

    public void display(){
        System.out.println("显示窗口： " + this.title);
        System.out.println("显示功能键： ");
        for(FunctionButton fb : functionButtons){
            System.out.println(fb.getName());
        }
        System.out.println("-----------------------------------------------------");
    }
}
