package com.firnas.codechallange;

import com.firnas.codechallange.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Userrepo extends JpaRepository <Users,String>{

    @Query(value = "SELECT * FROM Users WHERE name like %:name%",nativeQuery = true)
   List<Users> findOneByName(@Param("name") String name);

   // @Query(value = "SELECT * FROM LECTURE WHERE Username=?1",nativeQuery = true)
   // Lecture findbylog(String Username);

   @Query(value = "SELECT * FROM Users WHERE external_id like %:external_id%",nativeQuery = true)
   List<Users> findOneByexternal_id(@Param("external_id") String external_id);

    @Query(value = "SELECT * FROM Users WHERE url LIKE %:url%",nativeQuery = true)
    Users findOneByUrl(@Param("url") String url);

    @Query(value = "SELECT * FROM Users WHERE alias like %:alias%",nativeQuery = true)
    List<Users> findOneByalias(@Param("alias") String alias);


    @Query(value = "SELECT * FROM Users WHERE created_at like %:created_at%",nativeQuery = true)
    List<Users> findOneByecreated_at(@Param("created_at") String created_at);

    @Query(value = "SELECT * FROM Users WHERE _id =?1",nativeQuery = true)
    List<Users> findAllById( String _id);


    @Query(value = "SELECT * FROM Users WHERE locale like %:other% OR timezone LIKE %:other% OR last_login_at LIKE %:other% " +
            "OR email LIKE %:other% OR phone LIKE %:other% OR signature LIKE %:other%" +
            " OR organization_id LIKE %:other% OR role LIKE %:other% OR name LIKE %:other%" ,nativeQuery = true)
    List<Users> findAllOther(@Param("other") String other);




}
