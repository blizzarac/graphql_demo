package com.stolz.alexander.GraphQlDemo.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class Client {
	UUID id;
	String firstName;
	List<String> middleNames;
	String lastName;

}
