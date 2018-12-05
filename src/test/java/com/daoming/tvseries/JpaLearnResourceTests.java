package com.daoming.tvseries;

import com.daoming.utils.LogUtils;
import com.daoming.web.dao.LearnDaoUseJpa;
import com.daoming.web.domain.LearnResourceUseJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpaLearnResourceTests {

    @Autowired
    LearnDaoUseJpa learnDaoUseJpa;

    @Test
    public void test() throws Exception{
        learnDaoUseJpa.save(new LearnResourceUseJpa(110l, "jason", "title"+System.currentTimeMillis(), "http://www.baidu.com"+System.currentTimeMillis(),"temp"));
        List<LearnResourceUseJpa> jason = learnDaoUseJpa.findByAuthor("jason");
        for (LearnResourceUseJpa learnResourceUseJpa : jason) {
            LogUtils.d("find the resource is " + learnResourceUseJpa.getAuthor() + ",id = " + learnResourceUseJpa.getId());
        }

        Pageable pageable = new PageRequest(0, 100, new Sort(Sort.Direction.DESC,"id"));
        Page<LearnResourceUseJpa> page = learnDaoUseJpa.findAll(pageable);
        page.iterator().forEachRemaining(new Consumer<LearnResourceUseJpa>() {
            @Override
            public void accept(LearnResourceUseJpa learnResourceUseJpa) {
                LogUtils.d("findAll " + learnResourceUseJpa.getId());
            }
        });
    }
}
