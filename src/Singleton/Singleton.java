package Singleton;

public class Singleton {
	/*
	 *  创建型模式 名为单例模式
	 *  意图: 保证一个类仅有一个实例 并提供一个访问它的全局访问点
	 *  
	 * 
	 * 
	 */
	public class MazeFactory{
		public static  MazeFactory instance = null;
		private MazeFactory() {
		}
		public MazeFactory instance(){
			if(instance == null){
				instance = new MazeFactory();
			}
			return instance;
		}
	}
}
