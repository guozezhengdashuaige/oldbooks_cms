package cn.cuilan.oldbooks.ssm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.cuilan.oldbooks.controller.DemoController;
import cn.cuilan.oldbooks.domain.Demo;
import cn.cuilan.oldbooks.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class) // 使用Springtest框架
@ContextConfiguration(locations = "classpath:spring/*.xml") // 加载配置
public class SSMTest {

	/** 注入测试服务层 */
	@Resource
	private DemoService demoService;

	@Resource
	private DemoController demoController;

	/**
	 * 测试SpringIoC
	 */
	@SuppressWarnings("resource")
	@Test
	public void testSpringIoC() {
		// 获取Spring上下文配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-*.xml");
		// 获取Spring加载配置文件PropertyPlaceholderConfigurer对象
		PropertyPlaceholderConfigurer configurer = (PropertyPlaceholderConfigurer) context
				.getBean("propertyConfigurer");
		System.out.println("propertyConfigurer" + configurer);
		// 获取数据源
		BasicDataSource dataSource = (BasicDataSource) context.getBean("dataSource");
		System.out.println("driveClassName:" + dataSource.getDriverClassName());
		System.out.println("url:" + dataSource.getUrl());
	}

	/**
	 * Spring MyBatis整合
	 */
	@Test
	public void testSpringMyBatis() {
		List<Demo> demo = demoService.getDemo(new Demo("张岩"));
		System.out.println(demo.toString());
	}

}
