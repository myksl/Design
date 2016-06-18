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
	 */
	public class Shape {
		public void boundingBox(Point p1, Point p2){
		}
		public Manipulator CreateManipulator(){
			
		}
		// Adaptee没有等同的操作
	}
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
		}
		//添加这个方法使得适配器支持新的操作
		public Manipulator CreateManipulator(){
			return new Manipulator();
		}
		//IsEmpty操作给出了在适配器实现过程中常用的一种方法 直接转发请求
		public Boolean IsEmpty(){
			return super.IsEmpty();
		}
	}
	// 适配器的第二种实现方式 TextShape中包含一个指向TextView的指针
	public class TextShape2 extends Shape{
		private TextView text;
		// 必须在构造器中初始化指针 
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
