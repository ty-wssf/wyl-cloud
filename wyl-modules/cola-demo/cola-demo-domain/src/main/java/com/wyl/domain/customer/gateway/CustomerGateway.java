package com.wyl.domain.customer.gateway;

import com.wyl.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
