package abc;

public class MainClass
{
	public static void main(String[] args)
	{
		A a = new A(); // this is a reference to an object. The object has been created by instantiating.
		
		int sum = 0;
		sum += a.x; // will work because x is public
		sum += a.y; // will work because y is protected and we are in the same package. It will also work if accessed from a subclass.
		// sum += a.z; wont work because z is private. It can only be accessed from the same class.
		sum += a.t; // will work because t has the default access modifier. It will be visible from any class inside this package.
		
		ICanSing someSinger = new OperaSinger();
		someSinger.sing();  // Because OperaSinger implements ICanSing interface, we can hold a reference to it as ICanSing.
							// This will also allow us to call the sing method on a reference of type ICanSing because we know that every ICanSing can sing.
		
		B b = new B();
		if (b instanceof B)
		{
			System.out.println("b is instance of B");
		}
		if (b instanceof A)
		{
			System.out.println("b is instance of A");
		}
		// this shows that b is both an instance of A and B
		
		b.sayHello(""); // the original method from A has been overriden
		
		// X x = new X(); this won't work because X is abstract
		Y y = new Y();
		y.abc();
		y.ABC();
	}
}

class A // this is a class
{
	// this is member data
	public int x;
	protected int y;
	private int z;
	int t;
	
	// this is a member method
	public void sayHello(String name)
	{
		System.out.println("Hello " + name + "!");
	}
	
	// this is a member method
	public void sayHelloWorld()
	{
		System.out.println("Hello world!");
	}
}

class OperaSinger implements ICanSing
{
	public void sing() {
		System.out.println("Singing...lalala...lalala...");
	}
}

interface ICanSing
{
	void sing();
}

class B extends A // class B inherits from class A
{
	@Override
	public void sayHello(String name)
	{
		System.out.println("Hello there " + name + "!");
	}
}

abstract class X
{
	public abstract void abc();
	
	public void ABC()
	{
		System.out.println("implemented from abstract class");
	}
}

class Y extends X
{
	@Override
	public void abc() {
		// TODO Auto-generated method stub
		System.out.println("This needs to be implemented here.");
	}
}