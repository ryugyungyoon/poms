package com.jg.poms.controller.base;

import com.jg.poms.core.http.HttpBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

	protected HttpBuilder httpBuilder;

	@Autowired
	public BaseController(HttpBuilder httpBuilder) {
		this.httpBuilder = httpBuilder;
	}
}
