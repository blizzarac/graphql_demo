package com.stolz.alexander.GraphQlDemo.resolver.bank;

import com.stolz.alexander.GraphQlDemo.domain.bank.BankAccount;
import com.stolz.alexander.GraphQlDemo.domain.bank.Client;
import com.stolz.alexander.GraphQlDemo.exceptions.GraphQlExceptionHandler;
import graphql.GraphQLException;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class ClientResolver implements GraphQLResolver<BankAccount> {

	private Executor executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
	);

	public CompletableFuture<DataFetcherResult<Client>> client(BankAccount bankAccount) {
		return CompletableFuture.supplyAsync(
				() -> {
					log.info("Requesting client data for bank account id: {}", bankAccount.getId());

					var result = DataFetcherResult.<Client>newResult();

					try {
						result.data(Client.builder().id(UUID.randomUUID()).firstName("Alex").lastName("Stolz").build());
					} catch (Exception e) {
						result.error(new GenericGraphQLError("Could not fetch Client data"));
					}

					return result.build();
				}
		, executorService);
	}
}
