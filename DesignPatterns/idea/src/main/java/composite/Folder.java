package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class Folder extends AbstractFile {
    private List<AbstractFile> fileList = new ArrayList<>();
    private String name;

    public Folder(String name){
        this.name = name;
    }

    @Override
    void add(AbstractFile file){
        fileList.add(file);
    }

    @Override
    AbstractFile getChild(int i){
        return fileList.get(i);
    }

    @Override
    void killVirus() {
        System.out.println("***对文件夹： " + name + " 进行杀毒");
        for(AbstractFile file : fileList){
            file.killVirus();;
        }
    }
}
