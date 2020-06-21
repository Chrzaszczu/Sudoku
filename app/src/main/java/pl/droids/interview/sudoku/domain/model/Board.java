package pl.droids.interview.sudoku.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Board
{
    @SerializedName("board")
    @Expose
    private List<List<Integer>> board;
}
