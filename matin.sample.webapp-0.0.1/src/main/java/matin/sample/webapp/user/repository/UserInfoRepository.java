package matin.sample.webapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matin.sample.webapp.user.dto.UserInfo;

/**
 * 사용자 정보 repository
 *
 * @author matin
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
