package com.firnas.codechallange.Service;

import com.firnas.codechallange.Repo.ticketRepo;
import com.firnas.codechallange.model.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ticketService {



   private  ticketRepo ticketRepo;

   public  ticketService(ticketRepo ticketRepo){
       this.ticketRepo=ticketRepo;
   }


    public Iterable<Tickets> save(List<Tickets> tickets){

        return ticketRepo.saveAll(tickets);
    }


    public Tickets save(Tickets tickets){

        return ticketRepo.save(tickets);
    }



}
