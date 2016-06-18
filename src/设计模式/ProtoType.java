package 设计模式;

import 设计模式.AbsaractFactory.EnchantedMazeFactory;

import 设计模式.AbsaractFactory.MazeFactory;
import 设计模式.AbsaractFactory.MazeGame;

public class ProtoType {
	/*
	 * 创建型模式 名为原型
	 * 意图: 用原型实例指定创建对象的种类 并且通过拷贝这些原型创建新的对象 
	 * 参与者:
	 * 	prototype 声明一个克隆自身的接口 
	 *  ConcreteProtoType 实现一个克隆自身的操作
	 *  client 让一个原型克隆自身并且创建一个新的对象
	 */
	public class MazeFactory{
		private Maze maze;
		private Room room;
		private Door door;
		private Wall wall;
		public MazeFactory(Maze maze , Room room ,Door door ,Wall wall) {
			this.wall = wall;
			this.door = door;
			this.maze = maze;
			this.room = room;
		}
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
	public class MazeGame{
		public Maze CreateMaze(MazeFactory factory){

			return m;
		}
		public static void main(String[] args) {
			MazeGame maze ;
			// 此处为关键部分 这里提供的构造器参数成为了实例化的对象
			MazeFactory simple = new MazeFactory(new Maze(), new Room(), new Door()
			, new Wall())
			
			maze.CreateMaze(simple);
		}
	}
	// 如何实现克隆操作和初始化操作
	public class Door{
		private room1;
		private room2;
		public void initialize(room r1, room r2){
			room1 = r1;
			room2 = r2;
		}
		public Door(Door d) {
			room1 = d.room1;
			room2 = d.room2;
		}
		public Door clone(){
			return new Door();
		}
		/*假如切换对象
			public Door clone(){
				return new BoomDoor();
			}
		*/
	}
}
