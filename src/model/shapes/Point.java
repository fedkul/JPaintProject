package model.shapes;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Point(Point p){
        x = p.getX();
        y = p.getY();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public Boolean equals(Point other){
        return other.getX() == x &&
                other.getY() == y;
    }
}
