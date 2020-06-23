package pl.droids.interview.sudoku.utils;

public abstract class IndexConverter
{
    private static final int MIN_BOARD_DIMENSION = 4;
    private static final int MIN_SUB_BOARD_DIMENSION = 2;

    public static int listIndexToSubBoardIndex(int index, int boardDimension, int subBoardDimension)
    {
        if(boardDimension < MIN_BOARD_DIMENSION || subBoardDimension < MIN_SUB_BOARD_DIMENSION)
        {
            throw new IllegalArgumentException("invalid input!");
        }

        int row = (index % boardDimension) / subBoardDimension;
        int column = (index / boardDimension) / subBoardDimension;

        return row * subBoardDimension  + column;
    }
}
