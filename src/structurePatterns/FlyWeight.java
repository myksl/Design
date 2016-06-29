package structurePatterns;

public class FlyWeight {
	/*
	 * 名称:享元
	 * 
	 * 意图:运用共享技术支持大量细粒度的对象
	 * --------关键属性 ----内部状态:存储在flyweight中,这些信息使得FlyWeight可以呗共享  外部状态:取决于场景,随场景变化,不可共享
	 * 
	 * 适用性
	 * FlyWeight的有效性很大程度上取决于如何使用它和在何处使用它
	 * 1.一个程序使用了大量的对象
	 * 2.由于使用了大量的对象,造成了巨大的开销
	 * 3.对象的大多数状态可以变为外部状态
	 *
	 * 参与者:
	 * 1.FlyWeight 描述一个接口,通过这个接口FlyWeight可以接受外部状态并作用于外部状态
	 * 2.ConcreteFlyWeight 实现FlyWeight接口,并为内部状态增加存储空间,ConcreteFlyWeight必须是可以共享的,他存储的状态必须是内部的
	 * 比如独立于ConcreteFlyWeight使用的场景
	 * 3.UnsharedConcreteFlyWeight 并非所有的FlyWeight的子类都需要被共享
	 * 4.FlyWeightFactory 创建并保管FlyWeight对象
	 * 
	 * 协作方式:
	 * FlyWeight执行时的状态必须是内部或者外部的,内部状态存储在ConcreteFlyWeight中,外部状态则由用户计算,当客户使用
	 * ConcreteFlyWeight时,将外部状态传递
	 * 用户不直接实例化ConcreteFlyWeight,而是通过工厂获取对象 
	 * 
	 * 
	 * 效果:
	 * 节约的内存由三个方面决定:
	 * 1.因为共享,实例总数减少的数目
	 * 2.对象内部状态的平均数目
	 * 3.外部状态是计算的还是存储的
	 * ------------FlyWeight通常和Composite组合起来形成一个层次结构使用
	 */
	//FlyWeight类,同时也可以是Composite类
	 public classv Glyph{
		 void First(){};
		 void Next(){};
		 void Insert(){};
		 void Remove(){};
	 }
	 //ConcreteFlyWeight,可以共享的ConcreteFlyWeight
	 public class Character extends Glyph{
		 private char c;
		 Character(char c){
			 this.c = c;
		 }
		 void Draw(Window window,GlyphContext gly){
			 
		 }
		 
	 }
	 //工厂方法,通过工厂方法来访问ConcreteFlyWeight
	 public class GlyphFactory{
		 private Character[] list = new Character[];
		 public GlyphFactory(){
			 for(int i =0;i<list.length;i++){
				 Character[i] = 0;
			 }
		 }
 		 public Character CreateCharacter(char c){
			 if(Character[c]==null){
				 Character[c] = new Character(c);
				 return Character[c];
			 }else{
				 return Character[c];
			 }
		 }
		 public Row CreateRow(){
			 
		 }
		 public Column CreateColumn(){
			 
		 }
	 }
}
