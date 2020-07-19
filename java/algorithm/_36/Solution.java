package algorithm._36;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                  {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                  {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                  {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                  {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                  {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                  {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                  {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(new Solution().isValidSudoku(arr));
    }

    public boolean isValidSudoku(char[][] board) {
        if (!validVertical(board)) {
            return false;
        }

        if (!validHorizon(board)) {
            return false;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++ ){
                if (!validBox(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
    // 세로
    private boolean validVertical(char[][] board) {
        for (int j = 0; j < board.length; j++) {
            Set<Character> hashSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (!valid(board, i, j, hashSet)) {
                    return false;
                }
            }
        }
        return true;
    }
    // 가로
    private boolean validHorizon(char[][] board) {
        for (int j = 0; j < board.length; j++) {
            Set<Character> hashSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (!valid(board, j, i, hashSet)) {
                    return false;
                }
            }
        }
        return true;
    }

    // box
    private boolean validBox(char[][] board, int index, int verticalIndex) {
        Set<Character> hashSet = new HashSet<>();
        for (int i = (index - 1) * 3; i < index * 3; i++) {
            for (int j = (verticalIndex - 1) * 3; j < verticalIndex * 3; j++) {
                if (!valid(board, i, j, hashSet)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int i, int j, Set<Character> hashSet) {
        if (board[i][j] == '.') {
            return true;
        }

        if (hashSet.contains(board[i][j])) {
            return false;
        }

        hashSet.add(board[i][j]);
        return true;
    }
}
