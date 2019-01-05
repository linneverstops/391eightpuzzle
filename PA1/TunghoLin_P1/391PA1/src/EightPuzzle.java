import java.util.Arrays;
/**
 * TungHo Lin
 * txl429
 * EECS391 PA1
 * class EightPuzzle
 */

public class EightPuzzle {

    //2D Array representation of this puzzle board
    String[][] board = new String[3][3];

    //the function value of this puzzle
    int f_value = this.g_value + this.h_value;

    //the g value/depth of this puzzle
    int g_value = 0;

    //the heuristic value of this puzzle
    int h_value = 99999;

    //the parent of this puzzle
    EightPuzzle parent = null;

    //the previous move that leads to this puzzle state
    String previousMove = "Solved";

    /**
     * Constructor for EightPuzzle
     * @param combination A String representation of the puzzle
     */
    EightPuzzle(String combination) throws Exception {
        if (EightPuzzle.isValidStringCombination(combination)) {
            int index = 0;
            //remove all spaces
            String str = combination.replaceAll("\\s+", "");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.board[i][j] = str.substring(index, index + 1);
                    index++;
                }
            }
        }
        else {
            throw new Exception("Invalid String representation!");
        }
    }

    /**
     * A second constructor that directly takes a 2D array as the board
     * @param board a 2D array that represents the board
     */
    EightPuzzle(String[][] board) throws Exception {
        if(EightPuzzle.isValidBoardCombination(board)) {
            this.board = board;
        }
        else {
            throw new Exception("Invalid board representation!");
        }
    }

    /**
     * Converting this puzzle's board representation to a String representation
     * @return this puzzle's String representation
     */
    String toStringRep() {
        return convertBoardToStringRep(this.board);
    }

    /**
     * Converting a puzzle's board representation to a String representation
     * @param board a puzzle's board representation
     * @return this puzzle's String representation
     */
    private static String convertBoardToStringRep(String[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                builder.append(board[i][j]);
            }
            if (i < 2)
                builder.append(' ');
        }
        return builder.toString();
    }

    /**
     * Check if the input String representation is valid
     * @param combination the input String representation
     * @return if the input String representation is valid
     */
    private static boolean isValidStringCombination(String combination) {
        return (containsOneBlank(combination) &&
                combination.matches("[1-8|b][1-8|b][1-8|b]\\s[1-8|b][1-8|b][1-8|b]\\s[1-8|b][1-8|b][1-8|b]"));
    }

    /**
     * Check if the input 2D array board representation is valid
     * @param board the input 2D array board representation
     * @return if the input 2D array board representation is valid
     */
    private static boolean isValidBoardCombination(String[][] board) throws Exception {
        return EightPuzzle.isValidStringCombination(EightPuzzle.convertBoardToStringRep(board));
    }

    /**
     * Returns if the input String representation contains exactly one blank tile
     * @param combination the input String representation
     * @return if the input String representation contains exactly one blank tile
     */
    private static boolean containsOneBlank(String combination) {
        return combination.length() - combination.replace("b", "").length() == 1;
    }

    /**
     * Check if another EightPuzzle object and this are identical by checking their 2D Array boardn representation
     * *Autogenerated
     * @param o another EightPuzzle object
     * @return if another EightPuzzle object and this are identical
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EightPuzzle that = (EightPuzzle) o;

        return Arrays.deepEquals(board, that.board);
    }

}
