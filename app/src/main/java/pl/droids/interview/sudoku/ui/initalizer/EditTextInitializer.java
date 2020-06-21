package pl.droids.interview.sudoku.ui.initalizer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.gridlayout.widget.GridLayout;

import pl.droids.interview.sudoku.domain.model.Tile;
import pl.droids.interview.sudoku.ui.viewmodel.BoardViewModel;

import static pl.droids.interview.sudoku.utils.PixelConverter.getPixels;

public class EditTextInitializer
{
    private static final int DEFAULT_TILE_SIZE = 33;
    private static final int MAX_NUMBER_COUNT = 1;
    private static final int TEXT_SIZE = 11;
    private static final int MARGIN = 2;

    private BoardViewModel boardViewModel;
    private EditText editText;

    public EditTextInitializer(BoardViewModel boardViewModel)
    {
        this.boardViewModel = boardViewModel;
    }

    public EditText obtain(Context context, Tile tile, int tileIndex)
    {
        editText = new EditText(context);

        setOnTextEditListener(tileIndex);
        prepareParams(context);
        prepareBackground();
        prepareText(tile);
        setEnabled(tile);

        return editText;
    }

    private void setOnTextEditListener(final int tileIndex)
    {
        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s == "")
                {
                    boardViewModel.updateTile(tileIndex, 0);
                }
                else
                {
                    try
                    {
                        boardViewModel.updateTile(tileIndex, Integer.parseInt(s.toString()));
                    }
                    catch (NumberFormatException ignore)
                    {
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });
    }

    private void prepareParams(Context context)
    {
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();

        params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
        params.height = getPixels(context, DEFAULT_TILE_SIZE);
        params.width = getPixels(context, DEFAULT_TILE_SIZE);

        editText.setLayoutParams(params);
    }

    private void prepareBackground()
    {
        editText.setBackgroundColor(Color.WHITE);
    }

    @SuppressLint("SetTextI18n")
    private void prepareText(Tile tile)
    {
        editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(MAX_NUMBER_COUNT) });
        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setTextSize(TEXT_SIZE);
        editText.setText(parseInt(tile.getValue()));
    }

    private String parseInt(Integer value)
    {
        return value == 0 ? "" : value.toString();
    }

    private void setEnabled(Tile tile)
    {
        if(tile.isValueConst())
        {
            editText.setFocusable(false);
            editText.setEnabled(false);
        }
    }
}
