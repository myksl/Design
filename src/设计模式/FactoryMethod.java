package 设计模式;

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
	 */
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
	public class BoomMazeGame extends MazeGame{
		public Wall MakeWall(){
			return new BoomWall();
		}
		public Room MakeRoom(int i){
			return new BoomRoom(i);
		}
	}
}
