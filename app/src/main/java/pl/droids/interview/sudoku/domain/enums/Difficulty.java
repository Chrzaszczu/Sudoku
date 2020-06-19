package pl.droids.interview.sudoku.domain.enums;

public enum Difficulty
{
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    RANDOM("random");

    private String difficulty;

    Difficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public String getDifficulty()
    {
        return difficulty;
    }
}
