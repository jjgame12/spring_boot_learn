package com.example.demo;

import com.example.demo.mapper.JobsMapper;
import com.example.demo.mapper.NewusersMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;
import com.example.demo.service.ConfigurationPropertiesService;
import com.example.demo.service.II;
import com.example.demo.service.ValueAnnotationListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Autowired
	private II ii;

	@Resource
	private JobsMapper jobsMapper;

	@Resource
	private UserMapper userMapper;

	@Resource
	private NewusersMapper newusersMapper;

	@Resource
	private ConfigurationPropertiesService propertiesService;

	@Resource
	private ValueAnnotationListService valueAnnotationListService;

	@Test
	public void testList() {
	    System.out.println(valueAnnotationListService.getAddresses());
	}

	@Test
    public void testProperties() {
		System.out.println(propertiesService.getAddress());
	}


	@Test
	public void test1() {
		System.out.println("test ii is " + II.i);
	}

	@Test
	public void testSqlExample() {
		JobsExample example = new JobsExample();
		JobsExample.Criteria criteria = example.createCriteria();
		List<Jobs> jobsList = jobsMapper.selectByExample(example);
		jobsList.forEach(job -> {
			System.out.println(job.getId());
			System.out.println(job.getJobName());
			System.out.println(job.getDescription());
		});
	}

	@Test
	public void testInsert() {
		Newusers user = new Newusers(null, "222", "MAN");
		int index = newusersMapper.insert(user);
		System.out.println(index);
	}

	@Autowired
	private User user;

	@Autowired
	private HigherUser higherUser;

	@Test
	public void testConfiguration() {
		System.out.println("user name: " + user.getUserName());
		System.out.println("higher user name: " + higherUser.getUser().getUserName());
        System.out.println("user is the same : " + (user == higherUser.getUser()));
	}

}


