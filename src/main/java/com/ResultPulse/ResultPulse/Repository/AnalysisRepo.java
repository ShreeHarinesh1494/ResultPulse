package com.ResultPulse.ResultPulse.Repository;

import com.ResultPulse.ResultPulse.Model.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepo extends JpaRepository<Analysis, Integer>
{

}
