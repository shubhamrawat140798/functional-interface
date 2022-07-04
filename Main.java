/*
Using (instance) Method reference create and apply add and subtract method and using (Static) 
Method reference create and apply multiplication method for the functional interface created.

Create an Employee Class with instance variables (String) name, (Integer)age, (String)city and 
get the instance of the Class using constructor reference  
Implement following functional interfaces from java.util.function using lambdas:

(1) Consumer

(2) Supplier

(3) Predicate

(4) Function

-Create and access default and static method of an interface.
-Override the default method of the interface.
-Implement multiple inheritance with default method inside  interface.

*/
import java.util.function.*;
public class Main {

    int add(int x, int y){
        return x+y;
    }
    int sub(int x, int y){
        return x+y;
    }
    static int mul(int x, int y){
        return x*y;
    }
   

    public static void main(String[] args) {
        Main object1= new Main();
        //Instance method refferencing
        addition a1 =object1::add;
        System.out.println("10+20: "+a1.addInterface(10, 10));
        //Instance method refferencing
        Main object2= new Main();
        subtraction s1 =object2::sub;
        System.out.println("20+10: "+s1.subInterface(20, 10));

        //Static method refferencing
        multiplication m1 =Main::mul;
        System.out.println("20X10: "+m1.mulInterface(20, 10));

        // Refference to constructor
        constructorReff e1 = Employee::new;
        e1.getEmployee("Hari", 21, "Delhi\n");
        
        // lambdas
        Consumer<Product> updatePrice = p -> p.setPrice(5.9);
        Product p = new Product();
        updatePrice.accept(p);
        System.out.print("Consumer : ");
        p.printPrice();
        
        Predicate<String> predicate = t -> t.length() > 10;
        String s = "Predicate";
        System.out.println("Predicate : "+predicate.test(s));

        String[] countries = {"India", "Australia", "England"};
        Function<String[], String> converter = (all) -> { 
            for(String n : all) {
                if(n=="India")
                    return "INDIA";  
           }
         return null;
        };
        System.out.println("Function :"+converter.apply(countries));

        int n = 3;
        display(() -> n + 10);

        Multi_Inheritance mi = new Multi_Inheritance();
        System.out.println("Calling overriden method of default interface");
        mi.multiplyVariable(12, 2);

        System.out.println("Calling overriden method of default interface");
        Parent.addVariables(12,12);

        System.out.println("Calling static method of interface");
        mi.subtractVariables(24, 9);
    }
    
    static void display(Supplier<Integer> arg) {
    System.out.println("Supplier :"+arg.get());
    }
}
class Product {
    private double price = 0.0;
  
    public void setPrice(double price) {
      this.price = price;
    }
  
    public void printPrice() {
      System.out.println(price);
    }
  }
  interface Parent{
      static void addVariables(int x, int y){
        System.out.println(x+y);
      }
      default void subtractVariables(int x, int y){
        System.out.println(x-y);
      }
  }
  interface Parent2{
      default void multiplyVariable(int x,int y){
            System.out.println(x*y);
      }
  }
  class Multi_Inheritance implements Parent,Parent2{
      @Override
      public void multiplyVariable(int x, int y){
        System.out.println("Overiden default method: "+x*y);
      }


  }

 interface addition{
     int addInterface(int x, int y);
 }
interface subtraction{
     int subInterface(int x, int y);
}
interface multiplication{
     int mulInterface(int x, int y);
}

class Employee{
    String name;
    int age;
    String city;
    Employee(String n, int a , String c){
        name = n;
        age = a;
        city = c;
        System.out.println("\nName: "+name+"\nAge: "+age+"\nCity: "+city);

    }
}
interface constructorReff{
    Employee getEmployee(String n, int a , String c);
}
