package com.ResultPulse.ResultPulse.Repository;


import com.ResultPulse.ResultPulse.Model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepo extends CrudRepository<Topic, Integer>
{

    Topic findByTopicname(String topicname);
}
