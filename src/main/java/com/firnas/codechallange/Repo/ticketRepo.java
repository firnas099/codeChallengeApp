package com.firnas.codechallange.Repo;

import com.firnas.codechallange.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ticketRepo  extends JpaRepository<Tickets,String> {




    @Query(value = "select * from Tickets  where  _id like %:other% OR external_id LIKE %:other% OR status LIKE %:other% OR url LIKE %:other% OR created_at LIKE %:other% OR subject LIKE %:other% OR" +
            " description LIKE %:other% OR priority LIKE %:other% OR  submitter_id LIKE %:other% OR organization_id LIKE %:other%"  ,nativeQuery = true)
    List<Tickets> findAllBy_other(@Param("other") String other);


    @Query(value = "select  * from  Tickets where _id LIKE %:_id%",nativeQuery = true)
    List<Tickets> findAllBy_id(@Param("_id") String _id);


    @Query(value = "select  * from  Tickets where external_id LIKE %:external_id%",nativeQuery = true)
    List<Tickets> findByexternal_id(@Param("external_id") String external_id);

    @Query(value = "select  * from  Tickets where submitter_id LIKE %:submitter_id%",nativeQuery = true)
    List<Tickets> findBysubmitter_id(@Param("submitter_id") String submitter_id);

    @Query(value = "select  * from  Tickets where organization_id LIKE %:organization_id%",nativeQuery = true)
    List<Tickets> findByorganization_id(@Param("organization_id") String organization_id);

    @Query(value = "select  * from  Tickets where type LIKE %:type%",nativeQuery = true)
    List<Tickets> findBytype(@Param("type") String type);
}
