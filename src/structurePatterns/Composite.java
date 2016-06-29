package structurePatterns;

import java.util.Iterator;

public class Composite {
	/*
	 * 结构型模式 名为组合
	 * 意图 :将对象组合成树形 形成 部分-整体 的层次结构 Composite使得用户对单个对象和组合对象的使用具有一致性
	 * 
	 * 提供了一定的一致性  使得基本对象和组合对象拥有一致性 
	 * 可以一同使用
	 * 
	 * 参与者:
	 * Component:为组合中的对象声明接口,在适当情况下实现所有类共有接口的缺省实现,声明一个接口用于访问和管理Component的子组件
	 * Leaf:在组合中表示叶节点,叶节点没有子节点
	 * Composite:定义有子部件的那些部件的行为,存储子部件
	 * 
	 * 适用性:
	 * 1.你想表示对象的整体部分层次
	 * 2.希望用户忽略组合对象和单个对象的区别,并希望他们一致的使用他们
	 * 
	 * 效果:
	 * 1.定义了包含基本对象和组合对象的基本类层次结构,基本对象可以被组合对象组合成更复杂的组合对象,组合对象又可以被组合,任何用到
	 * 单个对象的地方都可以使用组合对象
	 * 2.简化客户代码
	 * 3.更容易增加新的组件
	 * 
	 */
	//Component类----定义了组合中的对象的接口
	public class Equipment{
		//为叶子对象提供接口
		private String name;
		public void power(){
			
		}
		//增加一个组件
		public void add(Equipment e){
			
		}
		//删除一个组件
		public void remove(Equipment e){
			
		}	
		//通过迭代方式操作子组件
		public Iterator<Equipment> CreateIterator(){
			
		}
	}
	//为访问和管理子设备提供了一些操作 ,是包含其他设备的基类,为访问和管理子部件提供了方法
	public class  CompositeEquipment extends Equipment{
		private String name;
		public void power(){
			
		}
		public void add(Equipment e){
			
		}
		public void remove(Equipment e){
			
		}	
		public Iterator<Equipment> CreateIterator(){
			
		}
	}
	//定义特定的组合类,通过继承CompositeEquipment的方式实现
	public class Chassis extends CompositeEquipment{
	
	public class Client{
		public static void main(String[] args) {
			Chassis ch = new Chassis("Pc chassis");
			Cabinet ca = new Cabinet("Pc Cabinet");
			
			ch.add(ca);
			
			Bus b = new Bus("Bus");
			
			ca.add(b);
		}
	}
	
	
}
