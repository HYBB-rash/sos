package com.suep.sos.Service.Implementation;

import com.suep.sos.Dao.CustomerDao;
import com.suep.sos.Entity.Customer;
import com.suep.sos.Entity.CustomerId;
import com.suep.sos.Entity.Vue.VueCustomer;
import com.suep.sos.Entity.Vue.VueProfile;
import com.suep.sos.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerDao customerDao;


    @Override
    public VueCustomer getProfile(Integer id) {
        Customer customer = customerDao.getByUserId(id);
        return customer == null ? null : createVueCustomer(customer);
    }

    public VueCustomer createVueCustomer (Customer customer) {
        VueCustomer target = new VueCustomer();
        target.setAddress(customer.getAddress());
        target.setCompany(customer.getCompany());
        target.setSex(customer.getSex());
        target.setPhone(customer.getPhone());
        target.setName(customer.getName());
        return target;
    }

    @Override
    public void saveProfile(VueProfile profile) {
        CustomerId id = customerDao.findByUserId(profile.getId());
        Customer customer = createCustomer(profile);
        if (id != null) {
            customer.setId(Math.toIntExact(id.getId()));
        }
        customerDao.save(customer);
    }

    public Customer createCustomer (VueProfile profile) {
        Customer target = new Customer();
        VueCustomer customer = profile.getCustomer();
        target.setUserId(profile.getId());
        target.setAddress(customer.getAddress());
        target.setCompany(customer.getCompany());
        target.setName(customer.getName());
        target.setPhone(customer.getPhone());
        target.setSex(customer.getSex());
        return target;
    }
}
