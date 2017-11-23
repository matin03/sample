package matin.sample.webapp.index.dto;

/**
 * 시스템 정보를 가진다
 *
 * @author matin
 *
 */
public class SystemInfomation {

	/** 시스템 명 */
	private String name;

	/** 버젼 */
	private String version;

	/** 시스템 총 이름 */
	private String fullName;

	/**
	 * 기본생성자
	 */
	public SystemInfomation() {
		super();

		this.name = "MSWApp";
		this.version = "0.0.1";
		this.fullName = "Matin Sample Web Application";
	}

	/**
	 * 생성자
	 *
	 * @param name 시스템 약어 이름
	 * @param version 버젼
	 * @param fullName 전체 이름
	 */
	public SystemInfomation(final String name, final  String version,  final String fullName) {
		super();
		this.name = name;
		this.version = version;
		this.fullName = fullName;
	}

	/**
	 * @return 시스템 약칭
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return 시스템 버젼
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

}
