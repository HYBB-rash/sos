package com.suep.sos.Controller;

import com.suep.sos.Entity.Vue.PostId;
import com.suep.sos.Entity.Vue.VueCustomer;
import com.suep.sos.Entity.Vue.VueProfile;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/profile/update")
    public Result updateProfile(@RequestBody VueProfile profile) {
        System.out.println(profile);
        customerService.saveProfile(profile);
        return ResultFactory.buildSuccessResult(profile);
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/profile")
    public Result getProfile(@RequestBody PostId id) {
        System.out.println(id.getId());
        VueCustomer profile = customerService.getProfile(id.getId());
        return ResultFactory.buildSuccessResult(profile);
    }
}
