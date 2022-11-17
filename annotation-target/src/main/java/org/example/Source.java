package org.example;

import lombok.Data;

@Data
public class Source {

	@TransferSender
	private String name1;

	@TransferSender
	private String name2;
}
