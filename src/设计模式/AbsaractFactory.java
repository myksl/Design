package 设计模式;

public class AbsaractFactory {
	//这个模式为创建型模式 叫做抽象工厂模式
	// 意图:提供一个创建一系列相关或者相互依赖对象的借口,而无需指定他们具体的类
	// 适用性:1. 一个系统要独立于他的产品的创建 组合和表示
	//		 2. 一个系统要由多个产品系列中的一个来配置时
	//       3. 强调一系列产品联合使用
	//       4. 提供一个产品类库 隐藏具体实现
	// 例子使用一个迷宫实例 通过工厂方法实现多种迷宫
	
	/* 参与者
	 * 	AbsaractFactory 声明一个创建抽象产品对象的操作借口
	 *  ConcretaFactory Enchanted 实现创建具体产品对象的操作
	 *  AbstractProduct 为一类产品声明一个接口
	 *  ConcreateProduct 定义一个即将被具体工厂创建的产品对象
	*/
	
	//AbsaractFactory 声明一个创建抽象产品对象的操作借口
	public class MazeFactory{
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
	
	//迷宫控制台
	public class MazeGame{
		public Maze CreateMaze(MazeFactory factory){
			Maze m = factory.MakeMaze();
			Room r1 = factory.MakeRoom(1);
			Room r2 = factory.MakeRoom(2);
			Door d = factory.MakeDoor(r1, r2);
			
			m.addRoom(r1);
			m.addRoom(r2);
			return m;
		}
		public static void main(String[] args) {
			MazeGame maze ;
			EnchantedMazeFactory factory;
			
			maze.CreateMaze(factory);
		}
	}
	//ConcretaFactory Enchanted 实现创建具体产品对象的操作
	public class EnchantedMazeFactory extends MazeFactory{
		@Override
		public Room MakeRoom(int i) {
			return new EnchantedRoom();
		}
		@Override
		public Door MakeDoor(room r1, room r2) {
			return new EnchantedDoor();
		};
		@Override
		public Wall MakeWall() {
			return EnchantedWall();
		}
	}
	
	
}
