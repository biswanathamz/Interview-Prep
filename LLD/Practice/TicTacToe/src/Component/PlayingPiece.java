package Component;

import Enums.PieceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayingPiece {
    private PieceType pieceType;
    public PlayingPiece(PieceType pieceType){
        this.pieceType = pieceType;
    }
}
