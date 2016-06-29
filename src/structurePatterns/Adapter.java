package 设计模式;

public class Adapter {
	/*
	 * 结构型模式 名为适配器
	 * 意图 : 将一个类的接口转换为客户希望的另一个接口 Adapter模式使得原本由于接口不兼容不能
	 * 一起工作的那些类可以一起工作
	 * 参与者: 
	 *  Target 定义Client使用的与特定领域相关的接口
	 *  Client 与符合Target的对象协同
	 *  Adaptee 定义一个已经存在的接口 这个接口需要适配
	 *  Adapter 对Adaptee Target 接口适配
	 *  
	 *  分为对象适配和类适配 类适配使用继承的方式实现 对象适配使用对象组合的方式实现
	 *  
	 *  适用性:
	 *  1.你想使用一个已经存在的类,但它的接口不符合你的需求
	 *  2.想创建一个可以复用的类,该类可以与其他不相关的类或者不可预见的类协同工作
	 *  3.想使用一些已经存在的子类,但是不可能对每一个子类都做子类化适配,可以通过对象适配器的方式来通过聚合他们的父类对象的方式来使用子类
	 *  
	 *  
	 *  效果:
	 *    类适配器
	 *    	1.用一个具体的Adapter类对Adaptee和Target进行匹配,结果是当我们想匹配一个类以及他的所有子类的时候,Adapter将不能胜任
	 *    	2.可以重新定义Adaptee的行为,通过继承方法重写的方式
	 *    对象适配器
	 *    	1.允许一个Adapter和多个Adaptee ---即一个父类Adaptee和他的众多子类 =多态
	 *    	2.重定义Adaptee的行为较为困难
	 *    
	 */
	//Target类 定义了用户使用的特定领域的相关接口
	public class Shape {
		public void boundingBox(Point p1, Point p2){
		}
		public Manipulator CreateManipulator(){
			
		}
		// Adaptee没有等同的操作
	}
	//Adaptee类,需要适配的类
	public class TextView{
		public void getOrigin(Coord x, Coord y){
			
		}
		public void getExtent(Coord x, Coord y){
			
		}
		public Boolean IsEmpty(){
			return true;
		}
		
	}
	// 第一种方式 类适配器 Java不支持多重继承 所以描述大概实现方式
	public class TextShape extends TextView ,Shape{
		//Boundingbox操作对TextView 的接口进行转换使之匹配Shape接口
		public void boundingBox(Point p1, Point p2){
			//Adaptee类可能和Target类拥有不同的方法参数,通过在此改变参数并将适当的参数传递给Adaptee类来实现接口的适配
		}
		//添加这个方法使得适配器支持新的操作
		public Manipulator CreateManipulator(){
			//无需额外的类,直接放回对象即可
			return new Manipulator();
		}
		//IsEmpty操作给出了在适配器实现过程中常用的一种方法 直接转发请求
		public Boolean IsEmpty(){
			return super.IsEmpty();
		}
	}
	// 适配器的第二种实现方式 TextShape中包含一个指向TextView的指针
	public class TextShape2 extends Shape{
		//通过聚合的方式拥有一个Adaptee类的对象,通过操作这个对象来实现适配器
		private TextView text;
		// 必须在构造器中初始化这个对象 
		public TextShape2(TextView t) {
			text = t;
		}
		// 同时将操作转换到TextView中
		public void boundingBox(Point p1, Point p2){
		}
		public Manipulator CreateManipulator(){
			
		}
		public Boolean IsEmpty(){
			return text.IsEmpty();
		}
		//该方法没有区别
		public Manipulator CreateManipulator(){
			return new Manipulator();
		}
	}
	
}
