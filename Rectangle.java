import java.awt.Color;

public class Rectangle {
  private double x;
  private double y;
  private double width;
  private double height;
  private Color color;

  public Rectangle(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public double calculatePerimeter() {
    return 2.0 * this.height * this.width;
  }

  public double calculateArea() {
    return this.height * this.width;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setPos(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setWidth(double width) {
    this.width = width;
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

  public double getHeight() {
    return this.height;
  }

  public double getWidth() {
    return this.width;
  }
}
