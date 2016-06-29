package structurePatterns;

public class Proxy {
	/*
	 * 名称:代理
	 * 
	 * 意图:为其他对象提供一种代理以提供对这种对象的访问
	 * 
	 * 适用性:
	 * 1.远程代理:为一个对象在不同的地址空间提供局部代表
	 * 2.保护代理:控制对原始对象的访问
	 * 3.虚代理:根据需要创建开销很大的对象
	 * 4.智能指引:在访问对象的时候提供一些额外的操作
	 * 
	 * 参与者:
	 * 1.Proxy:保存一个引用使得代理可以访问实体,提供与Subject的接口相同的接口,控制对实体的存取
	 * 2.Subject定义RealSubject和Proxy相同的接口 这样可以使用RealSubject的地方就可以使用Proxy
	 * 3.realSubject 定义proxy所代表的实体
	 * 
	 * 效果:Proxy在访问对象时提供了一定的间接性
	 * 1.远程代理隐藏了一个对象不在本地的事实
	 * 2.虚代理可以根据需要创建对象
	 * 3.保护代理可以控制对象的访问
	 */
	
	//----------------下面的例子是一个虚代理,为图形对象定义了一个接口
	public class Graphic{
		public void Draw(){
			
		}
		public void HandleMouse(){
			
		}
		public void GetExtent(){
			
		}
		public void Load(){
			
		}
		public void Save(){
			
		}
	}
	//Image实现了Graphic接口用来显示图形,重定义了HandleMouse方法来实现操作
	public class Image extends Graphic{
		public void Draw(){
			
		}
		public void HandleMouse(){
			
		}
		public void GetExtent(){
			
		}
		public void Load(){
			
		}
		public void Save(){
			
		}
	}
	//ImageProxy拥有Image相同的接口
	public class ImageProxy extends Graphic{
		public ImageProxy(String name){
			this.name = name;
			point = 0;
			image = 0;
		}
		private Image image;
		private Point point;
		private String name;
		public void Draw(){
			image.Draw();
		}
		public void HandleMouse(){
			
		}
		//根据需要的时候才创建对象
		public void GetExtent(){
			if(point==0){
				point = image.GetExtent();
				return point;
			}else{
				return point;
			}
		}
		public void Load(){
			
		}
		public void GetImage(){
			if(image==0){
				image = new Image(name);
				return image;
			}else{
				return image;
			}
		}
		public void Save(){
			
		}
	}
	//实际客户 使用代理
	public static void main(String[] args) {
		TextDocument text = new TextDocument();
		text.add(new ImageProxy("Proxy"));
	}
}
