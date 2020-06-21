package pl.droids.interview.sudoku.game;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import pl.droids.interview.sudoku.domain.model.Tile;

import static org.junit.Assert.assertEquals;

public class BoardCheckerTest
{
    @Test
    public void correctlySolvedBoardShouldReturnTrue()
    {
        List<Tile> tiles = new LinkedList<>();
        prepareSolvedBoard(tiles);
        BoardChecker boardChecker = new BoardChecker(tiles);
        assertEquals(true, boardChecker.isFinished());
    }

    @Test
    public void incorrectlySolvedBoardShouldReturnFalse()
    {
        List<Tile> tiles = new LinkedList<>();
        prepareUnsolvedBoard(tiles);
        BoardChecker boardChecker = new BoardChecker(tiles);
        assertEquals(false, boardChecker.isFinished());
    }

    private void prepareSolvedBoard(List<Tile> tiles)
    {
        int[] board = new int[]
                {
                        4, 3, 5, 2, 6, 9, 7, 8, 1,
                        6, 8, 2, 5, 7, 1, 4, 9, 3,
                        1, 9, 7, 8, 3, 4, 5, 6, 2,
                        8, 2, 6, 1, 9, 5, 3, 4, 7,
                        3, 7, 4, 6, 8, 2, 9, 1, 5,
                        9, 5, 1, 7, 4, 3, 6, 2, 8,
                        5, 1, 9, 3, 2, 6, 8, 7, 4,
                        2, 4, 8, 9, 5, 7, 1, 3, 6,
                        7, 6, 3, 4, 1, 8, 2, 5, 9
        };

        for(int tile: board)
        {
            tiles.add(new Tile(tile,true));
        }
    }

    private void prepareUnsolvedBoard(List<Tile> tiles)
    {
        int[] board = new int[]
                {
                        4, 3, 5, 2, 6, 9, 7, 8, 1,
                        6, 8, 2, 5, 7, 1, 4, 9, 3,
                        1, 9, 7, 8, 3, 6, 5, 6, 2,
                        8, 2, 6, 1, 9, 5, 3, 4, 7,
                        3, 7, 4, 6, 8, 2, 9, 1, -5,
                        9, 5, 1, 7, 4, 3, 6, 2, 8,
                        5, 1, 9, 3, 2, 6, 8, 7, 4,
                        2, 4, 8, 9, 5, 7, 1, 3, 6,
                        7, 6, 3, 4, 1, 8, 2, 5, 9
                };

        for(int tile: board)
        {
            tiles.add(new Tile(tile,true));
        }
    }
}
