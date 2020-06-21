package pl.droids.interview.sudoku.ui.initalizer;

import android.content.Context;
import android.widget.EditText;

import androidx.gridlayout.widget.GridLayout;

import java.util.List;

import pl.droids.interview.sudoku.domain.dto.BoardDto;
import pl.droids.interview.sudoku.domain.model.Tile;
import pl.droids.interview.sudoku.ui.viewmodel.BoardViewModel;

public class BoardInitializer
{
    private static final int DEFAULT_BOARD_COUNT = 9;

    private EditTextInitializer editTextInitializer;
    private BoardViewModel boardViewModel;
    private GridLayout gridLayout;

    public BoardInitializer(GridLayout gridLayout, BoardViewModel boardViewModel)
    {
        this.gridLayout = gridLayout;
        this.boardViewModel = boardViewModel;
    }

    public void initialize(BoardDto boardDto)
    {
        editTextInitializer = new EditTextInitializer(boardViewModel);
        Context context = gridLayout.getContext();
        List<Tile> body = boardDto.getBoard();

        gridLayout.removeAllViews();
        setBoardSize();

        int tileIndex = 0;
        for(Tile tile: body)
        {
            gridLayout.addView(createEditText(context, tile, tileIndex));
            tileIndex++;
        }
    }

    private void setBoardSize()
    {
        gridLayout.setColumnCount(DEFAULT_BOARD_COUNT);
        gridLayout.setRowCount(DEFAULT_BOARD_COUNT);
    }

    private EditText createEditText(Context context, Tile tile, int tileIndex)
    {
        return editTextInitializer.obtain(context, tile, tileIndex);
    }
}
