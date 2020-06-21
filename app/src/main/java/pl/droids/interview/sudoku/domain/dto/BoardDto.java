package pl.droids.interview.sudoku.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.droids.interview.sudoku.domain.model.Tile;

@Getter
@Setter
@AllArgsConstructor
public class BoardDto
{
    List<Tile> board;
}
