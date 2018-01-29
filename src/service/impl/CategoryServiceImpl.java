package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.CategoryMapper;
import pojo.Category;
import service.CategoryService;
import util.Page;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Category> list(){
		return categoryMapper.list();
	}
	
	public int total() {
		return categoryMapper.total();
	}
	
	public List<Category> list(Page page){
		return categoryMapper.list(page);
	}
}
