package com.stolz.alexander.GraphQlDemo.resolver.bank;

import com.stolz.alexander.GraphQlDemo.domain.bank.BankAccount;
import com.stolz.alexander.GraphQlDemo.domain.bank.Client;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ClientResolver implements GraphQLResolver<BankAccount> {

	public Client client(BankAccount bankAccount) {
		log.info("Requesting client data for bank account id: {}", bankAccount.getId());

		return Client.builder().id(UUID.randomUUID()).firstName("Alex").lastName("Stolz").build();
	}
}
