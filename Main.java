import java.util.Scanner;
//Complete this program that the user will be able to choose the quadilateral it wants to calculate its perimeter and area

class Main {
  public static void main(String[] args) {
    System.out.println("please enter the name of the quadilateral whose area and perimeter you would like to calculate(in the case of rhombus use a small 'r', while in the case of a rectangle use a large 'R'");
    //Declare a char to store the chosen quadilateral
    Scanner sc= new Scanner(System.in);
    char opt = sc.next().charAt(0);
    //using a switch check what the user selected and use it to calculate the perimeter and area of the desired quadilateral
     
    switch (opt){
      case 'p':
    //this should be in the parallelogram case
    System.out.println("This program calculates the area and perimeter of the parallelogram.");
    System.out.println("Input the base of your Parallelogram");
    float pBase = sc.nextFloat();
    System.out.println("Input the height of your Parallelogram");
    float pHeight = sc.nextFloat();
    Parallelogram p =new Parallelogram(pBase, pHeight);
    
    Quadilateral q = p;

  
    System.out.println("Input the dimension of the first pair of your Parallelogram");
    q.setLength(sc.nextFloat());
    System.out.println("Input the second pair of your Parallelogram");
    q.setBreadth(sc.nextFloat());
    
    System.out.printf("The area of the parallelogram with base %.2f and height %.2f is %.2f", pBase, pHeight, p.Area());

    System.out.println("");
    System.out.printf("The perimeter of the parallelogram with First Pair: %.2f and SecondPair: %.2f is %.2f", q.getLength(), q.getBreadth(), q.calculatePerimeter());
    System.out.println("");
    System.out.println("");
    System.out.println("");
    break;

    case 't':

    //this should be in the Trapezoid case
    float a,b,c,d,h;
     System.out.println("Calculation for a Trapezoid");
     System.out.println("Input value of the top side");
     a = sc.nextFloat();
     System.out.println("Input value of the base side");
      b = sc.nextFloat();
     System.out.println("Input value of the third side");
      c = sc.nextFloat();
     System.out.println("Input value of the fourth side");
     d = sc.nextFloat();
     System.out.println("Input height");
     h = sc.nextFloat();
     Trapezoid t = new Trapezoid(a, b, c, d, h);
      System.out.printf("The area of the Trapezoid with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, Fourth Side: %.2f and height: %.2f is %.2f", a, b, c, d, h, t.Area()); 
      System.out.println("");
    System.out.printf("The perimeter of the Trapezoid with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, and Fourth Side: %.2f is %.2f", a, b, c, d, t.calculatePerimeter()); 
    break;

    
      case 'r':

        System.out.println("This program calculates the area and perimeter of the Rhombus.");

        System.out.print("Input the first diagonal :");
        float d1 = sc.nextFloat();
        System.out.print("Input the second diagonal :");
        float d2 = sc.nextFloat();
        System.out.print("Input the value of a side :");
        float side = sc.nextFloat();
        Rhombus r= new Rhombus(d1,d2,side);
         System.out.printf("The area of the Rhombus with First diagonal: %.2f, Second diagonal: %.2f,  and side: %.2f is %.2f", d1,d2,side, r.Area()); 
      System.out.println("");
    System.out.printf("The perimeter of the rhombus is %.2f",r.calculatePerimeter()); 
    break;

    case 's':
    System.out.println("calculation for a square");
    System.out.println("input the value of the side ");
    float sq = sc.nextFloat();
    Square s = new Square(sq);
     System.out.printf("The area of the square is %.2f", s.Area()); 
      System.out.println("");
    System.out.printf("The perimeter of the square is %.2f", s.calculatePerimeter()); 
    break;

    case 'R':
    System.out.println("This program calculates the area and perimeter of a rectangle.");
    System.out.println("Input the length of your rectangle");
    float length = sc.nextFloat();
    System.out.println("Input the width of your rectangle");
    float width = sc.nextFloat();
    Rectangle R =new Rectangle(width, length);
     System.out.printf("The area of the rectangle is %.2f", R.Area()); 
      System.out.println("");
    System.out.printf("The perimeter of the rectangle is %.2f", R.calculatePerimeter()); 
    break;
  }
}
}
//Create class for Rhombus

class Rhombus extends Quadilateral{
  private float side1;
  private float side2;
  private float side3;
  
  public Rhombus (float d1, float d2, float side){
    side1 = d1;
    side2 = d2;
    side3 = side;
   
  }
  public float Area(){
    return (side1*side2)/2;
  }
  public float calculatePerimeter(){
    return side3*4;
  }
}
//Create class for square
class Square extends Quadilateral{
  private float side1;
  
  public Square (float sq){
    side1 = sq;
  }
  public float Area(){
    return side1*side1;
  }
  public float calculatePerimeter(){
    return side1*4;
  }

}

//create class for Rectangle

class Rectangle extends Quadilateral{
  private float side1;
   private float side2;
  
  public Rectangle(float length,float width ){
    side1 = length;
    side2 = width;
  }
  public float Area(){
    return side1*side2;
  }
  public float calculatePerimeter(){
    return 2*(side1+side2);
  }

}


class Trapezoid extends Quadilateral{
  private float side1;
  private float side2;
  private float side3;
  private float side4;
  private float side5;
  public Trapezoid (float a, float b, float c, float d, float h){
    side1 = a;
    side2 = b;
    side3 = c;
    side4 = d;
    side5= h;

  }
  public float Area(){
    return ((side1+side2)/2)*side5;
  }
  public float calculatePerimeter(){
    return side1+side2+side3+side4;
  }
}
class Parallelogram extends Quadilateral{
  private float base;
  private float height;
  public Parallelogram (float b, float h){
    if (b <= 0){
      System.out.println("You cannot have a negative or zero base. Therfore base returns to default which is 1");
      base = 1;
    }
    else
      base = b;
    if (h <= 0){
      System.out.println("You cannot have a negative or zero height. Therfore height returns to default which is 1");
      height = 1;
    }
    else
      height = h;
  }
  public float Area(){
    return base*height;
  }

}
class Quadilateral {
  private float length;
  private float breadth;

  public void setLength(float l){
    length = l;
  }

  public float getLength(){
    return length;
  }

  public void setBreadth(float b){
    breadth = b;
  }

  public float getBreadth(){
    return breadth;
  }

  public float calculatePerimeter(){
    return 2*(length+breadth);
  }
}

