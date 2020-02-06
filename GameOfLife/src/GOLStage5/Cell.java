package GOLStage5;

import java.awt.*;

public class Cell {
    private static final Color ALIVE_COLOR = Color.black;
    private static final Color DEAD_COLOR = Color.gray;
    private boolean alive = false;
    private int x;
    private int y;
    private int width;
    private Rectangle rectangle;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public Cell(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        rectangle = new Rectangle(x, y, width, width);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void draw(Graphics2D g2) {
        if(alive) {
            g2.setColor(ALIVE_COLOR);
        }
        else{
            g2.setColor(DEAD_COLOR);
        }
        g2.fill(rectangle);
    }

}