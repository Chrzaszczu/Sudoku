package pl.droids.interview.sudoku.game;

import java.util.LinkedList;
import java.util.List;

import pl.droids.interview.sudoku.domain.model.Tile;

public class SubBoardPreparer
{
    private static final int BOARD_DIMENSION = 9;
    private static final int SUB_BOARD_DIMENSION = 3;

    private List<Tile> board;
    private List<List<Tile>> subBoards;

    public SubBoardPreparer(List<Tile> board)
    {
        this.board = board;
    }

    public List<List<Tile>> obtainSubBoards()
    {
        initializeSubBoards();

        int index = 0;
        for(Tile tile: board)
        {
            subBoards.get(convertToSubBoardIndex(index)).add(tile);
            index++;
        }

        return subBoards;
    }

    private int convertToSubBoardIndex(int index)
    {
        int row = (index % BOARD_DIMENSION) / SUB_BOARD_DIMENSION;
        int column = (index / BOARD_DIMENSION) / SUB_BOARD_DIMENSION;

        return row * SUB_BOARD_DIMENSION  + column;
    }

    private void initializeSubBoards()
    {
        subBoards = new LinkedList<>();
        for(int i = 0; i < BOARD_DIMENSION; i++)
        {
            subBoards.add(new LinkedList<>());
        }
    }
}
