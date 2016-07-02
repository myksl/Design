package behaviorPatterns;

public class State {
	
	/*
	 * 名称:状态
	 * 
	 * 意图:允许一个对象在其内部状态改变的时候改变他的行为,对象看起来似乎修改了它的类
	 * 
	 * 适用性:
	 * 1.一个对象的行为取决于他的状态,而且它必须在运行时刻改变他的状态
	 * 2.一个操作中包含大量的分支语句,而且直接分支依赖对象的状态
	 *
	 *参与者:
	 *1.Context 定义客户感兴趣的接口,维护一个ConcreteState的子类,这个实例定义当前状态
	 *2.State 定义一个接口以封装与Context的一个特定状态相关的行为
	 *3.ConcreteState 每一个子类实现一个与Context状态相关的行为
	 * 
	 * 效果:
	 * 1.将与状态相关的行为局部化
	 * 2.使得状态转换显式化
	 * 3.State对象可以被共享
	 * 
	 */
	//Context类,保存一个TcpState的实例
	public class TcpConnection{
		private TcpState state;
		//初始化为关闭状态
		TcpConnection(){
			state = TcpClosed.Instance();
		}
		public void ActiveOpen(){
			state.ActiveOpen(this);
		}
		public void PassiveOpen(){
			state.PassiveOpen(this);
		}
		public void Close(){
			state.Close(this);
		}
		public void ChangeState(TcpState state){
			this.state = state;
		}
	}
	//定义State接口,定义缺省行为
	public class TcpState{
		public void ActiveOpen(TcpConnection tcpConnection){
			
		}
		public void PassiveOpen(TcpConnection tcpConnection){
			
		}
		public void Close(TcpConnection tcpConnection){
			
		}
		public void ChangeState(TcpConnection tcpConnection,TcpState state){
			tcpConnection.ChangeState(state);
		}
	}
	//定义State子类,实现特定的状态
	public class TcpClosed extends TcpState{
		private static TcpClosed tcpClosed;
		public static TcpClosed Instance(){
			if(tcpClosed==null){
				tcpClosed = new TcpClosed();
				return tcpClosed;
			}else{
				return tcpClosed;
			}
		}
	}
	
}
