package behaviorPatterns;

public class Iterator {

	/*
	 * 名称:迭代器
	 * 
	 * 意图:提供一种方法顺序访问一个聚合对象中的各个元素,而又不暴露该对象的内部表示
	 * 
	 * 适用性:
	 * 1.访问一个聚合对象的内容而无需暴露它的内部表示
	 * 2.支持对聚合对象的多种遍历
	 * 3.为遍历不同的聚合结构提供一个统一的接口
	 * 
	 * 参与者:
	 * 1.Iterator 迭代器定义访问和遍历元素的接口
	 * 2.ConcreteIterator 具体迭代器实现迭代器接口,对该聚合遍历是跟踪当前位置
	 * 3.Aggregate 聚合定义创建相应迭代器对象的接口
	 * 4.ConcreteAggregate 具体聚合实现创建相应迭代器的接口,该操作返回ConcreteIterator的实例
	 * 
	 * 效果:
	 * 1.支持以不同的方式遍历一个聚合
	 * 2.迭代器简化了聚合的接口
	 * 3.可以在同一聚合上面有多个遍历
	 * 
	 * 实现:
	 * 1. 外部迭代器:客户来控制迭代,客户主动推进迭代的步伐
	 * 	    内部迭代器:客户只需要提交一个待执行的操作,迭代器对聚合中的每一个元素执行相应的操作
	 * 2.如果由聚合来定义遍历算法,迭代器来存储当前迭代的状态,我们称这种迭代器为游标
	 * 3.迭代器的健壮性:由于需要保证数据的一致性 所以要保证插入和删除操作都不会影响到遍历,而且无需拷贝该聚合
	 * 可以通过向聚合注册该迭代器,在元素发生改变的时候调整迭代器的内容,或者在内部维护额外的信息保证迭代的正确
	 */
	//列表和迭代器接口
	public class List{
		public long count(){
			
		}
		public Item get(int index){
			
		}
	}
	
	public class Iterator{
		public void First(){
			
		}
		public void Next(){
			
		}
		public IsDone(){
			
		}
		public Item CurrentItem(){
			
		}
	}
	//实现迭代器的子类
	public class listIterator extends Iterator{
		//存储需要遍历的列表
		private long index;
		//存储列表的游标
		private List<Item> list;
		listIterator(List<Item> list){
			this.list = list;
		}
		//将迭代器置于第一个元素
		public void First(){
			index = 0;
		}
		//将迭代器置于下一个元素
		public void Next(){
			index++;
		}
		//检测是否超界
		public IsDone(){
			return index>=list.count();
		}
		//返回当前索引指向的对象
		public Item CurrentItem(){
			if(IsDone()){
				throw IteratorOutOfBounds;
			}
			return list.get(index);
		}
	}
	//使用迭代器
	public static void main(String[] args) {
		List<Item> list;
		ListIterator listIterator = new ListIterator(list);
		
	}
	//避免限定于一种特定的列表实现
	public class AbstractList{
		//实现创建迭代器的工厂方法
		public Iterator createIterator(){
			return new Iterator(this);
		}
	}
}
