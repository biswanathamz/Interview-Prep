package Services.Impl;

import Services.AmountService;

public class AmountServiceImpl implements AmountService {
    public static int amountLimit = 5000;
    @Override
    public boolean checkAmount(double amount) {
        return (amount<=amountLimit);
    }
}
