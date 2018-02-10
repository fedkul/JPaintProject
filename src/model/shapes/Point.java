package model.shapes;

public class Point {
    private int x;
    private int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
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