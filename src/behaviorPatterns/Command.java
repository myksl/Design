package behaviorPatterns;

import java.util.ArrayList;
import java.util.List;

public class Command {

	/*
	 * 名称:命令
	 * 
	 * 意图:将一个请求封装成为一个对象,从而使你可以用不同的请求对客户进行参数化,对请求排队或记录请求日志,以及支持可撤销的操作
	 * 
	 * 适用性:
	 * 1.抽象出待执行的动作以参数化某对象.
	 * 2.在不同的时刻指定,排列和执行请求
	 * 3.支持取消操作
	 * 4.支持修改日志
	 * 
	 * 参与者
	 * 1.Command 声明执行操作的接口
	 * 2.ConcreteCommand 将一个接受者对象绑定与一个动作,调用接受者对象相应的操作,以实现Excute
	 * 3.Client 创建一个具体命令对象并设定它的接受者
	 * 4.Invoker 要求该命令执行这个请求
	 * 5.Receiver 知道如何执行一个请求相关的对象
	 * 
	 * 协作方式:
	 * Client创建一个ConcreteCommand对象并指定它的Receiver对象
	 * 某Invoker对象存储该ConcreteCommand对象
	 * 该Invoker通过调用Command对象的Excute方法来提交一个请求,若该命令是可以撤销的,ConcreteCommand就在执行Excute方法之前存储
	 * 当前的状态用于取消该命令
	 * ConcreteCommand对象对调用它的Receiver一些操作来执行请求
	 * 
	 * 效果:
	 * 1.Command将调用操作的对象和知道如何处理该操作的对象解耦
	 * 2.Command是头等的对象,他们可以像其他对象一样被操纵和扩展
	 * 3.可以将多个命令装配成为一个复合命令
	 * 4.增加新的Command很容易
	 * 
	 */
	//抽象的Command类
	public class Command{
		public void Excute(){
			
		}
	}
	//OpenCommand需要一个Applacation作为接受者,由构造方法传入
	public class OpenCommand extends Command{
		private Applacation applacation;
		private String name;
		OpenCommand(Applacation applacation){
			this.applacation = applacation;
			this.name = name;
		}
		public String AskUser(){
			
		}
		//执行方法
		public void Excute(){
			String name = AskUser();
			if(name!=null){
				Document document = new Document();
				applacation.add(document);
				document.open();
			}
		}
	}
	//需要一个Document作为接收者
	public class PasteCommand extends Command{
		private Document document;
		PasteCommand(Document document){
			this.document = document;
		}
		public void Excute(){
			document.Paste();
		}
	}
	//MacroCommand管理一个子命令序列,提供了增加命令和删除命令的操作,这里不需要显示接收者,因为子命令已经定义了自己的接收者
	//如果实现撤销操作,必须以Excute相反的操作实行
	public MacroCommand extends Command{
		List<Command> list = new ArrayList<Command>();
		//管理子命令序列
		public void add(){
			list.add();
		}
		public void remove(){
			list.remove();
		}
		//顺序执行子命令序列里面的序列
		public void Excute(){
			for(Command c:list){
				c.Excute();
			}
		}
	}
}
