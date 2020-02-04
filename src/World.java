import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class World extends Canvas implements Runnable{
    private Robot r;
    private int width;
    private int height;
    private String title = "World";
    private JFrame frame;
    private int fps = 30;
    private int ups = 30;
    private boolean running = false;
    private Thread thread;

    public World(int width, int height) {
        r = new Robot(10,10, 10);
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        frame = new JFrame();
        frame.setTitle(title);
    }
    private synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double frameUpdateInterval = 1000000000.0 / fps;
        double stateUpdateInterval = 1000000000.0 / ups;
        double deltaFrame = 0;
        double deltaUpdate = 0;
        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            deltaFrame += (now - lastTime) / frameUpdateInterval;
            deltaUpdate += (now - lastTime) / stateUpdateInterval;
            lastTime = now;

            while (deltaUpdate >= 1) {
                update();
                deltaUpdate--;
            }

            while (deltaFrame >= 1) {
                draw();
                deltaFrame--;
            }
        }
        stop();
    }

    private void draw() {

        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(r.color);
        g.fillRect(r.xPos,r.yPos,r.size,r.size);
        g.dispose();
        bs.show();

    }

    private void update() {

    }
    public static void main(String[] args) {


        World game = new World(800,600);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        game.start();
    }
}


