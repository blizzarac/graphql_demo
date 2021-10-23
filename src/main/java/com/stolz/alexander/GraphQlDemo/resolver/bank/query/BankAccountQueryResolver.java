package com.stolz.alexander.GraphQlDemo.resolver.bank.query;

import com.stolz.alexander.GraphQlDemo.domain.bank.Client;
import com.stolz.alexander.GraphQlDemo.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.stolz.alexander.GraphQlDemo.domain.bank.BankAccount;

import java.util.UUID;

@Component
@Slf4j
public class BankAccountQueryResolver implements GraphQLQueryResolver {

	public BankAccount bankAccount(UUID id) {
		log.info("Retrieving Bank Account id: {}", id);

		return BankAccount.builder().id(id).currency(Currency.EUR).build();
	}
}
