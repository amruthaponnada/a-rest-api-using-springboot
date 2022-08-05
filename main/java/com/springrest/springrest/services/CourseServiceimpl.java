package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	@Autowired
	private CourseDao cd;
	
	//List<Course> list;
	
	public CourseServiceimpl()
	{
		//list=new ArrayList<>();
		//list.add(new Course(145,"Java","java basics are here."));
		//list.add(new Course(124,"SB","rest api is here"));
		
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return cd.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		/*Course c= null;
		
		for(Course cou: list)
		{
			if(cou.getId()==courseId)
			{
				c=cou;
			break;
			}
		}
		return c;*/
		return cd.getOne(courseId);
	}
	@Override
	public Course addCourse(Course cou) {
		// TODO Auto-generated method stub
		/*list.add(cou);
		return cou;*/
		cd.save(cou);
		return cou;
	}
	@Override
	public Course updateCourse(Course cou) {
		// TODO Auto-generated method stub
		/*list.forEach(e->{
			if(e.getId()==cou.getId())
			{
				e.setTitle(cou.getTitle());
				e.setDescription(cou.getDescription());
			}
		});
		return cou;*/
		cd.save(cou);
		return cou;
		
	}
	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		//list= this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity = cd.getOne(parseLong);
		cd.delete(entity);
		
		
		
	}
	
	

}
