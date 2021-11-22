package com.wyl.domain.customer.gateway;

import com.wyl.domain.customer.Customer;
import com.wyl.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
