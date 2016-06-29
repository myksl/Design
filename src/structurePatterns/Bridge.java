package structurePatterns;

public class Bridge {
	/*
	 * 结构型模式 名为桥接
	 * 意图: 将抽象部分与他的实现部分分离 使他们都可以独立的变化
	 * -----------------------------------------------------------------------------------
	 * 桥接模式较为难以理解,举一个书上的例子,拥有一个Window抽象类,需要在多个平台使用实现特定的Window子类,
	 * 然而Window也有自己的特定子类,比如IconWindow 如果使用直接继承的方法实现,那么每一个IconWindow都需要一个
	 * 特定与平台的子类 增加了代码的规模,过于耦合
	 * -----------------------------------------------------------------------------------
	 * 参与者:
	 *  Abstraction 定义一个抽象类的接口 维护一个指向Implementor类型对象的指针
	 *  RefinedAbstraction 扩充由Abstraction定义的接口
	 *  Implementor 定义实现类的接口 不一定要与Abstraction完全一致 甚至可以完全不一致 
	 *  	Implementor负责基本操作 Abstraction负责高级操作
	 *  ConcreteImplementor 实现Implementor接口并定义具体实现
	 * 
	 * 适用性:
	 * -----你不希望抽象和他的实现部分拥有固定的绑定,可能是因为:
	 * 1.在程序运行时刻实现可以被选择和切换
	 * 2.对抽象的修改可以对客户不产生影响
	 * 
	 * 效果:
	 * 1.分离接口和其实现部分
	 * 2.提高可扩充性
	 * 3.实现细节对客户透明
	 * 
	 * 
	 */
	//Abstraction---抽象类的接口,通过聚合拥有一个指向Implementor的对象,具体操作通过其进行
	public class Window{
		private WindowImp imp ;
		private View view ; // 持有window的内容
		protected WindowImp getImp() {
			//通过单例模式来返回Imp对象
			if(imp==null){
				imp = new WindowImp();
			}else{
				return imp;
			}
		}
		protected View getView() {
			
		}
	}
	//Window的子类定义了各种应用程序可能用到的各种不同类型的窗口
	public class IconWindow extends Window{
		
	}
	//window类维护一个对windowimp的引用 windowimp抽象类定义了一个对底层窗口系统的接口
	public class WindowImp{
		
	}
	//window定义了系统可能用到的不同种类的窗口
	//window的操作由windowimp的接口定义
	//具体的WindowImp子类可以支持不同的系统 这些子类用WindowImp的基本操作实现WindowImp
	
	
	// 对模式的理解: 模式将接口的定义和实现区分开来 Window定义了一群可能需要的类
	//WindowImp实现了不同系统的不同操作 通过Window持有的WindowImp对象进行调用 不是通过继承来实现紧耦合
}
