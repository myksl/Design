package 设计模式;

public class Bridge {
	/*
	 * 结构型模式 名为桥接
	 * 意图: 将抽象部分与他的实现部分分离 使他们都可以独立的变化
	 * 参与者:
	 *  Abstraction 定义一个抽象类的接口 维护一个指向Implementor类型对象的指针
	 *  RefinedAbstraction 扩充由Abstraction定义的接口
	 *  Implementor 定义实现类的接口 不一定要与Abstraction完全一致 甚至可以完全不一致 
	 *  	Implementor负责基本操作 Abstraction负责高级操作
	 *  ConcreteImplementor 实现Implementor接口并定义具体实现
	 * 
	 */
	public class Window{
		private WindowImp imp ;
		private View view ; // 持有window的内容
		protected WindowImp getImp() {
			
		}
		protected View getView() {
			
		}
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
