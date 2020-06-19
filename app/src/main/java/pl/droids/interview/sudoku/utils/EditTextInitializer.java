package pl.droids.interview.sudoku.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import androidx.gridlayout.widget.GridLayout;

import static pl.droids.interview.sudoku.utils.PixelConverter.getPixels;

public class EditTextInitializer
{
    private static final int DEFAULT_TILE_SIZE = 32;
    private static final int MAX_NUMBER_COUNT = 1;
    private static final int TEXT_SIZE = 12;
    private static final int MARGIN = 2;

    private EditText editText;

    @SuppressLint("ResourceType")
    public EditText obtain(Context context, String text)
    {
        editText = new EditText(context);

        prepareBackground(context);
        prepareText(text);

        return editText;
    }

    private void prepareBackground(Context context)
    {
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
        params.height = getPixels(context, DEFAULT_TILE_SIZE);
        params.width = getPixels(context, DEFAULT_TILE_SIZE);
        editText.setLayoutParams(params);
        editText.setBackgroundColor(Color.WHITE);
    }

    private void prepareText(String text)
    {
        editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(MAX_NUMBER_COUNT) });
        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setTextSize(TEXT_SIZE);
        editText.setText(text);

        if(!text.equals(""))
        {
            editText.setFocusable(false);
            editText.setEnabled(false);
        }
    }
}
