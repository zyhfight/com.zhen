package memento;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 象棋棋子备忘录管理类：负责人
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class MementoCaretaker {
    //用List集合存储多个备忘录，可实现多次撤销操作
    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }

    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }
}
