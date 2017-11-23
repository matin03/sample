package matin.sample.webapp.index.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matin.sample.webapp.index.dto.SystemInfomation;

/**
 * 기본 rest 정보를 보내주는 controller
 *
 * @author matin
 */
@RestController
public class IndexRestController {

	/**
	 * 시스템 정보 조회
	 *
	 * @return 시스템 정보
	 */
	@RequestMapping(value = "/getSystemInfo")
	public SystemInfomation getSystemInfo() {
		return new SystemInfomation();
	}

	/**
	 * 버젼 정보를 가져온다
	 *
	 * @return 시스템의 버젼 정보
	 */
	@RequestMapping(value = "/getVersion")
	public String getVerson() {
		return "1.0.0.1";
	}

	/**
	 * 시스템 이름을 가져온다
	 *
	 * @return 시스템의 이름
	 */
	@RequestMapping(value = "/getName")
	public String getName() {
		return "The matin Sample Web Application";
	}

}
