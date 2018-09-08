package flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 享元工厂类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class IgoChessmanFactory {
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static ConcurrentHashMap<String,IgoChessman> concurrentHashMap;
    private IgoChessmanFactory(){
        concurrentHashMap = new ConcurrentHashMap<>();
        IgoChessman balck = new BlackIgoChessman();
        IgoChessman white = new WhiteIgoChessman();
        concurrentHashMap.put("b",balck);
        concurrentHashMap.put("w",white);
    }

    public static IgoChessmanFactory getInstance(){
        return instance;
    }

    public IgoChessman getIgoChessman(String color){
        return concurrentHashMap.get(color);
    }
}
