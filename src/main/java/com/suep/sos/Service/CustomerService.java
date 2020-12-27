package com.suep.sos.Service;

import com.suep.sos.Entity.Vue.VueCustomer;
import com.suep.sos.Entity.Vue.VueProfile;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public VueCustomer getProfile (Integer id);
    public void saveProfile(VueProfile profile);
}
