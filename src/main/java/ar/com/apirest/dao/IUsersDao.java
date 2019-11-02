/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.dao;

import ar.com.apirest.entities.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorge
 */
@Repository
public interface IUsersDao extends JpaRepository<Users, Integer> {

    @Query("from users us where us.User like :user and us.Pass like :pass")
    public List<Users> findUserPass(@Param("user") String user,
                                    @Param("pass") String pass
                                    );

}
