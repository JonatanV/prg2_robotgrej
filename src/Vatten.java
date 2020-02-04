import java.awt.*;
import java.util.Random;
public class Vatten {
    int xPos;
    int yPos;
    int size = 10;
    Color c = Color.BLUE;
    float thirstValue;

    public Vatten(){
        Random r = new Random();
        this.xPos = r.nextInt(80);
        this.yPos = r.nextInt(60);
        this.xPos = xPos*10;
        this.yPos = yPos*10;

    }
}


