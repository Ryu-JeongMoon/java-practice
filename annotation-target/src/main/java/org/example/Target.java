package org.example;

import lombok.Data;

@Data
@TransferReceiver(Source.class)
public class Target {

	private String name1;

	private String name2;
}
