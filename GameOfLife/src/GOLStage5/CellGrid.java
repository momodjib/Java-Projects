package GOLStage5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CellGrid extends JPanel implements Runnable{
    private static final int ROWS = 60;
    private static final int COLS = 60;
    private static final int CELL_WIDTH = 10;
    private static Cell[][] cellGrid = new Cell[ROWS][COLS];

    public CellGrid() {
        reset();
    }

    public void reset() {
        cellGrid = new Cell[ROWS][COLS];
        for (int row = 0; row < cellGrid.length; row++) {
            for (int col = 0; col < cellGrid[row].length; col++) {
                int x = col * CELL_WIDTH;
                int y = row * CELL_WIDTH;
                cellGrid[row][col] = new Cell(x, y, CELL_WIDTH);

                if (new Random().nextBoolean()) {
                    cellGrid[row][col].setAlive(true);
                } else {
                    cellGrid[row][col].setAlive(false);
                }
            }
        }
    }

    public int totalAlive(){
        int totalAlive = 0;
        for (Cell[] cells : cellGrid) {
            for (int j = 0; j < cellGrid.length; j++) {
                if (cells[j].isAlive())
                    totalAlive++;
            }
        }
        return totalAlive;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Cell[] cellRow : cellGrid) {
            for (Cell cell : cellRow) {
                cell.draw(g2);
            }
        }
    }

    @Override
    public void run() {
        cellGrid = new GenerationMaker5().nextGeneration(cellGrid);
        repaint();
    }
}