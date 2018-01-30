package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import mapper.CategoryMapper;
import pojo.Category;
import service.CategoryService;
import util.Page;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/listCategory")
	public ModelAndView listCategory(Page page) {
		ModelAndView mav = new ModelAndView();
		List<Category> cs = categoryService.list(page);
		int total = categoryService.total();
		
		page.calculateLast(total);
		mav.addObject("cs", cs);
		mav.setViewName("listCategory");
		return mav;
	}
	
	//@ResponseBody--������ת��Ϊjson��ʽ
	@RequestMapping("/submitCategory")
	public String submitCatrgory(@RequestBody Category category) {
		System.out.println("ssm����������ύ��json��ת��Ϊcategory����" + category);
		return "OK";
	}
	
	@ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {
         Category c = new Category();
         c.setId(100);
         c.setName("��100������");
         JSONObject json= new JSONObject();
         json.put("category", JSONObject.toJSON(c));
         return json.toJSONString();
    }
	
	@ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("��������:"+i);
            cs.add(c);
        }
 
        return JSONObject.toJSON(cs).toString();
    }
}
