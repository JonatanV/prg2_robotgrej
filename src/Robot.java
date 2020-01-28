import java.awt.*;

public class Robot {
    int xPos;
    int yPos;
    float hunger;
    float thirst;
    int size;
    Color color = Color.BLUE;



    public Robot(int xPos, int yPos, int size) {
        this.xPos = xPos;
        this.yPos = yPos;
        hunger = 10;
        thirst = 10;
        this.size = size;

    }
}