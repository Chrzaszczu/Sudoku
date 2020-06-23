package pl.droids.interview.sudoku.game;

import java.util.LinkedList;
import java.util.List;

import pl.droids.interview.sudoku.domain.model.Tile;
import pl.droids.interview.sudoku.utils.IndexConverter;

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
            subBoards.get(
                    IndexConverter
                    .listIndexToSubBoardIndex(index, BOARD_DIMENSION, SUB_BOARD_DIMENSION))
                    .add(tile);
            index++;
        }

        return subBoards;
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
