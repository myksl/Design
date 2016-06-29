package structurePatterns;

public class Decorator {
	/*
	 * 名称: 装饰
	 * 
	 * 意图:动态的给一个对象添加一个额外的职责,就增加功能来说,Decoraotr模式比子类更加灵活
	 * 
	 * 使用性:
	 * 1.在不影响其他对象的情况下,以动态,透明的方式给单个对象添加职责
	 * 2.处理可以撤销的职责
	 * 3.在不能采用生成子类的方法进行扩充时,一种情况是,有大量独立的扩展类,为支持每一种组合将产生大量的子类,
	 * 使得子类的数目会爆炸增长,另一种是类不可产生子类
	 * 
	 * 参与者:
	 * 1.Component 定义一个对象接口,可以给这些对象动态的添加接口
	 * 2.ConcreteComponent 定义一个对象,可以给这个对象添加一些职责
	 * 3.Decorator 维持一个指向Component对象的指针,并定义一个与Component接口一致的接口
	 * 4.ConcreteDecorator 向组件添加职责
	 * 
	 * 协作方式:
	 * ------------Decorator将请求转发给他的Component对象并有可能在转发前后添加一些操作
	 * 
	 * 效果:
	 *  优点:
	 *  	1.比静态继承更灵活
	 *  	2.避免在层次结构高层的类有太多的特征
	 *  缺点:
	 *  	1.有许多小的对象
	 * 
	 */
	
	//Component类 定义了抽象接口
	public class VisualComponent{
		public VisualComponent() {
		}
		public void Draw(){};
		public void Resize(){};
		
	}
	//Component的子类Decorator 通过定义不同的Decorator子类来获得不同的装饰---该类拥有VisualComponent对象的引用,方法的缺省实现为
	//调用VisualComponent的方法
	public class Decorator extends VisualComponent{
		private VisualComponent component;
		public Decorator(VisualComponent component){
			this.component = component;
		}
		public void Draw(){
			component.draw();
		};
		public void Resize(){
			component.resieze();
		};
	}
	//实现了特定的装饰,
	public class BorderDecorator extends Decorator{
		private int borderWidth;
		public BorderDecorator(VisualComponent component,int borderWidth){
			super.component =component;
			this.borderWidth = borderWidth;
		}
		public void DrawBorder(){
			
		}
		//通过在特定方法前后加入额外操作来实现功能的增加
		public void Draw(){
			super.draw();
			drawBorder(borderWidth);
			
		};
		public void Resize(){
			component.resieze();
		};
		//客户并不知道装饰类和实际类的区别,两者使用相同的接口
		public static void main(String[] args) {
			Window window = new Window();
			TextView view = new TextView();
			//通过增加装饰类来实现类的职责的添加
			window.setView(new BorderrDecorator(new ScrollrDecorator(view)));
		}
	}
}
