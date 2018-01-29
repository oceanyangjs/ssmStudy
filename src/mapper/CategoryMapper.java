package mapper;

import java.util.List;

import pojo.Category;

public interface CategoryMapper {
	
	public void add(Category category);
	
	public void delete(int id);
	
	public Category get(int id);
	
	public void update(Category category);
	
	public int count();
	
	public List<Category> list();
}
