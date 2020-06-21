package pl.droids.interview.sudoku;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import pl.droids.interview.sudoku.domain.dto.BoardDto;
import pl.droids.interview.sudoku.domain.enums.Difficulty;
import pl.droids.interview.sudoku.game.BoardChecker;
import pl.droids.interview.sudoku.ui.initalizer.BoardInitializer;
import pl.droids.interview.sudoku.ui.viewmodel.BoardViewModel;

public class MainActivity extends AppCompatActivity
{
    private BoardViewModel boardViewModel;
    private BoardInitializer boardInitializer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareBoardViewModel();
        setNewBoardOnClickListener();
        setCheckBoardOnClickListener();

        boardInitializer = new BoardInitializer(findViewById(R.id.grid_layout), boardViewModel);
    }

    private void prepareBoardViewModel()
    {
        boardViewModel = new ViewModelProvider(this).get(BoardViewModel.class);
        boardViewModel.getBoardDto().observe(this, boardDto -> boardInitializer.initialize(boardDto));
    }

    private void setNewBoardOnClickListener()
    {
        Button newBoard = findViewById(R.id.new_board_button);
        newBoard.setOnClickListener(view -> boardViewModel.loadNewBoard(Difficulty.EASY));
    }

    private void setCheckBoardOnClickListener()
    {
        final Button checkBoard = findViewById(R.id.check_board_button);

        checkBoard.setOnClickListener(view ->
        {
            final BoardDto boardDto = boardViewModel.getBoardDto().getValue();
            BoardChecker boardChecker;
            if(boardDto != null)
            {
                boardChecker = new BoardChecker(boardDto.getBoard());
                if (boardChecker.isFinished())
                {
                    Toast.makeText(this, "YOU WIN!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "SOMETHING IS WRONG!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}