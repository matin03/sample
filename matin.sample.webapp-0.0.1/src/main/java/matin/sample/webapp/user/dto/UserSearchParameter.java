package matin.sample.webapp.user.dto;


/**
 * 사용자 검색 관련 전달인자
 * @author matin
 *
 */
public class UserSearchParameter {


	/**
	 * 사용자 ID
	 */
	private String userId;

	/**
	 * 사용자명
	 */
	private String userName;

	/**
	 * 검색 keyword
	 */
	private String keyword;

	/**
	 * @return 사용자 ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId 사용자 ID
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * @return 사용자명
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 사용자명
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * @return 검색 keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword 검색 keyword
	 */
	public void setKeyword(final String keyword) {
		this.keyword = keyword;
	}






}
