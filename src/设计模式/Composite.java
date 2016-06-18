package 设计模式;

import java.util.Iterator;

public class Composite {
	/*
	 * 结构型模式 名为组合
	 * 意图 :将对象组合成树形 形成 部分-整体 的层次结构 Composite使得用户对单个对象和组合对象的使用具有一致性
	 * 
	 * 提供了一定的一致性  使得基本对象和组合对象拥有一致性 
	 * 可以一同使用
	 */
	public class Equipment{
		private String name;
		public void power(){
			
		}
		public void add(Equipment e){
			
		}
		public void remove(Equipment e){
			
		}	
		public Iterator<Equipment> CreateIterator(){
			
		}
	}
	//为访问和管理子设备提供了一些操作 
	public class  CompositeEquipment extends Equipment{
		private String name;
		public void power(){
			
		}
		public void add(Equipment e){
			
		}
		public void remove(Equipment e){
			
		}	
		public Iterator<Equipment> CreateIterator(){
			
		}
	}
	
}
