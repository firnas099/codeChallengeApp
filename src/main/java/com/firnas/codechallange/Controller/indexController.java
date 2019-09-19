package com.firnas.codechallange.Controller;

import com.firnas.codechallange.Repo.OrgRepo;
import com.firnas.codechallange.Repo.ticketRepo;
import com.firnas.codechallange.Userrepo;
import com.firnas.codechallange.model.Organizations;
import com.firnas.codechallange.model.Tickets;
import com.firnas.codechallange.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.CustomSecurityManagerAckMessage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@RestController
public class indexController {
    @Autowired
    Userrepo userrepo;


    @Autowired
    ticketRepo ticketRepo;

    @Autowired
    OrgRepo orgRepo;

    @RequestMapping("/t")
    public Optional<Users> getAllUsers(@RequestParam("_id") String _id){
        return userrepo.findById(_id);
    }

    @RequestMapping("/all")
    public List<Users> findAllUsr(){

        return userrepo.findAll();
    }
    @RequestMapping("/one")
    public List<Users> getOne(@RequestParam String value, String text, HttpServletResponse response) throws IOException {

        String txt=text;
        String vl=value;

        System.out.println(value);
        System.out.println(txt);

        if (txt.equals("_id")){

            String _id=vl;
            if (userrepo.findAllById(_id).isEmpty()){

            }else

          return  userrepo.findAllById(_id);


        }

           else if (txt.equals("name")){
              String name=value;

              if (userrepo.findOneByName(name).isEmpty()){

              }else
             return   userrepo.findOneByName(name);

            }
            else if (text.equals("external_id")){
               String external_id=value;
               if (userrepo.findOneByexternal_id(external_id).isEmpty()){

               }else
              return userrepo.findOneByexternal_id(external_id);


        }

        else if (text.equals("created_at")){
            String created_at=value;
            if (userrepo.findOneByecreated_at(created_at).isEmpty()){

            }else

           return (List<Users>) userrepo.findOneByecreated_at(created_at);



        }

        else if (text.equals("alias")){

            String alias=value;

            if (userrepo.findOneByalias(alias).isEmpty()){

            }else

           return (List<Users>) userrepo.findOneByalias(alias);
        }

        else if (text.equals("searching term")){

            String other=value;
            if (userrepo.findAllOther(other).isEmpty()){

            }else

            return userrepo.findAllOther(other);



        }

         PrintWriter out=response.getWriter();
        out.println("invelid Input");

              return  null;



    }


   @RequestMapping("/getticket")
    public  List<Tickets> getTickets(@RequestParam String value,String text,HttpServletResponse response) throws IOException {
       String other = value;
if (text.equals("searching term")) {
    if (ticketRepo.findAllBy_other(other).isEmpty()){

    }
    else {


        return ticketRepo.findAllBy_other(other);
    }
}
else if (text.equals("_id")){
String _id=value;

     if (ticketRepo.findAllBy_id(_id).isEmpty()){

     }
   else
   return ticketRepo.findAllBy_id(_id);

}

   else if (text.equals("external_id")){

      String external_id=value;
      if (ticketRepo.findByexternal_id(external_id).isEmpty()){


      }else
      return ticketRepo.findByexternal_id(external_id);
}
      else if (text.equals("submitter_id")){
    String submitter_id=value;
       if (ticketRepo.findBysubmitter_id(submitter_id).isEmpty()){

       }
           else

       return ticketRepo.findBysubmitter_id(submitter_id);
}
     else if (text.equals("organization_id")){
    String organization_id=value;
          if (ticketRepo.findByorganization_id(organization_id).isEmpty()){

          }

         else
          return ticketRepo.findByorganization_id(organization_id);
}
       else if (text.equals("type")){
         String type=value;

         if (ticketRepo.findBytype(type).isEmpty()){

         }else
       return   ticketRepo.findBytype(type);


}

       PrintWriter out=response.getWriter();
       out.println("Invelid Input");
       return null;
   }



    @RequestMapping("/getorg")
    @ResponseBody
    public List<Organizations> getOrg(@RequestParam String value, String text, HttpServletResponse response) throws IOException {
        String other=value;

        if (text.equals("searching term")) {
            if (orgRepo.findAllBy_id(other).isEmpty()){

            }
           else {

                return orgRepo.findAllBy_id(other);
            }
        }

        else if (text.equals("_id")){
            String _id=value;
            if (orgRepo.findbyId(_id).isEmpty()) {
                PrintWriter out=response.getWriter();

                out.println("invalid ID !");


            }else {
                return orgRepo.findbyId(_id);
            }

        }
        else if (text.equals("name")){
            String name=value;
            if (orgRepo.findbyName(name).isEmpty()){

            }

              else {

                return orgRepo.findbyName(name);
            }

        }
        else if (text.equals("external_id")){
            String external_id=value;
            if (orgRepo.findbyexternal_id(external_id).isEmpty()){

            }
              else {

                return orgRepo.findbyexternal_id(external_id);
            }
        }
        PrintWriter out=response.getWriter();
        out.println("invalid Input");


        return null;
    }

    @RequestMapping("/searchblefile")
    public List<Users> Searcble(HttpServletResponse response) throws IOException {




        return  userrepo.findAll();
    }
}
