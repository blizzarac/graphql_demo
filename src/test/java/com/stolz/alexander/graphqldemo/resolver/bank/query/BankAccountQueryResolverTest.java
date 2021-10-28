package com.stolz.alexander.graphqldemo.resolver.bank.query;

import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.stolz.alexander.GraphQlDemo.GraphQlDemoApplication;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = GraphQlDemoApplication.class)
class BankAccountQueryResolverTest {

	@Autowired
	GraphQLTestTemplate graphQLTestTemplate;

	final static String TESTFILE_LOCATION_REQUEST = "graphqlResolver/query/request/%s.graphql";
	final static String TESTFILE_LOCATION_RESPONSE = "graphqlResolver/query/response/%s.json";

	@Nested
	class queries {
		@Test
		@DisplayName("should return bank accounts")
		void test1() throws IOException, URISyntaxException, JSONException {
			// given
			var testFile = "bank_account_test_file1";

			// when
			var response = graphQLTestTemplate.postForResource(String.format(TESTFILE_LOCATION_REQUEST, testFile));

			// then
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			var expectedResponseBody = read(String.format(TESTFILE_LOCATION_RESPONSE, testFile));
			assertEquals(expectedResponseBody, response.getRawResponse().getBody(),true);
		}
	}

	private String read(String location) throws URISyntaxException, IOException {
		var path = Paths.get(getClass().getClassLoader()
				.getResource(location).toURI());
		return Files.lines(path).collect(Collectors.joining("\n"));
	}
}
