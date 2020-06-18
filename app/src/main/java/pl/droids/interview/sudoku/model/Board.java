package pl.droids.interview.sudoku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Board
{
    @SerializedName("board")
    @Expose
    private List<List<Integer>> board;
}
