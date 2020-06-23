package pl.droids.interview.sudoku.api.client;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import pl.droids.interview.sudoku.domain.dto.BoardDto;
import pl.droids.interview.sudoku.domain.enums.Difficulty;
import pl.droids.interview.sudoku.utils.mapper.BoardMapper;
import pl.droids.interview.sudoku.domain.model.Board;
import pl.droids.interview.sudoku.api.repository.BoardRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoardClient
{
    private static final String BOARD_QUERY = "https://sugoku.herokuapp.com/";

    private Retrofit retrofit;
    private BoardRepository boardRepository;

    public void loadNewBoard(MutableLiveData<BoardDto> board, Difficulty difficulty)
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

    private void callEnqueue(Call<Board> call, MutableLiveData<BoardDto> board)
    {
        call.enqueue(new Callback<Board>()
        {
            @Override
            public void onResponse(@NonNull Call<Board> call, @NonNull Response<Board> response)
            {
                if(response.isSuccessful() && response.body() != null)
                {
                    board.postValue(BoardMapper.toBoardDto(response.body()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Board> call, @NonNull Throwable t)
            {
            }
        });
    }
}
