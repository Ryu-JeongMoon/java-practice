package org.designpattern.structure.adapter._03_java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hi";
	}

}
