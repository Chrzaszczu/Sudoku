package pl.droids.interview.sudoku.repository;

import pl.droids.interview.sudoku.model.Board;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BoardRepository
{
    @GET("board")
    Call<Board> getBoard(@Query("difficulty") String difficulty);
}
