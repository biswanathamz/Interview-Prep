package Services.Impl;

import Services.AccountTypeService;

import java.util.Objects;

public class AccountTypeServiceImpl implements AccountTypeService {
    @Override
    public boolean accountTypeCheck(String type) {
        return Objects.equals(type, "indian");
    }
}
