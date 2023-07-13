package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.UserAuth;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long>{

	@Query(nativeQuery=true,value="select count(id) from soch.user_auth where is_delete = false and lower(username)=lower(:username)")
	int existsByUsernameIgnoreCase(@Param("username")String username);

	@Query(nativeQuery=true,value="select * from soch.user_auth where user_id=:userId")
	UserAuth findByUserMaster(@Param("userId") Long userId);

	@Query(nativeQuery=true,value="select * from soch.user_auth where user_id=:userId")
	UserAuth findUserAuthByUserId(@Param("userId") Long userId);
	
	/* 'NO LOAD BALANCE' should not be removed as this query should be executed in master DB node to get the latest saved token for the user, to avoid 401 exception. */
	@Query(nativeQuery=true,value="/*NO LOAD BALANCE*/ select active_token from soch.user_auth where user_id=:userId")
	String findActiveTokenByUserId(@Param("userId") Long userId);
	//@Query(nativeQuery=true,value="select active_token from soch.user_auth where user_id=:userId")
	//String findActiveTokenByUserId(@Param("userId") Long userId);
}
