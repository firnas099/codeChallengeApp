package com.firnas.codechallange.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Organizations {

@Id
private  String _id;
private  String url;
private  String external_id;
private  String name;

@ElementCollection
private List<String>domain_names;


private  String created_at;
private  String details;
private  Boolean shared_tickets;

@ElementCollection
private List<String>tags;





}
