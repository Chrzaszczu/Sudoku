package pl.droids.interview.sudoku.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.droids.interview.sudoku.model.Board;
import pl.droids.interview.sudoku.service.BoardService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardViewModel extends ViewModel
{
    private MutableLiveData<Board> board;

    public LiveData<Board> getBoard()
    {
        if(board == null)
        {
            board = new MutableLiveData<>();
        }

        return board;
    }

    public void loadNewBoard()
    {
        if(board == null)
        {
            board = new MutableLiveData<>();
        }

        obtainBoard();
    }

    private void obtainBoard()
    {
        BoardService boardService = new BoardService();
        Call<Board> call = boardService.obtainCall();
        prepareCallEnqueue(call);
    }

    private void prepareCallEnqueue(Call<Board> call)
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
