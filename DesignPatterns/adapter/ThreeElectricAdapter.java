package designPattern.adapter;
/**
 * 适配器（Adapter）
 * @author zhenyonghe
 *适配器模式（包装器）：将一个类的接口转换成客户希望的另外一个接口。
 *Adapter模式使得原本由于不兼容二不能一起工作的那些类可以一起工作。
 *
 *这个适配器实现了目标接口并包含有被适配者的引用。
 */
public class ThreeElectricAdapter implements ThreeElectricOutlet{
	private TwoElectricOutlet outlet;
	public ThreeElectricAdapter(TwoElectricOutlet outlet) {
		this.outlet=outlet;
	}
	@Override
	public void connectElectricCurrent() {
		outlet.connectElectricCurrent();
	}

}
