package pl.droids.interview.sudoku.utils.mapper;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pl.droids.interview.sudoku.domain.dto.BoardDto;
import pl.droids.interview.sudoku.domain.model.Board;

import static org.junit.Assert.assertEquals;

public class BoardMapperTest
{
    @Test
    public void shouldMapBoardToBoardDto()
    {
        List<List<Integer>> tiles = new LinkedList<>();
        tiles.add(new LinkedList<>(Arrays.asList(1, 2, 3)));
        tiles.add(new LinkedList<>(Arrays.asList(4, 5, 6)));
        Board board = new Board(tiles);

        BoardDto boardDto = BoardMapper.toBoardDto(board);

        assertEquals(6, boardDto.getBoard().size());
    }
}
