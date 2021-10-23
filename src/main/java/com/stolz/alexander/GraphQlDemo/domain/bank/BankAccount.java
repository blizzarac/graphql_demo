package com.stolz.alexander.GraphQlDemo.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class BankAccount {
	UUID id;
	Client client;
	Currency currency;
}
