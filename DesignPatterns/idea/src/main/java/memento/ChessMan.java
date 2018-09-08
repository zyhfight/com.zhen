package memento;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 象棋棋子类：原发器
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class ChessMan {
    private String label;
    private int x;
    private int y;

    public ChessMan(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //保存状态
    public ChessmanMemento save(){
        return new ChessmanMemento(this.label,this.x,this.y);
    }

    //恢复状态
    public void restore(ChessmanMemento memento){
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }

    @Override
    public String toString() {
        return "ChessMan{" +
                "label='" + label + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
