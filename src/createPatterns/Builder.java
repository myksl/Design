package createPatterns;

import 设计模式.AbsaractFactory.EnchantedMazeFactory;
import 设计模式.AbsaractFactory.MazeFactory;
import 设计模式.AbsaractFactory.MazeGame;

public class Builder {
	/*
	 * 对象创建模式  名为生成器
	 * 意图 : 将一个复杂对象的构建与他的表示分离 使得同样的构建过程可以创建不同的表示
	 * 
	 * 参与者:
	 *  Builder 为创建一个Product对象的各个部件指定抽象接口--------接口
	 *  ConcereteBuilder 定义Builder的接口以构造和装配该产品的各个部件---------实际创建对象
	 *  Director 构造一个使用Builder接口的对象 该对象和Builder聚合 拥有Builder对象---------通过聚合方式调用Builder对象生产产品
	 *  Product 表示被构造的复杂对象 ConceteBuilder创建该对象的内部表示并定义它的装配过程
	 *  
	 *  
	 *  
	 *  效果:
	 *  1.它可以使你改变一个产品的内部表示
	 *  2.它将构造代码和表示代码分离开来
	 *  3.可以实现对构造过程的精细控制
	 */
	//Builder 抽象对象,提供生产产品的方法的接口
	public class MazeBuilder{
		public void buildMaze(){
			
		}
		public void buildRoom(int i){
			
		}
		public void buildDoor(int r1, int r2){
			
		}
		//通过这个对象返回迷宫实例
		public Maze getMaze(){
			return maze ;
		}
	}
	
	//继承Builder,具体的实现类
	public class StandarrdMazeBuilder extends MazeBuilder{
		private Maze maze ;
		public StandarrdMazeBuilder() {
			maze = null;
		}
		@Override
		public void buildMaze() {
			maze = new Maze();
		}
		@Override
		public void buildRoom(int i) {
			if(!maze.roomNo(i)){
				Room room  =  new Room();
				maze.addRoom(room);
			}
		}
		@Override
		public void buildDoor(int r1, int r2) {
			
		}
		//通过这个对象返回迷宫实例
		public Maze getMaze(){
			return maze ;
		}
		
	}
	
	
	
	//迷宫控制台   Director 拥有Builder对象  
		public class MazeGame{
			//使用生成器模式 我们可以用Builder对象来代替工厂成为参数
			public Maze CreateMaze(MazeBuilder builder){
				builder.buildMaze();
				builder.buildRoom(1);
				builder.buildRoom(2);
				builder.buildDoor(1, 2);
				return builder.getMaze();
			}
			//可以通过定义不同的方法来创建不同的迷宫,实现精细控制
			public Maze CreateBoomMaze(MazeBuilder builder){
				builder.buildMaze();
				builder.buildRoom(1);
				builder.buildDoor(1, 2);
				return builder.getMaze();
			}
			public static void main(String[] args) {
				MazeGame maze ;
				StandarrdMazeBuilder builder;
				
				maze.CreateMaze(builder);
				maze = builder.getMaze();
			}
		}
		
}
