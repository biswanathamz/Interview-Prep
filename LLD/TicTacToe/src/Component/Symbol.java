package Component;

import Enums.SymbolEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {
    private SymbolEnums symbol;
    public Symbol(SymbolEnums symbol){
        this.symbol = symbol;
    }
}
