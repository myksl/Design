package createPatterns;

public class Singleton {
	/*
	 *  创建型模式 名为单例模式
	 *  意图: 保证一个类仅有一个实例 并提供一个访问它的全局访问点
	 *  
	 * 
	 * 
	 */
	//当存在多个子类时,使用if语句来判断并决定创建哪个实例
	public class MazeFactory{
		public static  MazeFactory instance = null;
		//私有构造方法保证只有一个实例
		private MazeFactory() {
		}
		public static MazeFactory instance(){
			if(instance == null){
				instance = new MazeFactory();
			}
			return instance;
		}
	}
	
}
