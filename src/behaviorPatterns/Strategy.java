package behaviorPatterns;

public class Strategy {

	/*
	 * 名称:策略
	 * 
	 * 意图:定义一系列的算法,把他们一个个封装起来,并且使他们可以相互替换,本模式使得算法可以独立于他们的客户变化
	 * 
	 * 适用性:
	 * 1.许多相关的类仅仅是行为有异
	 * 2.需要使用一个算法的不同变体
	 * 3.算法使用客户不应该知道的数据
	 * 4.一个类定义了多种行为
	 * 
	 * 参与者:
	 * 1.Strategy 定义所有支持的算法的公开接口,Context使用这个接口来调用某个具体的算法
	 * 2.ConcreteStrategy 以Strategy接口实现某具体算法
	 * 3.Context 用一个ConcreteStrategy来配置,维护一个对Strategy的引用,可以定义一个接口让Strategy访问他的数据
	 * 
	 */
	public class Context{
		private Strategy strategy;
		Context(Strategy strategy){
			this.strategy = strategy;
		}
		public void Use(){
			strategy.use(this);
		}
	}
	public class Strategy{
		public void use(Context c){
			
		}
	}
	public class AStrategy extends Strategy{
		
	}
	public class bStrategy extends Strategy{
		
	}
	
	public static void main(String[] args) {
		Context a = new Context(new AStrategy());
		Context b = new Context(new BStrategy());
	}
	
}
