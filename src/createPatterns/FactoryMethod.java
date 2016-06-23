package createPatterns;

public class FactoryMethod {
	/*
	 * 创建型模式 名为工厂方法
	 * 意图 : 定义一个用于创建对象的接口 让子类决定实例化哪一个类 工厂方法使一个类的实例化延迟到子类
	 * 参与者:
	 * 	Product 定义工厂方法所创建的对象的接口
	 *  ConcreteProduct 实现Product接口
	 *  Creator 声明工厂方法 该方法返回一个Product类型的对象
	 *  ConcreteCreator 重定义工厂方法以创建一个Product对象
	 * 
	 * 适用性:
	 * 1.当一个类不知道他所必须创建的对象的类的时候
	 * 2.当一个类希望由他的子类来指定所创建的对象
	 * 
	 * 效果:
	 * 工厂方法不再将与特定应用有关的类绑定到你的代码中,代码仅处理Product接口,因此可以与用户定义的ConcreteProduct类一起使用
	 */
	
	
	/*
	 * 与抽象工厂的区别:
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 *   个人觉得这个区别在于产品，如果产品单一，最合适用工厂模式，但是如果有多个业务品种、业务分类时，
	 *   通过抽象工厂模式产生需要的对象是一种非常好的解决方式。再通俗深化理解下：
	 *                                                                         工厂模式针对的是一个产品等级结构 ，抽象工厂模式针对的是面向多个产品等级结构的。
	 * 
	 * 
	 * 
	 */
	
	//实际客户 调用工厂方法生成对象 提供工厂方法的缺省实现----------------creator对象
	public class MazeGame{
		public Maze CreateMaze(){
			Maze m = MakeMaze();
			Room r1 = MakeRoom(1);
			Room r2 = MakeRoom(2);
			Door d = MakeDoor(r1, r2);
			 return m;
		}
		public Maze MakeMaze(){
			return new Maze();
		}
		public Wall MakeWall(){
			return new Wall();
		}
		public Room MakeRoom(int i){
			return new Room(i);
		}
		public Door MakeDoor(room r1,room r2){
			return new Door(r1,r2);
		}
	}
	//继承工厂方法 通过重写特定的方法来返回不同的对象------ConcreteCreator对象
	public class BoomMazeGame extends MazeGame{
		public Wall MakeWall(){
			return new BoomWall();
		}
		public Room MakeRoom(int i){
			return new BoomRoom(i);
		}
	}
}
