package pl.droids.interview.sudoku;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import pl.droids.interview.sudoku.domain.enums.Difficulty;
import pl.droids.interview.sudoku.game.BoardInitializer;
import pl.droids.interview.sudoku.viewmodel.BoardViewModel;

public class MainActivity extends AppCompatActivity
{
    private BoardViewModel boardViewModel;
    private BoardInitializer boardInitializer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardInitializer = new BoardInitializer(findViewById(R.id.grid_layout));
        prepareBoardViewModel();
        setNewBoardOnClickListener();
    }

    private void setNewBoardOnClickListener()
    {
        Button newBoard = findViewById(R.id.new_board_button);
        newBoard.setOnClickListener(view -> boardViewModel.loadNewBoard(Difficulty.EASY));
    }

    private void prepareBoardViewModel()
    {
        boardViewModel = new ViewModelProvider(this).get(BoardViewModel.class);
        boardViewModel.getBoard().observe(this, board -> boardInitializer.initialize(board));
    }
}