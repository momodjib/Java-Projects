package GOLStage4;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    static JLabel aliveLabel = new JLabel("Alive:");
    static JLabel GenerationLabel = new JLabel("Generation #");
    static SimpleCellGrid body = new SimpleCellGrid();
    static JPanel header = new JPanel();
    static int genNumber = 1;


    public GameOfLife() {
        super("Game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        GenerationLabel.setName("GenerationLabel");
        aliveLabel.setName("aliveLabel");

        header.setLayout(new GridLayout(2,1));
        header.setBackground(Color.lightGray);
        header.setPreferredSize(new Dimension(this.getWidth(), 50));
        header.add(GenerationLabel);
        header.add(aliveLabel);

        body.setLayout(new BorderLayout());
        body.setPreferredSize(new Dimension(this.getWidth(), 450));

        add(header, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        setVisible(true);

    }

    public static void updateLabels(){

        GenerationLabel.setText("Generation #"+genNumber++);
        aliveLabel.setText("Alive: "+ body.totalAlive());
        body.run();

        try {
            Thread.sleep(500);
            updateLabels();
        } catch (InterruptedException ignore) { }
    }

    public static void main(String[] args) {
        new GameOfLife();
        updateLabels();
    }
}

