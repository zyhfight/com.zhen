package state.screen;

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
public class Screen {
    private State currentState,normalState,largerState,largestState;

    public Screen(){
        this.normalState = new NormalState();
        this.largerState = new LargerState();
        this.largestState = new LargestState();
        this.currentState = normalState;
        this.currentState.display();
    }

    public void setState(State state){
        this.currentState = state;
    }

    //状态转换
    public void onClick(){
        if(this.currentState == normalState){
            this.setState(largerState);//状态转换
            this.currentState.display();//执行业务
        }else if(this.currentState == largerState){
            this.setState(largestState);
            this.currentState.display();
        }else if(this.currentState == largestState){
            this.setState(normalState);
            this.currentState.display();
        }
    }
}
