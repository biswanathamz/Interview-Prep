package Services.Impl;

import Services.AccountTypeService;
import Services.AmountService;
import Services.Transaction;

public class TransactionImpl implements Transaction {
    AccountTypeService accountTypeService = new AccountTypeServiceImpl();
    AmountService amountService = new AmountServiceImpl();
    @Override
    public void sendMoney(String type, double amount) {
        if(accountTypeService.accountTypeCheck(type)){
            if(amountService.checkAmount(amount)){
                System.out.println(amount+" is sent");
                return;
            }
        }
        System.out.println("Transaction Failed!");
    }
}
