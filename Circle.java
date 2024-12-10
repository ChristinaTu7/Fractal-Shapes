import java.awt.Color;

public class Circle {
  private double x;
  private double y;
  private double radius;
  private Color color;

  public Circle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double calculatePerimeter() {
    return 6.283185307179586 * this.radius;
  }

  public double calculateArea() {
    return Math.PI * this.radius * this.radius;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setPos(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public Color getColor() {
    return this.color;
  }

  public double getXPos() {
    return this.x;
  }

  public double getYPos() {
    return this.y;
  }

  public double getRadius() {
    return this.radius;
  }
}
