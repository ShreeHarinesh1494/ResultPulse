package com.ResultPulse.ResultPulse.Controller;


import com.ResultPulse.ResultPulse.DTO.Topic.TopicDTO;
import com.ResultPulse.ResultPulse.Model.Topic;
import com.ResultPulse.ResultPulse.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rp/admin/topic")
public class TopicController
{
    @Autowired
    private TopicService ts;

    @PostMapping("/creation")
    public String topiccreation(@RequestBody TopicDTO topicdto)
    {
        return ts.creation(topicdto);
    }

    @GetMapping("/all")
    public List<Topic> getalltopics()
    {
        return ts.getall();
    }

    @GetMapping("/{topicid}")
    public Topic getbytopicid(@PathVariable int topicid)
    {
        return ts.getbytopicid(topicid);
    }

    @PutMapping("/{topicid}")
    public String updatetopic(@PathVariable int topicid, @RequestBody TopicDTO topicdto)
    {
        return ts.updatetopic(topicid,topicdto);
    }

    @DeleteMapping("/{topicid}")
    public String deletetopic(@PathVariable int topicid)
    {
        return ts.deletetopic(topicid);
    }
}
