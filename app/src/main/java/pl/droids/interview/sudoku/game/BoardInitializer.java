package pl.droids.interview.sudoku.game;

import android.content.Context;
import android.widget.EditText;

import androidx.gridlayout.widget.GridLayout;

import java.util.List;

import pl.droids.interview.sudoku.domain.model.Board;
import pl.droids.interview.sudoku.utils.EditTextInitializer;

public class BoardInitializer
{
    private static final int DEFAULT_BOARD_COUNT = 9;

    private GridLayout gridLayout;
    private EditTextInitializer initializer;

    public BoardInitializer(GridLayout gridLayout)
    {
        this.gridLayout = gridLayout;
    }

    public void initialize(Board board)
    {
        initializer = new EditTextInitializer();
        Context context = gridLayout.getContext();
        List<List<Integer>> body = board.getBoard();

        gridLayout.removeAllViews();
        setBoardSize();

        int tileIndex = 0;
        for(List<Integer> tiles: body)
        {
            for(Integer tile: tiles)
            {
                gridLayout.addView(createEditText(context, parseInt(tile)), tileIndex);
                tileIndex++;
            }
        }
    }

    private String parseInt(Integer tile)
    {
        return tile == 0 ? "" : tile.toString();
    }

    private void setBoardSize()
    {
        gridLayout.setColumnCount(DEFAULT_BOARD_COUNT);
        gridLayout.setRowCount(DEFAULT_BOARD_COUNT);
    }

    private EditText createEditText(Context context, String text)
    {
        return initializer.obtain(context, text);
    }
}
