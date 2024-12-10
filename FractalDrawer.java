import java.util.Scanner;
import java.awt.Color;
import java.util.Random;

public class FractalDrawer {
  private double totalArea = 0.0;

  public FractalDrawer() {
  }

  
  public double drawFractal(String type) {
    Canvas drawing = new Canvas(777, 777);
    Color pink = Color.PINK;
    if (type.equals("circle")) {
      this.drawCircleFractal(50.0, 350.0, 350.0, pink, drawing, 5);
      System.out.println("Total area of the fractal is " + this.totalArea);
    } else if (type.equals("rectangle")) {
      this.drawRectangleFractal(100.0, 75.0, 350.0, 350.0, pink, drawing, 5);
      System.out.println("The total area of the fractal is " + this.totalArea);
    } else if (type.equals("triangle")) {
      this.drawTriangleFractal(100.0, 100.0, 350.0, 350.0, pink, drawing, 5);
      System.out.println("The total area of the fractal is " + this.totalArea);
    } else {
      System.out.println("Cannot draw shape, please choose from the options: circle, triangle, rectangle: ");
    }
    return this.totalArea;
  }
  
  
  public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
    Triangle initialTriangle = new Triangle(x, y, width, height);
    Random randomize = new Random();
    float redHex = randomize.nextFloat();
    float greenHex = randomize.nextFloat();
    float blueHex = randomize.nextFloat();
    Color newRandomColor = new Color(redHex, greenHex, blueHex);
    initialTriangle.setColor(newRandomColor);
    can.drawShape(initialTriangle);
    this.totalArea += initialTriangle.calculateArea(); // Adds the calculated area of the fractal to the total area
    if (level != 0) { // If the base case is not met, it will recursively call itself with new values calculated in the parameter
      this.drawTriangleFractal(width / 2.0, height / 2.0, x + width / 4.0, y - height, c, can, level - 1); // Starts the x, y position at the top of the triangle
      this.drawTriangleFractal(width / 2.0, height / 2.0, x - width / 2.0, y, c, can, level - 1); // Moves the x, y position at the bottom left of the triangle
      this.drawTriangleFractal(width / 2.0, height / 2.0, x + width, y, c, can, level - 1); // Moves the x, y position at the bottom right of the triangle
    }
  }


  public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
    Circle initialCircle = new Circle(x, y, radius);
    Random randomize = new Random();
    float redHex = randomize.nextFloat();
    float greenHex = randomize.nextFloat();
    float blueHex = randomize.nextFloat();
    Color newRandomColor = new Color(redHex, greenHex, blueHex);
    initialCircle.setColor(newRandomColor);
    can.drawShape(initialCircle);
    this.totalArea += initialCircle.calculateArea(); // Adds the calculated area of the fractal to the total area
    if (level != 0) { // If the base case is not met, it will recursively call itself with new values calculated in the parameter
      this.drawCircleFractal(radius / 2.0, x - radius - radius / 2.0, y, c, can, level - 1); // Moves the new circle left of the current circle
      this.drawCircleFractal(radius / 2.0, x + radius + radius / 2.0, y, c, can, level - 1); // Moves the new circle right of the current circle
      this.drawCircleFractal(radius / 2.0, x, y - radius - radius / 2.0, c, can, level - 1); // Moves the new circle above the current
      this.drawCircleFractal(radius / 2.0, x, y + radius + radius / 2.0, c, can, level - 1); // Moves the new circle below the current
    }
  }


  public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
    Rectangle initialRectangle = new Rectangle(x, y, width, height);
    Random randomize = new Random();
    float redHex = randomize.nextFloat();
    float greenHex = randomize.nextFloat();
    float blueHex = randomize.nextFloat();
    Color newRandomColor = new Color(redHex, greenHex, blueHex);
    initialRectangle.setColor(newRandomColor);
    can.drawShape(initialRectangle);
    this.totalArea += initialRectangle.calculateArea(); // Adds the calculated area of the fractal to the total area
    if (level != 0) { // If the base case is not met, it will recursively call itself with new values calculated in the parameter
      this.drawRectangleFractal(width / 2.0, height / 2.0, x - width / 2.0, y - height, c, can, level - 1);  // Moves the x,y position to the left
      this.drawRectangleFractal(width / 2.0, height / 2.0, x - width / 2.0, y + height, c, can, level - 1);  // Moves the x,y position downward
      this.drawRectangleFractal(width / 2.0, height / 2.0, x + width, y + height, c, can, level - 1); // Moves the x,y position to the right
      this.drawRectangleFractal(width / 2.0, height / 2.0, x + width, y - height, c, can, level - 1); // Moves the x,y position upward
    }
}


  public static void main(String[] args) {
    System.out.println("Choose: 'circle', 'triangle', or 'rectangle' to get started");
    Scanner inputtedShape = new Scanner(System.in);
    String s = inputtedShape.nextLine();
    FractalDrawer myFractal = new FractalDrawer();
    myFractal.drawFractal(s);
  }
}