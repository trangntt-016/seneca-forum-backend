package com.seneca.senecaforum;

import com.seneca.senecaforum.domain.ui.SidebarMenu;
import com.seneca.senecaforum.domain.ui.Topic;
import com.seneca.senecaforum.repository.SidebarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SenecaForumApplicationTests {

    @Autowired
    private SidebarRepository sidebarRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveSidebarAndTopics(){
        SidebarMenu sidebarMenu = new SidebarMenu();
        sidebarMenu.setName("Forum");
        Topic topic = Topic.builder().topicName("Assignment Help").build();
        Set<Topic> topics = new HashSet<>();
        topics.add(topic);
        sidebarMenu.setTopics(topics);
        sidebarRepository.save(sidebarMenu);
    }

    @Test
    void testUpdateSidebar(){
        SidebarMenu sidebarMenu = sidebarRepository.findById(5).orElseThrow();
//        sidebarMenu.setName("new Name");
//        sidebarRepository.save(sidebarMenu);
        System.out.println(sidebarMenu.getTopics().size());
    }

    @Test
    void testDeleteTopic(){
        Optional<SidebarMenu> side = sidebarRepository.findById(5);
        if (side.isPresent()){
            SidebarMenu sidebarMenu = side.get();
            sidebarMenu.getTopics().remove("Assignment Help");
        }
        List<Integer> a = Arrays.asList(1,2,3,4,5);

    }



}
