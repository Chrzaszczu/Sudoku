package pl.droids.interview.sudoku.utils.mapper;

import java.util.LinkedList;
import java.util.List;

import pl.droids.interview.sudoku.domain.dto.BoardDto;
import pl.droids.interview.sudoku.domain.model.Board;
import pl.droids.interview.sudoku.domain.model.Tile;

public abstract class BoardMapper
{
    public static BoardDto toBoardDto(Board board)
    {
        List<Tile> tiles = new LinkedList<>();

        toList(board.getBoard()).forEach(item -> tiles.add(new Tile(item, isConst(item))));

        return new BoardDto(tiles);
    }

    public static List<Integer> toList(List<List<Integer>> list2D)
    {
        List<Integer> list = new LinkedList<>();

        for(List<Integer> subList: list2D)
        {
            list.addAll(subList);
        }

        return list;
    }

    public static List<List<Integer>> toList2D(List<Integer> list, int dimension)
    {
        List<List<Integer>> list2D = new LinkedList<>();
        initializeList2D(list2D, dimension);

        int index = 0;
        int subListIndex = 0;
        for(Integer item: list)
        {
            if(index >= dimension)
            {
                index = 0;
                subListIndex++;
            }

            list2D.get(subListIndex).add(item);
            index++;
        }

        return list2D;
    }

    private static boolean isConst(Integer item)
    {
        return item > 0;
    }

    private static void initializeList2D(List<List<Integer>> list2D, int dimension)
    {
        for(int i = 0; i < dimension; i++)
        {
            list2D.add(new LinkedList<>());
        }
    }
}
