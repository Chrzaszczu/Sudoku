package pl.droids.interview.sudoku.domain.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Tile
{
    private Integer value;
    private boolean valueConst;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Tile tile = (Tile) o;
        return Objects.equals(value, tile.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(value);
    }
}
