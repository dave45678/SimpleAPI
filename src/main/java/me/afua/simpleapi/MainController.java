package me.afua.simpleapi;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MainController {

//  Making IDs automatically updated without using the database
    private AtomicLong theId = new AtomicLong();

//  Added an arraylist to store values. DON'T instantiate this way in production.
    ArrayList<DataClass> allData = new ArrayList<>();

    @RequestMapping("/")
    public @ResponseBody String showMe()
    {
//        See security configuration: permitAll() used for this
        return "This is the main page.";
    }

    @RequestMapping("/admin")
    public @ResponseBody String showAdmin()
    {
//        See security configuration - hasAuthority("ADMIN") used for this
        return "This is the admin page";
    }

    @RequestMapping("/moredata")
    public @ResponseBody String showData()
    {
//        Any authenticated user can come here
        DataClass moredata = new DataClass();
        long thisAtomicLong;
        moredata.setId(theId.incrementAndGet());
        moredata.setData("Another item "+RandomStringUtils.randomAlphabetic(3));
        allData.add(moredata);
        return "Data has been added";
    }

    @RequestMapping("/showdata")
    public @ResponseBody  ArrayList<DataClass> showAllData()
    {
//      Any authenticated user can come here
        return allData;
    }
}
