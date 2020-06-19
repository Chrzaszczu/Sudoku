package pl.droids.interview.sudoku.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.droids.interview.sudoku.domain.enums.Difficulty;
import pl.droids.interview.sudoku.domain.model.Board;
import pl.droids.interview.sudoku.service.BoardService;

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

    public void loadNewBoard(Difficulty difficulty)
    {
        if(board == null)
        {
            board = new MutableLiveData<>();
        }

        obtainBoard(difficulty);
    }

    private void obtainBoard(Difficulty difficulty)
    {
        BoardService boardService = new BoardService();
        boardService.loadNewBoard(board, difficulty);
    }
}