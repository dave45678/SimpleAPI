package me.afua.simpleapi;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MainController {

    private AtomicLong theId;
    ArrayList<DataClass> allData = new ArrayList<>();

    @RequestMapping("/")
    public @ResponseBody String showMe()
    {
        return "This is the main page.";
    }

    @RequestMapping("/admin")
    public @ResponseBody String showAdmin()
    {
        return "This is the admin page";
    }

    @RequestMapping("/moredata")
    public @ResponseBody String showData()
    {
        DataClass moredata = new DataClass();
        long thisAtomicLong;
        moredata.setId(new AtomicLong().get());
        moredata.setData("Another item "+RandomStringUtils.randomAlphabetic(3));
        allData.add(moredata);
        return "Data has been added";
    }

    @RequestMapping("/showdata")
    public @ResponseBody  ArrayList<DataClass> showAllData()
    {
       return allData;
    }
}
