package cn.cuilan.oldbooks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cuilan.oldbooks.domain.Demo;
import cn.cuilan.oldbooks.service.DemoService;

/**
 * 
 * @author zhang.yan
 * @date 2016年10月25日 下午9:39:05
 * @package cn.cuilan.oldbooks.controller
 * @file DemoController.java
 *
 */
@Controller
@RequestMapping(value = "demo")
@ResponseBody
@Qualifier
public class DemoController {

	@Autowired
	private DemoService demoService;

	// TODO 解决乱码问题
	@RequestMapping(value = "getDemo", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object getDemo(HttpServletRequest request, HttpServletResponse response) {
		Demo demo = new Demo("张岩");
		List<Demo> list = demoService.getDemo(demo);
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (Demo temp : list) {
			JSONObject object = new JSONObject(temp);
			jsonArray.put(object);
		}
		json.put("result", jsonArray);
		json.put("status", 10000);
		json.put("message", "正确处理");
		return json.toString();
	}

}
