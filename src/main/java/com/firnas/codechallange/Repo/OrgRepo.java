package com.firnas.codechallange.Repo;

import com.firnas.codechallange.model.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrgRepo extends JpaRepository<Organizations,String> {


    @Query(value = "select * from  Organizations where  _id like %:other% OR url LIKE %:other% OR external_id LIKE %:other% OR name LIKE %:other% OR created_at LIKE %:other% OR details LIKE %:other% " ,nativeQuery = true)
    List<Organizations> findAllBy_id(@Param("other") String other);

    @Query(value = "select * from  Organizations  where _id like %:_id%",nativeQuery = true)
   List<Organizations>  findbyId(@Param("_id") String _id);

    @Query(value = "select * from  Organizations  where name like %:name%",nativeQuery = true)
    List<Organizations>  findbyName(@Param("name") String name);


    @Query(value = "select * from  Organizations  where external_id like %:external_id%",nativeQuery = true)
    List<Organizations>  findbyexternal_id(@Param("external_id") String external_id);


}
