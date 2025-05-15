package com.ResultPulse.ResultPulse.Service;


import com.ResultPulse.ResultPulse.DTO.Topic.TopicDTO;
import com.ResultPulse.ResultPulse.Model.Admin;
import com.ResultPulse.ResultPulse.Model.Topic;
import com.ResultPulse.ResultPulse.Repository.AdminRepo;
import com.ResultPulse.ResultPulse.Repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class TopicService
{
    @Autowired
    private TopicRepo tr;

    @Autowired
    private AdminRepo ar;

    @PostMapping("/creation")
    public String creation(@RequestBody TopicDTO topicDTO) {
        if (topicDTO.getTopicname() == null || topicDTO.getTopicname().trim().isEmpty()) {
            return "Topic name cannot be empty";
        }

        Topic existingTopic = tr.findByTopicname(topicDTO.getTopicname());
        if (existingTopic != null) {
            return "Topic Already Exists";
        }

        Admin admin = ar.findById(topicDTO.getAdminid())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        Topic topic = new Topic();
        topic.setTopicname(topicDTO.getTopicname());
        topic.setCreatedby(admin);
        topic.setCreationdate(LocalDateTime.now());

        tr.save(topic);
        return "Topic Created";
    }

    public List<Topic> getall() {
        List<Topic> topics = (List<Topic>) tr.findAll();
        if (topics.isEmpty()) {
            return Collections.emptyList();
        }
        return topics;
    }

    public Topic getbytopicid(int topicid) {
        return tr.findById(topicid).orElse(null);
    }

    public String updatetopic(int topicid, TopicDTO topicdto) {
        Topic topic = tr.findById(topicid).orElse(null);
        if (topic == null)
            return "Topic Not Found";

        Admin admin = ar.findById(topicdto.getAdminid()).orElse(null);
        if (admin == null)
            return "Admin Not Found";

        topic.setTopicname(topicdto.getTopicname());
        topic.setCreatedby(admin); // set new admin

        tr.save(topic);
        return "Topic Updated";
    }

    public String deletetopic(int topicid) {
        Topic topic = tr.findById(topicid).orElse(null);
        if (topic == null)
            return "Topic Not Found";

        tr.delete(topic);
        return "Topic Deleted";
    }
}
