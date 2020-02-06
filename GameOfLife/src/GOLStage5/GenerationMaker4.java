package GOLStage5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameOfLife extends JFrame implements ActionListener {

    private static class GameStep extends TimerTask {
        static GameOfLife life = new GameOfLife();

        @Override
        public void run() {
            updateLabels();
        }
    }

    static JLabel aliveLabel = new JLabel("Alive:");
    static JLabel GenerationLabel = new JLabel("Generation #");
    static CellGrid body = new CellGrid();
    static JPanel header = new JPanel();
    static int genNumber = 1;
    static Boolean isPaused = false;
    static JButton PlayToggleButton = new JButton("Pause");
    JButton ResetButton = new JButton("Reset");
    static GameStep game = new GameStep();
    static Timer timer = new Timer();

    public GameOfLife() {
        super("Game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 660);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        GenerationLabel.setName("GenerationLabel");
        aliveLabel.setName("aliveLabel");
        PlayToggleButton.setName("PlayToggleButton");
        ResetButton.setName("ResetButton");

        PlayToggleButton.addActionListener(this);
        ResetButton.addActionListener(this);

        Image play = new ImageIcon("src/icons/play.png").getImage().getScaledInstance(30,25, Image.SCALE_SMOOTH);
        Image reset = new ImageIcon("src/icons/r1.jpg").getImage().getScaledInstance(30,25, Image.SCALE_SMOOTH);

        PlayToggleButton.setIcon(new ImageIcon(play));
        ResetButton.setIcon(new ImageIcon(reset));

        PlayToggleButton.setPreferredSize(new Dimension(80,30));
        ResetButton.setPreferredSize(new Dimension(80,30));

        header.setLayout(new FlowLayout());
        header.setPreferredSize(new Dimension(100, this.getHeight()));
        header.add(PlayToggleButton);
        header.add(ResetButton);
        header.add(GenerationLabel);
        header.add(aliveLabel);

        body.setLayout(new BorderLayout());
        body.setPreferredSize(new Dimension(500, this.getHeight()));

        add(header, BorderLayout.WEST);
        add(body, BorderLayout.CENTER);
        setVisible(true);

    }

    public static void updateLabels(){
        body.run();
        GenerationLabel.setText("Generation #"+ genNumber++);
        aliveLabel.setText("Alive: "+ body.totalAlive());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Pause") || e.getActionCommand().equals("Play")){
            pauseResume();
        }
        else if(e.getActionCommand().equals("Reset")){
            reset();
        }
    }

    static void loopStep(){
        timer.schedule(game, 0,100);
    }

    static void pauseResume() {
        if(!isPaused){
            PlayToggleButton.setText("Play");
            isPaused = true;
            timer.cancel();
        }
        else{
            PlayToggleButton.setText("Pause");
            isPaused = false;
            timer = new Timer();
            timer.schedule(new GameStep(), 0,100);
        }
    }

    static void reset() {
        timer.cancel();
        isPaused = false;

        genNumber = 1;
        header = new JPanel();
        body.reset();

        timer = new Timer();
        timer.schedule(new GameStep(), 0,100);
    }

    public static void main(String[] args) {
        loopStep();
    }
}
