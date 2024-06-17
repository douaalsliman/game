/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author DoAls8033
 */

package chessboard;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessBoard extends JPanel {

    @Override
    public void paint(Graphics g) {
        // Draw the chessboard
        int tileSize = 75;
        int boardSize = 8;
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(50 + col * tileSize, 50 + row * tileSize, tileSize, tileSize);
            }
        }

        // Draw the pieces
        drawPieces(g, tileSize);
    }

    private void drawPieces(Graphics g, int tileSize) {
        // Define the initial positions of the pieces
        String[] pieces = {
            "RNBQKBNR",
            "PPPPPPPP",
            "        ",
            "        ",
            "        ",
            "        ",
            "pppppppp",
            "rnbqkbnr"
        };

        // Draw the pieces
        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces[row].length(); col++) {
                char piece = pieces[row].charAt(col);
                if (piece != ' ') {
                    drawPiece(g, piece, col, row, tileSize);
                }
            }
        }
    }

    private void drawPiece(Graphics g, char piece, int col, int row, int tileSize) {
        // Define piece colors
        Color pieceColor;
        if (Character.isUpperCase(piece)) {
            pieceColor = Color.WHITE;
        } else {
            pieceColor = Color.BLACK;
        }

        // Draw the piece
        g.setColor(pieceColor);
        g.drawString(String.valueOf(piece), 50 + col * tileSize + tileSize / 2, 50 + row * tileSize + tileSize / 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setTitle("Draw Chess Board with Pieces");
        frame.getContentPane().add(new ChessBoard());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
