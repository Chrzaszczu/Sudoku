package pl.droids.interview.sudoku.service;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import pl.droids.interview.sudoku.domain.enums.Difficulty;
import pl.droids.interview.sudoku.domain.model.Board;
import pl.droids.interview.sudoku.repository.BoardRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoardService
{
    private static final String BOARD_QUERY = "https://sugoku.herokuapp.com/";

    private Retrofit retrofit;
    private BoardRepository boardRepository;

    public void loadNewBoard(MutableLiveData<Board> board, Difficulty difficulty)
    {
        prepareRetrofit();
        prepareBoardRepository();
        callEnqueue(boardRepository.getBoard(difficulty.getDifficulty()), board);
    }

    private void prepareRetrofit()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BOARD_QUERY)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void prepareBoardRepository()
    {
        boardRepository = retrofit.create(BoardRepository.class);
    }

    private void callEnqueue(Call<Board> call, MutableLiveData<Board> board)
    {
        call.enqueue(new Callback<Board>()
        {
            @Override
            public void onResponse(@NonNull Call<Board> call, @NonNull Response<Board> response)
            {
                if(response.isSuccessful())
                {
                    board.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Board> call, @NonNull Throwable t)
            {
            }
        });
    }
}
