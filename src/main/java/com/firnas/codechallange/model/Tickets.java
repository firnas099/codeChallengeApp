package com.firnas.codechallange.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Tickets {

    @Id
    private String _id;
    private String url;
    private String external_id;
    private String created_at;
    private String type;
    private String subject;
    private String description;
     private String priority;
    private  String status;
    private  String submitter_id;
    private String assignee_id;
    private  String organization_id;

    @ElementCollection
    private List<String> tags;
    private  String has_incidents;
    private  String due_at;
    private String via;



}
