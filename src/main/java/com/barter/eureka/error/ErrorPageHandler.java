package com.barter.eureka.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ErrorPageHandler implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		
		if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
			// 401 error
			return "error401.html";
		} else if (statusCode == HttpStatus.SC_NOT_FOUND) {
			// 404 error
			return "error404.html";
		} else if (statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
			// 500 error
			return "error500.html";
		} else {
			// other errors
			return "error.html";
		}
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
