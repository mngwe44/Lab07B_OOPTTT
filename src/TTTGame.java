import javax.swing.*;

public class TTTGame {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;

    public TTTGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
    }

    public void makeMove(int row, int col, TTTTileButton button) {
        if (!gameOver && board[row][col] == '\0') {
            board[row][col] = currentPlayer;
            button.setSymbol(currentPlayer);

            if (checkWin(row, col)) {
                JOptionPane.showMessageDialog(null, currentPlayer + " wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkWin(int row, int col) {
        char player = board[row][col];
        return (board[row][0] == player && board[row][1] == player && board[row][2] == player) ||
                (board[0][col] == player && board[1][col] == player && board[2][col] == player) ||
                (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '\0') return false;
            }
        }
        return true;
    }

    public void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\0';
            }
        }
        currentPlayer = 'X';
        gameOver = false;
    }
}

