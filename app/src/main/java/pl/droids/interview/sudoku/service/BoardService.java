package pl.droids.interview.sudoku.service;

import pl.droids.interview.sudoku.model.Board;
import pl.droids.interview.sudoku.repository.BoardRepository;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoardService
{
    private static final String EASY_BOARD_QUERY = "https://sugoku.herokuapp.com/";
    private static final String BOARD_DIFFICULTY = "easy";

    private Retrofit retrofit;
    private BoardRepository boardRepository;

    public Call<Board> obtainCall()
    {
        prepareRetrofit();
        prepareBoardRepository();

        return boardRepository.getBoard(BOARD_DIFFICULTY);
    }

    private void prepareRetrofit()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(EASY_BOARD_QUERY)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void prepareBoardRepository()
    {
        boardRepository = retrofit.create(BoardRepository.class);
    }
}
