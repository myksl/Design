package behaviorPatterns;

import java.util.ArrayList;
import java.util.List;

public class Observer {

	/*
	 * 名称:观察者
	 * 
	 * 意图:定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变的时候,所有依赖他的对象一同改变
	 * 
	 * 适用性:
	 * 1.当一个抽象模型有两个方面,其中一个方面依赖于另一个方面,将这两者独立封装使他们可以独立的复用
	 * 2.当对一个对象的改变同时需要改变其他的对象,但不知道要改变多少对象
	 * 3.当一个对象必须通知其他对象,而他又不能假定对象是谁
	 * 
	 * 参与者:
	 * 1.Subject 目标知道他的观察者,可能有任意多个观察者观察同一个目标
	 * 2.Observer 为那些在目标改变时需要获得通知的对象定义一个接口
	 * 3.ConcreteSubject 将有关状态存入个ConcreteObserver对象,当他的状态改变时,向各个观察者发出通知
	 * 4.ConcreteObserver 维护一个指向ConcreteSubject对象的引用,存储有关状态,应该与目标一致,实现Observer的更新接口
	 * 
	 * 协作方式:
	 * 当ConcreteSubject发生任何可能导致其观察者与本身状态不一致的改变的时候,将通知各个观察者
	 * 当得到一个目标改变的通知后,ConcreteObserver更新自身以保持一致
	 * 
	 * 效果:
	 * 1.目标和观察者抽象耦合
	 * 2.支持广播通信
	 * 
	 * 实现:
	 * 1.创建目标到观察者之间的映射:显式的保存观察者的引用
	 * 2.观察多个目标:必须扩展Update接口使得观察者知道哪个目标发生了改变
	 * 3.谁触发更新:
	 * 				1.目标对象在自身改变之后自动回调Notify()方法,多个更新操作会导致多个Notify方法
	 * 				2.客户负责调用,可以一次性更新,但是客户可能忘记 
	 */
	//这是一个Observer接口,实现一个更新方法拥有对目标的引用
	public class Observer{
		public void Update(Subject subject){
			
		}
	}
	//这是一个目标接口,管理观察者列表并通知他们
	public class Subject{
		private List<Observer> list = new ArrayList<Observer>();
		public void Attach(Observer observer){
			list.add(observer);
		}
		public void Detach(Observer observer){
			list.remove(observer);
		}
		public void Notify(){
			for(Observer o:list){
				o.Update();
			}
		}
	}
}
