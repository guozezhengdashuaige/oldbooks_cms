package cn.cuilan.oldbooks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cuilan.oldbooks.dao.DemoMapper;
import cn.cuilan.oldbooks.domain.Demo;
import cn.cuilan.oldbooks.service.DemoService;

@Service("demoService")
// @Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoMapper demoMapper;

	/**
	 * 添加
	 */
	@Override
	public void add(Demo demo) {
		demoMapper.add(demo);
	}

	/**
	 * 查询
	 * 
	 * @param demo
	 * @return
	 */
	@Override
	public List<Demo> getDemo(Demo demo) {
		return demoMapper.getDemo(demo);
	}

}
