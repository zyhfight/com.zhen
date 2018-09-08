package state.switchshare;

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
public class Switch {
    private static State state,onState,offState;
    private String name;

    public Switch(String name){
        this.name = name;
        onState = new OnState();
        offState = new OffState();
        state = onState;
    }

    public void setState(State state){
        state = state;
    }

    public static  State getState(String type){
        if("on".equalsIgnoreCase(type)){
            return onState;
        }else{
            return offState;
        }
    }

    public void on(){
        System.out.println(name);
        state.on(this);
    }

    public void off(){
        System.out.println(name);
        state.off(this);
    }

}
