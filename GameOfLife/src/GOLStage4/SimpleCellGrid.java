package GOLStage4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimpleCellGrid extends JPanel implements Runnable{
    private static final int ROWS = 50;
    private static final int COLS = 50;
    private static final int CELL_WIDTH = 10;
    private static SimpleCell[][] simpleCellGrid = new SimpleCell[ROWS][COLS];

    public SimpleCellGrid() {
        for (int row = 0; row < simpleCellGrid.length; row++) {
            for (int col = 0; col < simpleCellGrid[row].length; col++) {
                int x = col * CELL_WIDTH;
                int y = row * CELL_WIDTH;
                simpleCellGrid[row][col] = new SimpleCell(x, y, CELL_WIDTH);

                if (new Random().nextBoolean()) {
                    simpleCellGrid[row][col].setAlive(true);
                } else {
                    simpleCellGrid[row][col].setAlive(false);
                }
            }
        }
    }
    public int totalAlive(){
        int totalAlive = 0;
        for (SimpleCell[] simpleCells : simpleCellGrid) {
            for (int j = 0; j < simpleCellGrid.length; j++) {
                if (simpleCells[j].isAlive())
                    totalAlive++;
            }
        }
        return totalAlive;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (SimpleCell[] simpleCellRow : simpleCellGrid) {
            for (SimpleCell simpleCell : simpleCellRow) {
                simpleCell.draw(g2);
            }
        }
    }

    @Override
    public void run() {
        simpleCellGrid = new GenerationMaker4().nextGeneration(simpleCellGrid);
        repaint();
    }
}