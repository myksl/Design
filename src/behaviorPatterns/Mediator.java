package behaviorPatterns;

public class Mediator {
	
	/*
	 * 名称:中介者
	 * 
	 * 意图:用一个中介对象来封装一系列的对象交互,中介者使得各对象不需要显式的相互引用,从而使其耦合松散,从而可以独立的改变他们之间的交互
	 * 
	 * 适用性:
	 * 1.一组对象以定义良好但是复杂的方式进行通信,产生的依赖关系混乱而且难以理解
	 * 2.一个对象引用其他对象并且直接与这些对象通信,导致难以复用该对象
	 * 3.想定制一个分布在多个类中的行为,又不想定义太多类
	 * 
	 * 参与者:
	 * 1.Mediator 中介者定义一个接口用于与各同事对象通信
	 * 2.ConcreteMediator 具体中介者通过协调各同事对象实现协作行为,了解并维护它的每个同事
	 * 3.Colleague 每一个同事类都知道它的中介者对象,每一个同时类需要与其他同事类通信的时候,与他的中介者通信
	 * 
	 * 协作方式:
	 * 同事向一个中介者对象发送和接收请求,中介者在各同事间适当的转发请求以实现协作行为
	 * 
	 * 效果:
	 * 1.减少了子类生成:Mediator将原本分布在多个对象间的行为集中在一起,改变这些行为只需要生成Mediator的子类就好,这样各个Colleague
	 * 可以被重用
	 * 2.将各个Colleague对象解耦:可以独立的改变和复用Colleague和Mediator类
	 * 3.简化了对象协议
	 * 4.便于控制集中化
	 * 5.将对象如何协作抽象化
	 * 
	 */
	//定义了中介者的接口
	public class DialogDirector{
		public void showDialog(){
			
		}
		//中介者核心方法,当组件改变时调用
		public void WidgetChaned(Widget widget){
			
		}
		public void CreateWidgets(){
			
		}
	}
	//Colleague类,保存一个中介者的对象
	public class Widget{
		public DialogDirector director;
		Widget(DialogDirector director){
			this.director = director;
		}
		//组件改变时刻调用中介者方法
		public void Changed(){
			director.WidgetChaned(this);
		}
		public void HandMouse(){
			
		}
	}
	
	public class ListBox extends Widget{
		ListBox(DialogDirector director){
			this.director = director;
		}
		public String GetSelection(){
			
		}
		public void SetList(List<Item> list){
			
		}
		public void HandMouse(){
			
		}
	}
	public class EntryField extends Widget{
		EntryField(DialogDirector director){
			this.director = director;
		}
		public String GetText(){
			
		}
		public void SetText(String text){
			
		}
		public void HandMouse(){
			
		}
	}
	public class Button extends Widget{
		Button(DialogDirector director){
			this.director = director;
		}
		public void HandMouse(){
			Changed(); 
		}
	}
	//中介者具体子类
	public class FontDialogDirector extends DialogDirector{
		private Button button;
		private Button cancel;
		private ListBox listBox;
		private EntryField name;
		public void CreateWidgets(){
			button = new Button(this);
			cancel = new Button(this);
			listBox = new ListBox(this);
			name = new EntryField(this);
		}
		//根据改变的组件调用方法
		public void WidgetChanged(Widget widget){
			if(widget==button){
				name.SetText(listBox.GetSelection());
			}else if(){
				
			}

		}
		
	}
	
}
