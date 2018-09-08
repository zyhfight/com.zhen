package memento;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class MementoClient {
    public static void main(String[] args) {
        //创建负责人类
        MementoCaretaker mc = new MementoCaretaker();

        //创建原发器类
        ChessMan chessMan = new ChessMan("车",1,1);
        display(chessMan);

        //保存状态
        mc.setMemento(chessMan.save());

        chessMan.setY(4);
        display(chessMan);

        mc.setMemento(chessMan.save());
        display(chessMan);
        chessMan.setX(5);
        display(chessMan);
        System.out.println("******悔棋********");
        //撤销操作，恢复前一状态
        chessMan.restore(mc.getMemento());
        display(chessMan);

    }

    public static void display(ChessMan chessMan){
        System.out.println("棋子：" + chessMan.getLabel() + "当前位置为; X= " + chessMan.getX() + " Y= " + chessMan.getY());
    }
}
