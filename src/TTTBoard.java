import javax.swing.*;
import java.awt.*;

public class TTTBoard extends JPanel {
    private TTTTileButton[][] tiles;
    private TTTGame game;

    public TTTBoard(TTTGame game) {
        this.game = game;
        setLayout(new GridLayout(3, 3));
        tiles = new TTTTileButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j] = new TTTTileButton(i, j, game, this);
                add(tiles[i][j]);
            }
        }
    }

    public void updateBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j].reset();
            }
        }
    }
}
