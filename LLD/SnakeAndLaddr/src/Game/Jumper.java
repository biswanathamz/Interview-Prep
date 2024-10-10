package Game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jumper {
    private int startPoint;
    private int endPoint;

    public Jumper(int startPoint, int endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
