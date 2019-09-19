package com.firnas.codechallange.Controller;

import com.firnas.codechallange.Userrepo;
import com.firnas.codechallange.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ManinController {

    @Autowired
     Userrepo userrepo;

    @RequestMapping("/")
    public String Home(){

        return "home";
    }

    @RequestMapping("/search")
    public String search(){

        return "search";
    }

    @RequestMapping("/userfile")
    public String userFile(){

        return "userfile";
    }

    @RequestMapping("/ticketfile")
    public String ticketFile(){

        return "ticketfile";
    }

    @RequestMapping("/orgfile")
    public String orgFile(){

        return "orgfile";
    }


}
