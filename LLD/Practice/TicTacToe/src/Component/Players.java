package Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Players {
    private int playerId;
    private String playerName;
    private PlayingPiece selectedPlayingPiece;

    public Players(int playerId, String playerName, PlayingPiece selectedPlayingPiece){
        this.playerId = playerId;
        this.playerName = playerName;
        this.selectedPlayingPiece = selectedPlayingPiece;
    }
}
