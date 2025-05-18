package P4.src.message;

import P4.src.data.Pair;
import java.util.List;

public class ResultMessage extends Message {

    private final int points;
    private final List<Pair> updateDiceList;

    public ResultMessage(int points, List<Pair> updateDiceList) {

        super(MessageType.RESULT);
        this.points = points;
        this.updateDiceList = updateDiceList;

    }

    public int getPoints() {
        return points;
    }

    public List<Pair> getUpdateDiceList() {
        return updateDiceList;
    }

}
