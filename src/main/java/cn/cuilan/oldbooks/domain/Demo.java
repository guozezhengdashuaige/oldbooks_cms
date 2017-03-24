package cn.cuilan.oldbooks.domain;

import java.io.Serializable;

/**
 * 
 * @author zhang.yan
 * @date 2016年10月16日 下午10:00:28
 * @package cn.cuilan.oldbooks.sm.domain
 * @file Demo.java
 *
 */
public class Demo implements Serializable {

	private static final long serialVersionUID = -142947224344549402L;

	private int id;

	private String name;

	public Demo() {
		super();
	}

	public Demo(String name) {
		super();
		this.name = name;
	}

	public Demo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + "]";
	}

}
