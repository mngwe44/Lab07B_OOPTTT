import javax.swing.*;
import java.awt.*;

public class TTTTileButton extends JButton {
    private int row, col;
    private TTTGame game;
    private TTTBoard board;

    public TTTTileButton(int row, int col, TTTGame game, TTTBoard board) {
        this.row = row;
        this.col = col;
        this.game = game;
        this.board = board;
        setFont(new Font("Arial", Font.BOLD, 40));
        addActionListener(e -> game.makeMove(row, col, this));
    }

    public void setSymbol(char symbol) {
        setText(symbol == '\0' ? "" : String.valueOf(symbol));
    }

    public void reset() {
        setText("");
    }
}
