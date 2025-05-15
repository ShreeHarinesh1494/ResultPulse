package com.ResultPulse.ResultPulse.Repository;

import com.ResultPulse.ResultPulse.Model.Sem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface SemRepo extends CrudRepository<Sem, Integer>
{
    boolean existsBySemnameIgnoreCase(String semname);
}
