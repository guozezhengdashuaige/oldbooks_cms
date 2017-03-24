package cn.cuilan.oldbooks.service;

import java.util.List;

import cn.cuilan.oldbooks.domain.Demo;

public interface DemoService {

	void add(Demo demo);

	List<Demo> getDemo(Demo demo);

}
