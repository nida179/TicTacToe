import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    GameController controller;
    JButton[][] buttons;
    JLabel statusLabel;
    // add this as a class field
    JButton resetButton;

    GameView() {
        controller = new GameController();

        setTitle("Tic Tac Toe");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create components first, then add them
        statusLabel = new JLabel("Your Turn!");
        JPanel boardPanel = new JPanel(new GridLayout(3,3));
        resetButton = new JButton("Reset");
        // add correct components
        add(statusLabel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);

        // initialize buttons and add to boardPanel
        buttons = new JButton[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttons[i][j] = new JButton("");
                boardPanel.add(buttons[i][j]);

                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> {
                    controller.handleHumanMove(row,col);
                    updateBoard();
                    updateStatus();


                    if(!controller.isGameOver()) {
                        Timer timer = new Timer(500, event -> {
                            controller.makeAIMove();
                            updateBoard();
                            updateStatus();
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                });

            }
        }

        resetButton.addActionListener(e -> {
            controller.reset();
            updateBoard();
            updateStatus();
        });
        styleComponents();
        setVisible(true);
    }

    // outside constructor, separate method
    void updateBoard() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                Mark mark = controller.board.getMark(i,j);
                if(mark == Mark.X) buttons[i][j].setText("X");
                else if(mark == Mark.O) buttons[i][j].setText("O");
                else buttons[i][j].setText("");
                if(mark == Mark.X) {
                    buttons[i][j].setText("X");
                    buttons[i][j].setForeground(new Color(233, 69, 96)); // coral red
                }
                else if(mark == Mark.O) {
                    buttons[i][j].setText("O");
                    buttons[i][j].setForeground(new Color(0, 180, 216)); // steel blue
                }
                else {
                    buttons[i][j].setText("");
                }
            }
        }

    }
    void updateStatus() {
        Mark winner = controller.board.checkWinner();
        if(winner == Mark.X) statusLabel.setText("AI WINSS!!!🙏🙏🥶🥸");
        else if(winner == Mark.O) statusLabel.setText("YOU WIN!!!👌😌");
        else if(controller.board.isDraw()) statusLabel.setText("DRAW!!😓");
        else statusLabel.setText("Your Turn!");
        if(winner == Mark.X){
            statusLabel.setText("AI WINS!!!");
            highlightWinningCells();
        }
        else if(winner == Mark.O){
            statusLabel.setText("YOU WIN!!!");
            highlightWinningCells();
        }
    }
    void styleComponents() {
        // frame background
        getContentPane().setBackground(new Color(26, 26, 46));

        // status label
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setForeground(new Color(51, 51, 51));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // style each button
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttons[i][j].setBackground(new Color(22, 33, 62));
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 48));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(new Color(15, 52, 96), 2));
                statusLabel.setForeground(new Color(255, 255, 255));
                resetButton.setBackground(new Color(15, 52, 96));
                resetButton.setForeground(new Color(255, 255, 255));
                resetButton.setFont(new Font("Arial", Font.BOLD, 16));
                resetButton.setFocusPainted(false);
                resetButton.setBorderPainted(false);

            }
        }
    }
    void highlightWinningCells() {
        int[][] cells = controller.board.getWinningCells();
        if(cells != null){
            for(int[] cell : cells){
                buttons[cell[0]][cell[1]].setBackground(new Color(12, 67, 78));
            }
        }
    }
}