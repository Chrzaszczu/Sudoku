package pl.droids.interview.sudoku.game;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import pl.droids.interview.sudoku.domain.model.Tile;

import static org.junit.Assert.assertEquals;

public class SubBoardPreparerTest
{
    @Test
    public void shouldReturnSubBoards()
    {
        List<Tile> tiles = new LinkedList<>();
        prepareBoard(tiles);
        SubBoardPreparer subBoardPreparer = new SubBoardPreparer(tiles);
        List<List<Tile>> subBoards = subBoardPreparer.obtainSubBoards();

        int index = 0;
        for(List<Tile> tiles1: subBoards)
        {
            for(Tile tile: tiles1)
            {
                assertEquals(index, (int) tile.getValue());
            }
            index++;
        }
    }

    private void prepareBoard(List<Tile> tiles)
    {
        int[] board = new int[]
                {
                        0, 0, 0, 3, 3, 3, 6, 6, 6,
                        0, 0, 0, 3, 3, 3, 6, 6, 6,
                        0, 0, 0, 3, 3, 3, 6, 6, 6,
                        1, 1, 1, 4, 4, 4, 7, 7, 7,
                        1, 1, 1, 4, 4, 4, 7, 7, 7,
                        1, 1, 1, 4, 4, 4, 7, 7, 7,
                        2, 2, 2, 5, 5, 5, 8, 8, 8,
                        2, 2, 2, 5, 5, 5, 8, 8, 8,
                        2, 2, 2, 5, 5, 5, 8, 8, 8
                };

        for(int tile: board)
        {
            tiles.add(new Tile(tile,true));
        }
    }
}
