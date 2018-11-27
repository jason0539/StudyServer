package com.daoming.tvseries;

import com.daoming.utils.LogUtils;
import com.daoming.web.dao.LearnDaoUseJpa;
import com.daoming.web.domain.LearnResourceUseJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpaLearnResourceTests {

    @Autowired
    LearnDaoUseJpa learnDaoUseJpa;

    @Test
    public void test() throws Exception{
        learnDaoUseJpa.save(new LearnResourceUseJpa(110l, "jason", "title"+System.currentTimeMillis(), "http://www.baidu.com"+System.currentTimeMillis()));
        List<LearnResourceUseJpa> jason = learnDaoUseJpa.findByAuthor("jason");
        for (LearnResourceUseJpa learnResourceUseJpa : jason) {
            LogUtils.d("find the resource is " + learnResourceUseJpa.getAuthor() + ",id = " + learnResourceUseJpa.getId());
        }
    }
}
