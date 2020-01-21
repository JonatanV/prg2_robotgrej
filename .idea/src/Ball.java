import java.awt.*;

public class Ball{
    int x = 200;
    int y = 200;
    int vx = 0;
    int vy = 0;
    int size = 50;
    Color color = Color.PINK;


    public void  Ball(int x, int y, int vx, int vy, int size, Color color){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.color = Color.PINK;
        this.size = 50;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
}