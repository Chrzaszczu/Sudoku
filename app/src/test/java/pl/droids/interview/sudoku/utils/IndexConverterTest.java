package pl.droids.interview.sudoku.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndexConverterTest
{
    @Test
    public void shouldReturnCorrectSubBoardIndex()
    {
        int[] expectedIndexes = new int[]
                {
                        0, 0, 2, 2,
                        0, 0, 2, 2,
                        1, 1, 3, 3,
                        1, 1, 3, 3
                };

        for(int i = 0; i < expectedIndexes.length; i++)
        {
            int convertedIndex = IndexConverter
                    .listIndexToSubBoardIndex(i, 4, 2);
            assertEquals(expectedIndexes[i], convertedIndex);
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDimensionsAreTooLow()
    {
        IndexConverter.listIndexToSubBoardIndex(0, 2, 1);
    }
}
