public class Game {
    private int maxRange;
    private boolean continuePlaying;
    private int attemptsNumber;

    public int getAttemptsNumber() {
        return attemptsNumber;
    }

    public void setAttemptsNumber(int attemptsNumber) {
        this.attemptsNumber = attemptsNumber;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public boolean isContinuePlaying() {
        return continuePlaying;
    }

    public void setContinuePlaying(boolean continuePlaying) {
        this.continuePlaying = continuePlaying;
    }

    public Game(int maxRange) {
        this.maxRange = maxRange;
        continuePlaying = true;
    }
}
