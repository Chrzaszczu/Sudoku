package pl.droids.interview.sudoku.utils;

import android.content.Context;

public abstract class PixelConverter
{
    public static int getPixels(Context context, int dps)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dps * scale);
    }
}
