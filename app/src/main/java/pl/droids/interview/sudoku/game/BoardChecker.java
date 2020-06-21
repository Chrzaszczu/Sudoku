package pl.droids.interview.sudoku.game;

import java.util.LinkedList;
import java.util.List;

import pl.droids.interview.sudoku.domain.model.Tile;

public class BoardChecker
{
    private static final int BOARD_DIMENSION = 9;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;

    private List<Tile> board;
    private List<List<Tile>> subBoards;

    public BoardChecker(List<Tile> board)
    {
        this.board = board;
    }

    public boolean isFinished()
    {
        SubBoardPreparer preparer = new SubBoardPreparer(board);
        this.subBoards = preparer.obtainSubBoards();

        if(hasInvalidFormat())
        {
            return false;
        }

        for(int index = 0; index < BOARD_DIMENSION; index++)
        {
            if(hasDuplicate(index))
            {
                return false;
            }
        }

        return true;
    }

    private boolean hasInvalidFormat()
    {
        for(Tile tile: board)
        {
            if(tile.getValue() > MAX_VALUE || tile.getValue() < MIN_VALUE)
            {
                return true;
            }
        }

        return false;
    }

    private boolean hasDuplicate(int index)
    {
        return hasDuplicate(getRow(index))
                || hasDuplicate(getColumn(index))
                || hasDuplicate(getSubBoard(index));
    }

    private boolean hasDuplicate(List<Tile> list)
    {
        return list.stream()
                .distinct()
                .count() != list.size();
    }

    private List<Tile> getSubBoard(int subBoardNumber)
    {
        return subBoards.get(subBoardNumber);
    }

    private List<Tile> getRow(int rowNumber)
    {
        List<Tile> row = new LinkedList<>();

        int index = 0;
        for(Tile tile: board)
        {
            if(isTileInRow(index, rowNumber))
            {
                row.add(tile);
            }
            index++;
        }

        return row;
    }

    private List<Tile> getColumn(int columnNumber)
    {
        List<Tile> column = new LinkedList<>();

        int index = columnNumber;
        while(index < board.size())
        {
            column.add(board.get(index));
            index += BOARD_DIMENSION;
        }

        return column;
    }

    private boolean isTileInRow(int index, int rowNumber)
    {
        return index >= rowNumber * BOARD_DIMENSION &&
                index < (rowNumber + 1) * BOARD_DIMENSION;
    }
}