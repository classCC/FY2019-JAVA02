import java.util.Scanner;

public class StudentManagerSystem{
	
	public static void main(String[]args){
		welcome();
		
		
		Admin[] admins=new Admin[5];
		initDate(admins);
		
		operation(admins);
	}
	
	public static void initDate(Admin[] admins){
		
		Admin admin=new Admin("admin","admin");
		admins[0]=admin;
		
	}
	
	public static void operation(Admin[] admins){
		
		Scanner s=new Scanner(System.in);
		System.out.print("请选择:");
		int operation=s.nextInt();
		
		if(operation==1){
			//登陆
			login(admins);
		}else if(operation==2){
			//退出
			
		}else{
			System.out.println("输入有误，请重新输入...");
			operation(admins);//递归调用
		}
	}
	
	public static void login(Admin[] admins){
		System.out.println("欢迎登陆");
		
		Scanner s=new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username=s.nextLine();
		System.out.println("请输入密码：");
		String password=s.nextLine();
		
		//判断用户名密码是否正确
		for(int i=0;i<admins.length;i++){
			Admin admin=admins[i];
			
			if(admin==null){
				continue;
			}
			if(username.equals(admin.username) && password.equals(admin.password)){
				System.out.println("欢迎你"+username);
				break;
			}
		}
	}
	
	public static void welcome(){
		System.out.println("========欢迎登陆学生管理系统========");
		System.out.println("1.登陆  2.退出");
		System.out.println("------------------------------------");
	}
	
}


//管理员类
class Admin{
	
	public String username;
	public String password;
	
	public Admin(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}

//学生类
class Student{
	public int id;
	public String name;
	public String sex;
	public int age;
	public String _class;
	public String address;
	public String phone;
	public String email;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	public String get_class(){
		return _class;
	}
	public void set_class(String _class){
		this._class=_class;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
}


