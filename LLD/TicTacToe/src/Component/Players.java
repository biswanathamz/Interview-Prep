package Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Players {
    private int playerId;
    private String playerName;
    private Symbol selectedSymbol;

    public Players(int playerId, String playerName, Symbol selectedSymbol){
        this.playerId = playerId;
        this.playerName = playerName;
        this.selectedSymbol = selectedSymbol;
    }
}
