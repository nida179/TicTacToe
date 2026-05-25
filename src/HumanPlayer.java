public class HumanPlayer implements Player{

    Mark mark;

    HumanPlayer(Mark mark){
        this.mark = mark;
    }

    @Override
    public void makeChoice(Board board) {

    }
    public Mark getMark(){
        return mark;
    }
}
