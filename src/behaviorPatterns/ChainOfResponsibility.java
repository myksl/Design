package behaviorPatterns;

public class ChainOfResponsibility {
	
	/*
	 * 名称: 职责链
	 * 
	 * 意图:使多个对象都有机会处理请求,从未避免请求的发送者和接受者之间的耦合关系,将这些对象形成一条链,并沿着链处理请求
	 * ------------------------------------请求有一个隐式的接受者
	 * 适用性:
	 * 1.有多个对象可以处理一个请求,哪个对象处理请求运行时刻自动确定
	 * 2.你想在不明确指定接受者的情况下,想多个对象中的一个提交一个请求
	 * 3.可以处理一个请求的集合被动态指定
	 * 
	 * 参与者:
	 * 1.Handler 定义一个处理请求的接口,实现后继链
	 * 2.ConcreteHandler 处理他所负责的请求,可以访问它的后继者,如果可以处理该请求就处理,否则传递给后继者
	 * 
	 * 协作方式:
	 * 当客户提交一个请求时,请求沿链传递直到有一个ConcreteHandler对象负责处理它
	 * 
	 * 效果:
	 * 1.降低耦合度
	 * 2.增强了给对象指派职责的灵活性
	 * 3.不保证被接受
	 * 
	 */
	
	//Handler是一个帮助请求的接口
	public class HelpHandler{
		public Topic No_Topic = -1;
		public Topic topic;
		public HelpHandler helpHandler;
		HelpHandler(){
			helpHandler = null;
			topic = No_Topic;
		}
		//判断是否有帮助主题
		public boolean hasHelp(){
			return topic!= No_Topic;
		}
		
		//后继链的设定
		public void SetHandler(HelpHandler helpHandler,Topic topic){
			this.helpHandler = helpHandler;
			this.topic = topic;
		}
		//帮助方法的核心方法,如果有帮助主题,执行帮助,否则向后继者传递请求
		public void HandleHelp(){
			if(helpHandler!=null){
				helpHandler.HandleHelp();
			}
		}
		
	}
	
	public class Widget extends HelpHandler{
		private Widget widget;
		Widget(Widget widget,Topic topic){
			this.widget = widget;
			super.topic = super.No_Topic;
		}
	}
	//第一个帮助者
	public class Button extends Widget{
		Button(Widget widget,Topic topic){
			this.widget = widget;
			super.topic = super.No_Topic;
		}
		public void HandleHelp(){
			if(hasHelp()){
				//----
			}else{
				helpHandler.HandleHelp();
			}
		}
	}
	//第二个帮助者
	public class Dialog extends Widget{
		Dialog(Widget widget,Topic topic){
			this.widget = widget;
			super.topic = super.No_Topic;
		}
		public void HandleHelp(){
			if(hasHelp()){
				//----
			}else{
				helpHandler.HandleHelp();
			}
		}
	}
	//第三个帮助者
	public class Applacation extends HelpHandler{
		Applacation(Topic topic){
			this.topic = topic;
		}
		public void HandleHelp(){
				//----
		}
	}
	
	public static void main(String[] args) {
		//创建一个完整的职责链
		Applacation applacation = new Applacation(1);
		Dialog diglog = new Dialog(applacation, 2);
		Button button = new Button(diglog, 3);
		//将请求传入职责链,开始传递请求
		button.HandleHelp();
	}
	
	
}
