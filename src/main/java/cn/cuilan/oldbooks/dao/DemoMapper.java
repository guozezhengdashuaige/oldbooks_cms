package cn.cuilan.oldbooks.dao;

import java.util.List;

import cn.cuilan.oldbooks.domain.Demo;

/**
 * 映射接口
 * 
 * @author zhang.yan
 * @date 2016年10月16日 下午10:01:26
 * @package cn.cuilan.oldbooks.sm.dao
 * @file DemoMapper.java
 *
 */
public interface DemoMapper {

	/**
	 * 保存
	 * 
	 * @param demo
	 */
	void add(Demo demo);

	/**
	 * 更新
	 * 
	 * @param demo
	 */
	void update(Demo demo);

	/**
	 * 删除
	 * 
	 * @param demo
	 */
	void delete(Demo demo);

	/**
	 * 查询
	 * 
	 * @param demo
	 * @return
	 */
	List<Demo> getDemo(Demo demo);

}
