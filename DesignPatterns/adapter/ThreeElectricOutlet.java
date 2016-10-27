package designPattern.adapter;
/**
 * 目标（Target）
 * @author zhenyonghe
 *eg.用户已有一个两相的插座，但最近用户又有了一个新的三相插座。用户现在
 *已经有一台洗衣机和一台电视机，洗衣机按着三相插座的标准配有三相插头，
 *而电视机按着两相插座的标准配有两相插头。现在用户想用新的三相插座来使
 *用洗衣机和电视机（即使用适配器模式使得两个实例都可以使用三相插排）
 */
public interface ThreeElectricOutlet {
	public void connectElectricCurrent();
}
