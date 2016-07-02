package behaviorPatterns;

public class TemplateMethod {
	/*
	 * 名称:模板方法
	 * 
	 * 意图:定义一个操作中算法的骨架,而讲一个步骤延迟到子类中,TemplateMethod使得子类可以不改变一个算法的结构即可重新定义该算法的某些
	 * 特定步骤
	 * 
	 * 适用性:
	 * 1.一次性实现算法中不变的部分,并将可变的行为延迟到子类中去
	 * 2.各子类中公共的行为应提取出来放到父类中避免代码重复
	 *
	 * 参与者:
	 * 1.AbstractClass 定义抽象的原语操作,具体的子类将他们重定义以实现一个算法具体操作中的各个步骤,实现一个模板方法,该模板不仅调用
	 * 原语操作,也调用定义在AbstractClass或其他对象中的操作
	 * 2.ConcreteClass 实现原语操作以完成算法中与特定子类相关的步骤
	 * 
	 * 
	 */
	public class View{
		//父类定义模板方法
		public void Display(){
			SetFocus();
			DoDisplay();
			ResetFocus();
		}
		public void DoDisplay(){
			
		}
		
	}
	public class MyView extends View{
		//子类重定义具体实现
		public void DoDisplay(){
			
		}
	}
	public static void main(String[] args) {
		//客户调用父类模板方法,实现了算法的不变结构
		Display();
	}
}
