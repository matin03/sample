package matin.sample.webapp.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 전역 예외 처리.
 */
@ControllerAdvice
@RestController
public class ExceptionHandlingController {

	/** log handle */
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

	/**
	 * 공통 예외 처리.
	 *
	 * @param request
	 *            servletRequest
	 * @param exception
	 *            전달 받은 예외 객체
	 * @return 예외 처리 페이지
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(final HttpServletRequest request, final Exception exception) {

		ModelAndView mnv = new ModelAndView("/error/error");

		StringBuilder err = new StringBuilder();
		String errorUrl = request.getRequestURL().toString();
		err.append("==============================================================\n");
		err.append("url : ").append(errorUrl).append("\n");
		err.append("message : ").append(exception.getMessage()).append("\n");
		err.append(ExceptionUtils.getStackTrace(exception));
		err.append("==============================================================\n");
		logger.error("Application 오류 발생\n {}", err);

		mnv.addObject("exception", exception.getMessage());
		mnv.addObject("exceptionDetail", ExceptionUtils.getStackTrace(exception));
		mnv.addObject("url", errorUrl);

		return mnv;
	}

}
