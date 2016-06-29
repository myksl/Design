package structurePatterns;

import java.util.ArrayList;

public class Facade {
   /*
    * 名称:外观
    * 
    * 意图:为子系统中的一组接口提供一个一致的接口 ,Facade提供了一个高层接口,可以使得这个子系统更加容易被使用
    * 
    * 适用性:
    * 1.当你要为一个复杂子系统提供一个简单接口的时候
    * 2.客户的程序和抽象类之间拥有很大的依赖性,引入Facade将这个子系统与客户以及其他的子系统分离
    * 3.当需要构建一个层次结构的子系统时,通过Facade提供各层的入口点
    * 
    * 参与者:
    * 1.Facade 知道哪些子系统负责处理请求,将客户的请求代理给适当的子系统对象
    * 2.Subsystem 实现子系统的功能
    * 
    * 协作方式:
    * 客户通过发送请求给Facade的方式与子系统通讯,Facade将这些消息转发给适当的子系统对象,尽管是子系统对象在做实际的工作
    * Facade也必须将自身的接口转换为子系统的接口
    * 
    * 
    */
	//编译子系统定义了一个BytecodeStream类,它实现了一个Bytecode对象流,Bytecode对象封装了一个字节码,这个字节码可以用于指定机器指令
	//该子系统还定义了一个Token类,封装了编程语言中的标识符
	public class Scanner{
		private Istrean inputstream;
		public Scanner(Istrean istrean){
			this.istrean = istrean;
		}
		public Token Scan(){};
	}
	//用ProgramNodeBuilder Parser用Scanner生成的标识符构建一颗语法分析树
	public class Parser{
		public void Parse(Scanner s,ProgramNodeBuilder){
			
		}
	}
	//Parser调用ProgramNodeBuilder 逐步生成一颗语法分析树,ProgramNodeBuilder是生成器模式
	public class ProgramNodeBuilder{
		private ProgramNode programNode;
		public ProgramNode getProgramNode(){
			return this.programNode;
		}
		public ProgramNode NewVariable(){
			
		}
		public ProgramNode NewAssignment(){
			
		}
		public ProgramNode NewCondition(){
}
	}
	//语法分析树是由ProgramNode和它的子类构成的,这是一个组合模式
	public class ProgramNode{
		public void add(ProgramNode programNode){
			
		}
		public void remove(ProgramNode programNode){
			
		}
		public void Traverse(CodeGenerator gc){
			gc.visit();
			List<ProgramNode> list = new ArrayList<ProgramNode>();
			for(ProgramNode p :list){
				p.Traverse(gc);
			}
		}
	}
	//Traverse使用CodeGenerator作为参数来使用
	public class CodeGenerator{
		public void visit(Node){
			
		}
	}
	//真正的Compiler,Compiler作为外观使用,将所有部件集合在一起,提供了一个简单通用的接口来生成可执行代码
	public class Compiler{
		public Compile(istream InputStream){
			
		}
		public Compiler Compile(){
			Scanner scanner(input);
			ProgramNodeBuilder builder;
			Parser parser;
			parser.Parse(scanner,builder);
			//----省略部分
		}
	}
	
}
