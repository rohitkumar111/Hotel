import java.util.Scanner;
public class pem_emp
{
	int day_salary;
	public static void main(String[] arg)
	{
		Scanner enter=new Scanner(System.in);
		emp obj=new emp();
		System.out.print("enter employee name :- ");
		obj.setName(enter.nextLine());
		System.out.print("enter employee id :- ");
		obj.setEmp_id(enter.nextLine());
		System.out.print("enter employee address :- ");
		obj.setAddress(enter.nextLine());
		System.out.print("enter employee salary :- ");
		obj.setSalary(enter.nextDouble());
		System.out.print("enter employee dept :- ");
		enter.next();
		obj.setDept(enter.nextLine());
		
		System.out.println("\n employee name :- "+obj.getName());
		
		System.out.println(" employee id :- "+obj.getEmp_id());
		
		System.out.println(" employee address :- "+obj.getAddress());
		
		System.out.println(" employee salary :- "+obj.getSalary());
		
		System.out.println(" employee dept :- "+obj.getDept());
		
	}
}
