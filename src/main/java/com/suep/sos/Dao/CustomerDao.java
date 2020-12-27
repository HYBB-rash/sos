package com.suep.sos.Dao;

import com.suep.sos.Entity.Customer;
import com.suep.sos.Entity.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    CustomerId findByUserId (int userid);
    Customer getByUserId (int userid);

}
