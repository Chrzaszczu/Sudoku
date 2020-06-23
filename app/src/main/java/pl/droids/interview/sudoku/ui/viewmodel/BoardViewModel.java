package pl.droids.interview.sudoku.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.droids.interview.sudoku.domain.dto.BoardDto;
import pl.droids.interview.sudoku.domain.enums.Difficulty;
import pl.droids.interview.sudoku.domain.model.Tile;
import pl.droids.interview.sudoku.api.client.BoardClient;

public class BoardViewModel extends ViewModel
{
    private MutableLiveData<BoardDto> boardDto;

    public LiveData<BoardDto> getBoardDto()
    {
        if(boardDto == null)
        {
            boardDto = new MutableLiveData<>();
        }

        return boardDto;
    }

    public void loadNewBoard(Difficulty difficulty)
    {
        if(boardDto == null)
        {
            boardDto = new MutableLiveData<>();
        }

        obtainBoard(difficulty);
    }

    public void updateTile(int index, Integer value)
    {
        if(this.boardDto.getValue() != null)
        {
            Tile tile = this.boardDto.getValue().getBoard().get(index);
            tile.setValue(value);
        }
    }

    private void obtainBoard(Difficulty difficulty)
    {
        BoardClient boardClient = new BoardClient();
        boardClient.loadNewBoard(boardDto, difficulty);
    }
}