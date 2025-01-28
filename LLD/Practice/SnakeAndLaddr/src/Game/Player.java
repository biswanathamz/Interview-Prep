package Game;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Data
public class Player {
    private int playerId;
    private String playerName;
    public Player (int id, String playerName){
        this.playerId = id;
        this.playerName = playerName;
    }
}
