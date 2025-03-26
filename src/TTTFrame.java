import javax.swing.*;
import java.awt.*;

public class TTTFrame extends JFrame {
    private TTTBoard board;
    private TTTGame game;
    private JButton restartButton;

    public TTTFrame() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        game = new TTTGame();
        board = new TTTBoard(game);

        restartButton = new JButton("Restart Game");
        restartButton.addActionListener(e -> {
            game.resetGame();
            board.updateBoard();
        });

        add(board, BorderLayout.CENTER);
        add(restartButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TTTFrame frame = new TTTFrame();
            frame.setVisible(true);
        });
    }
}


