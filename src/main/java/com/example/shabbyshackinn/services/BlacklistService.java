package com.example.shabbyshackinn.services;

import com.example.shabbyshackinn.dtos.DetailedBlackListedCustomerDto;
import com.example.shabbyshackinn.models.BlackListedCustomer;
import com.example.shabbyshackinn.models.BlacklistResponse;

import java.io.IOException;
import java.util.List;

public interface BlacklistService {

    void addBlackListedCustomer(BlackListedCustomer customer);

    BlacklistResponse checkIfEmailIsBlacklisted(String email);

    void updateBlacklistedCustomer(BlackListedCustomer blackListedCustomer);

    List<BlackListedCustomer> getBlacklistedCustomersFromAPI();

    DetailedBlackListedCustomerDto blackListedCustomerToDetailedBlackListedCustomerDto(BlackListedCustomer blackListedCustomer);

    BlackListedCustomer DetailedBlackListedCustomerDtoToBlackListedCustomer(DetailedBlackListedCustomerDto detailedBlackListedCustomerDto);
}
