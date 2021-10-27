package com.stolz.alexander.GraphQlDemo.resolver.bank.mutations;

import com.stolz.alexander.GraphQlDemo.domain.bank.BankAccount;
import com.stolz.alexander.GraphQlDemo.domain.bank.Currency;
import com.stolz.alexander.GraphQlDemo.domain.bank.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {

	public BankAccount createBankAccount(CreateBankAccountInput input, DataFetchingEnvironment env) {
		log.debug("Creating new BankAccount base for: {}", input );

		return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.EUR).build();
	}
}
