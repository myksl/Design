package createPatterns;

public class AbsaractFactory {
	/*这个模式为创建型模式 叫做抽象工厂模式
	     意图:提供一个创建一系列相关或者相互依赖对象的接口,而无需指定他们具体的类
	     适用性:1. 一个系统要独立于他的产品的创建 组合和表示
	 		 2. 一个系统要由多个产品系列中的一个来配置时
	         3. 强调一系列产品联合使用
	         4. 提供一个产品类库 隐藏具体实现
	  例子使用一个迷宫实例 通过工厂方法实现多种迷宫
	 */
	
	/* 参与者
	  	1.AbsaractFactory 声明一个创建抽象产品对象的操作借口
	    2.ConcretaFactory Enchanted 实现创建具体产品对象的操作
	    3.AbstractProduct 为一类产品声明一个接口
	    4.ConcreateProduct 定义一个即将被具体工厂创建的产品对象
	*/
	/*
	 * 效果
	 *  1.分离了具体的类
	 *  2.使得易于交换产品系列
	 *  3.有利于产品的一致性
	 *  4.难以支持新种类的产品
	 *
	 *  
	 *  
	 *   理解:
	 *   客户通过调用工厂方法的方法将产品直接生产,与生成器模式相比,对象直接生产,生成器模式则是将对象在生成器中生产,通过GET方法取回
	 */
	
	
	
	//通过传入工厂对象来构建一个迷宫对象,通过传入不同的工厂对象,可以构建出不同系列的迷宫对象
	//AbsaractFactory 声明一个创建抽象产品对象的操作接口 --------------抽象工厂
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
	//ConcretaFactory Enchanted 实现创建具体产品对象的操作-----------实际工厂,继承抽象工厂,提供具体的产品
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
	
	//迷宫控制台,接收工厂对象,通过工厂对象来创建产品
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
		//实际运行
		public static void main(String[] args) {
			MazeGame maze ;
			EnchantedMazeFactory factory;
			
			maze.CreateMaze(factory);
		}
	}
	
	
}
