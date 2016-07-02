package behaviorPatterns;

public class Vistor {

	/*
	 * 名称:访问者
	 * 
	 * 意图:表示一个作用于某对象结构中的各个元素的操作,它使你可以在不改变元素的类的情况下定义作用于这些元素的新的操作
	 * 
	 * 适用性:
	 * 1.一个对象结构包含很多类对象,他们有不同的接口,而你想对这些对象实施一些依赖于具体类的行为
	 * 2.需要对一个对象结构中的对象进行很多不同的并且不相关的操作
	 * 3.定义对象结构的类很少改变,但需要在此结构上面定义新的操作
	 * 
	 * 参与者:
	 * 1.Vistor 为该对象结构中的ConcreteElement的每一个类声明一个Visit操作,该操作的名字和特征表示了发送Visit请求给该访问者的
	 * 那个类,这样访问者就可以确定正被访问元素的具体的类,这样访问者就可以通过该元素的特定接口直接访问
	 * 2.ConcreteVisitor 实现每个由Visitor声明的操作,每个操作实现本算法的一部分,而该算法片段是对应于结构中对象的类,ConcreteVisitor
	 * 算法提供了上下文并存储他的局部状态
	 * 3.Element 定义一个Accept操作,以访问者为参数
	 * 4.ConcreteElement 实现一个Accept操作,以访问者为参数
	 * 5.ObjectStructure 能枚举他的元素,可以提供一个高层的接口以允许该访问者访问他的元素,可以是一个复合
	 * 
	 * 协作方式:
	 * 1.一个使用Visitor模式的客户必须创建一个ConcreteVisitor对象,然后遍历该对象结构,并用访问者访问每一个元素
	 * 2.当一个元素被访问时,调用对应于他的类的Visitor操作
	 * 
	 * 效果:
	 * 1.访问者模式使得易于增加新的操作
	 * 2.访问者模式集中相关操作分离无关操作
	 * 3.增加ConcreteElement很困难
	 */
	//使用了Composite模式,提供了Accept方法来与访问器交互
	public class Equipment {
		private String name;
		public void Power(){
			
		}
		public void NetPrice(){
			
		}
		public void Accept(EquipmentVisitor equipmentVisitor){
			
		}
	}
	//Visitor的抽象类
	public class EquipmentVisitor{
		public void visitChassis(Chassis chassis){
			
		}
		public void visitBus(Bus bus){
			
		}
	}
	public class Bus extends Equipment{
		//将自身作为参数传入访问器中
		public void Accept(EquipmentVisitor equipmentVisitor){
			equipmentVisitor.visitBus(this);
		}
	}
	public class Chassis extends Equipment{
		public void Accept(EquipmentVisitor equipmentVisitor){
			for(Chassis c:list){
				c.Accept(equipmentVisitor);
			}
			equipmentVisitor.visitChassis(this);
		}
	}
	public class PriceEquipmentVisitor extends EquipmentVisitor{
		private int total;
		public void visitChassis(Chassis chassis){
			total+=chassis.NetPrice();
		}
		public void visitBus(Bus bus){
			total+=bus.NetPrice();
		}
	}
	//客户使用方法
	public static void main(String[] args) {
		Equipment e = new Equipment();
		PriceEquipmentVisitor p = new PriceEquipmentVisitor();
		e.Accept(p);
	}
}
