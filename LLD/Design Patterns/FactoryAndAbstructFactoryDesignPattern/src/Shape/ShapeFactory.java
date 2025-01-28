package Shape;

public class ShapeFactory {
    Shape circle;
    Shape rectangle;
    public ShapeFactory(){
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }

    public Shape getShape(String shape){
        if (shape==null){
            return null;
        } else if (shape.equals("circle")) {
            return this.circle;
        } else if (shape.equals("rectangle")) {
            return this.rectangle;
        }
        return null;
    }
}
