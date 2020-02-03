package GOLStage4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimpleCellGrid extends JPanel implements Runnable{
    private static final int ROWS = 50;
    private static final int COLS = 50;
    private static final int CELL_WIDTH = 10;
    private static final int PREF_W = CELL_WIDTH * COLS;
    private static final int PREF_H = CELL_WIDTH * ROWS;
    private static SimpleCell[][] cellGrid = new SimpleCell[ROWS][COLS];

    public SimpleCellGrid() {
        for (int row = 0; row < cellGrid.length; row++) {
            for (int col = 0; col < cellGrid[row].length; col++) {
                int x = col * CELL_WIDTH;
                int y = row * CELL_WIDTH;
                cellGrid[row][col] = new SimpleCell(x, y, CELL_WIDTH);

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
        for (SimpleCell[] simpleCells : cellGrid) {
            for (int j = 0; j < cellGrid.length; j++) {
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
        for (SimpleCell[] cellRow : cellGrid) {
            for (SimpleCell simpleCell : cellRow) {
                simpleCell.draw(g2);
            }
        }
    }

//    @Override
//    public Dimension getPreferredSize() {
//        if (isPreferredSizeSet()) {
//            return super.getPreferredSize();
//        }
//        return new Dimension(PREF_W, PREF_H);
//    }

    @Override
    public void run() {
        cellGrid = new GenerationMaker4().nextGeneration(cellGrid);
        repaint();
//        try {
//            Thread.sleep(500);
//            run();
//        } catch (InterruptedException ignore) {
//
//        }
    }
    public void createAndShowGui(SimpleCellGrid scg) {
        //JFrame frame = new JFrame("Test");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(scg);
       // frame.setPreferredSize(new Dimension(-1, 250));
        //frame.pack();
        //frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
        run();
    }

//    public static void main(String[] args) {
//        SimpleCellGrid j = new SimpleCellGrid();
//        j.createAndShowGui(j);
//    }
}