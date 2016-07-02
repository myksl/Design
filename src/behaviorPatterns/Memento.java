package behaviorPatterns;

public class Memento {

	/*
	 * 名称:备忘录
	 * 
	 * 意图:在不破坏封装的前提下,捕获一个对象的内部状态,并在该对象之外保存这个对象,这样以后就可以将该对象恢复到原先保存的状态
	 * 
	 * 适用性:
	 * 1.必须保存一个对象在某一个时刻的状态,这样以后需要它的时候才能恢复到原先的状态
	 * 2.如果一个用接口来让其他对象直接得到这些状态,将会暴露对象的内部状态并破坏封装
	 * 
	 * 参与者:
	 * 1.Memento 备忘录存储原发器对象的内部状态,原发器根据需要决定备忘录存储原发器的哪些内部状态----防止原发器之外的其他对象访问备忘录
	 * 备忘录实际上有两个接口,管理者只能看到备忘录的窄接口,它只能将备忘录传递给其他对象,原发器可以看到备忘录的宽接口,允许它访问返回到
	 * 原先状态需要的的所有数据,理想状态是只允许生成备忘录的原发器访问备忘录
	 * 2.Originator 原发器创建一个备忘录,用以记录它此刻的状态,使用备忘录恢复内部状态
	 * 3.Caretaker 负责保存备忘录,不能访问备忘录
	 * 
	 * 协作方式:
	 * 管理员向原发器请求一个备忘录
	 * 
	 * 效果:
	 * 1.保持封装边界
	 * 2.简化了原发器
	 * 
	 */
	//使用命令对象来操作一个图像位置的变化
	public class MoveCommand{
		private ConstraintSolverMemento state;
		private Point delta;
		private Graphic target;
		MoveCommand(Graphic target,Point point){
			this.target = target;
			this.delta = point;
		}
		//执行位置变化行为
		public void Excute(){
			ConstraintSolver solver = ConstraintSolver.Instance();
			//管理员要求创建备忘录
			state = solver.CreateMemeto();
			target.move(delta);
			solver.Solver();
		}
		//撤销操作
		public void Unexcute(){
			ConstraintSolver solver = ConstraintSolver.Instance();
			target.move(delta);
			solver.SetMemeto(state);
			solver.Solver();
		}
	}
	//实现空的备忘录接口,实现窄接口
	public interface ConstraintSolverMemeto {

	}
	//执行位置变换的函数变化
	public class ConstraintSolver{
		private static ConstraintSolver solver;
		//单例模式,返回单例的ConstraintSolver对象
		public static ConstraintSolver Instance(){
			if(solver==null){
				solver = new ConstraintSolver();
				return solver;
			}else{
				return solver;
			}
		}
		public void Solver(){
			
		}
		//创建备忘录
		public ConstraintSolverMemeto CreateMemeto(){
			return new Memento();
		}
		public void SetMemeto(){
			
		}
		//实现私有类,只有ConstraintSolver可以访问备忘录中的具体操作,实现了宽接口
		 private class Memento implements ConstraintSolverMemeto{
		        
		        private String state;
		        /**
		         * 构造方法
		         */
		        private Memento(String state){
		            this.state = state;
		        }
		        
		        private String getState() {
		            return state;
		        }
		        private void setState(String state) {
		            this.state = state;
		        }
		    }
		}
	
}
