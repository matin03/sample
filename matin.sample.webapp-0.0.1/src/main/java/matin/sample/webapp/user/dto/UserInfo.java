package matin.sample.webapp.user.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 사용자 정보
 * @author matin
 *
 */
@Entity
@Table(name = "user_info_tbl")
public class UserInfo {

	/** 사용자 아이디 */
	@Id
	@Column(name = "user_id", length = 100)
	private String userId;

	/** 사용자 명 */
	@Column(name = "user_nm", length = 100)
	private String name;

	/**
	 * @return 사용자 아이디
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            사용자 아이디
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * @return 사용자 명
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            사용자 명
	 */
	public void setName(final String name) {
		this.name = name;
	}

}
