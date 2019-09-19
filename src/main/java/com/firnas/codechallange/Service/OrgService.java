package com.firnas.codechallange.Service;

import com.firnas.codechallange.Repo.OrgRepo;
import com.firnas.codechallange.model.Organizations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgService {
    @Autowired
    OrgRepo orgRepo;


    public  Iterable<Organizations> save(List<Organizations> organizations){

        return orgRepo.saveAll(organizations);


    }


    public  Organizations save(Organizations organizations
    ){


        return orgRepo.save(organizations);
    }


}
