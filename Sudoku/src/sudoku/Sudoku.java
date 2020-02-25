package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author wangy
 */
public class Sudoku {

    private int[][] puzzle;
    private ArrayList<Integer> selectList;
            
    public Sudoku() {
        this.puzzle = new int[9][9];
        initSelectList();
        
        while (!isPuzzleValid())
            generatePuzzle();
    }
    
    public void generatePuzzle() {
        Random rand = new Random();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                initSelectList();
                updateSelectList(puzzle[i]);
                updateSelectList(getOneCol(j));
                updateSelectList(getOneSquare(i, j));
                
                try {
                    puzzle[i][j] = selectList.get(rand.nextInt(selectList.size()));
                } 
                catch (Exception e) {
                    puzzle = new int[9][9];
                    return;
                }
            }
                
    }
    
    private void initSelectList() {
        selectList = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            selectList.add(i);
    }
    
    private int[] getOneCol(int colIdx) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++)
            nums[i] = puzzle[i][colIdx];
        
        return nums;
    }
    
    private int[] getOneSquare(int row, int col) {
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        
        int[] nums = new int[9];
        
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                nums[(i - startRow) * 3 + j - startCol] = puzzle[i][j];
        
        return nums;
    }
    
    private void updateSelectList(int[] usedNums) {
        for (int usedNum : usedNums)
            if (selectList.contains(usedNum))
                selectList.remove((Integer)usedNum);
    }
    
    private boolean isPuzzleValid() {
        for (int[] row : puzzle)
            for (int num : row)
                if (num == 0)
                    return false;
        
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                str += puzzle[i][j] + " ";
                if (j == 2 || j == 5)
                    str += "| ";
            }
            str += "\n";
            if (i == 2 || i == 5)
                    str += "------+-------+-------\n";
        }
        
        return str;
    }
    
    
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        
        System.out.println(s);
    }
}
