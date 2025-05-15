package com.ResultPulse.ResultPulse.Repository;


import com.ResultPulse.ResultPulse.Model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Integer>
{

    Admin findByEmail(String email);
}
