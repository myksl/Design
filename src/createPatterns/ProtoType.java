package createPatterns;

import 设计模式.AbsaractFactory.EnchantedMazeFactory;

import 设计模式.AbsaractFactory.MazeFactory;
import 设计模式.AbsaractFactory.MazeGame;

public class ProtoType {
	/*
	 * 创建型模式 名为原型
	 * 意图: 用原型实例指定创建对象的种类 并且通过拷贝这些原型创建新的对象
	 * 
	 *  
	 * 参与者:
	 * 	prototype 声明一个克隆自身的接口 
	 *  ConcreteProtoType 实现一个克隆自身的操作
	 *  client 让一个原型克隆自身并且创建一个新的对象
	 *  
	 *  
	 *  适用性:
	 *  1.当一个系统应该独立于他的产品创建,构成和表示时
	 *  2.当要实例化的类是在运行时刻指定的
	 *  
	 *  效果:
	 *  1.对客户隐藏了具体的产品类,减少了客户知道的名字的数目
	 *  2.运行时刻增加和删除产品
	 */
	
	//ProtoType需要使用拷贝原型实例来创建新的对象,所以需要保存原型对象,通过构造方法传入原型实例
	public class MazeFactory{
		//保存原型实例
		private Maze maze;
		private Room room;
		private Door door;
		private Wall wall;
		//通过构造方法传入原型
		public MazeFactory(Maze maze , Room room ,Door door ,Wall wall) {
			this.wall = wall;
			this.door = door;
			this.maze = maze;
			this.room = room;
		}
		//通过调用对象的Clone()方法来产生新对象
		public Maze MakeMaze(){
			return new Maze();
		}
		public Wall MakeWall(){
			return wall.clone();
		}
		public Room MakeRoom(int i){
			return room.clone();
		}
		public Door MakeDoor(room r1,room r2){
			Door door = door.clone();
			door.initialize(r1,r2);
			return door;
		}
	}
	//实际客户使用
	public class MazeGame{
		public static void main(String[] args) {
			MazeGame maze ;
			// 此处为关键部分 这里为原型工厂提供了原型实例,通过传入不同的原型实例,生产不同的原型工厂
			MazeFactory simple = new MazeFactory(new Maze(), new Room(), new Door()
			, new Wall())
			
			maze.CreateMaze(simple);
		}
	}
	// 如何实现克隆操作和初始化操作,一个可以被用作原型的对象,需要一个CLONE()操作,还需要一个私有的克隆构造器
	public class Door{
		private room1;
		private room2;
		//初始化内部状态
		public void initialize(room r1, room r2){
			room1 = r1;
			room2 = r2;
		}
		//私有的拷贝构造器,传入参数原型实例,来构造新的实例
		private Door(Door d) {
			room1 = d.room1;
			room2 = d.room2;
		}
		//克隆方法
		public Door clone(){
			return new Door(this);
		}
		/*假如切换对象
			public Door clone(){
				return new BoomDoor();
			}
		*/
	}
}
