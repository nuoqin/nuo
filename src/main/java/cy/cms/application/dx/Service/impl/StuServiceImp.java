package cy.cms.application.dx.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cy.cms.application.dx.Service.StuService;
import cy.cms.application.dx.mapper.StuMapper;
import cy.cms.application.dx.pojo.Stu;
import cy.cms.application.dx.util.Result;

/**
 * 
 * @author cui
 *@version stu表的操作
 */
@Service
public class StuServiceImp implements StuService {
	
	@Autowired
	private StuMapper sm;
	
	/**
	 * @param page 第几个
	 * @param size 个数
	 * @return page 返回分页列表
	 */
	
	@Override
	public Result findStu(Integer page, Integer size) {
		// TODO Auto-generated method stub
		//1.开启分页
		PageHelper.startPage(page,size);
		//2.查询信息
		List<Stu> list = sm.selectUsers(page, size);
		//3.获取分页查询后的数据
		PageInfo<Stu> pageInfo=new PageInfo<>(list);
		//4.封装需要返回的分页实体
		Result result=new Result();
		result.setCode(0);
		result.setMsg("");
		result.setData(list);
		result.setcount(pageInfo.getTotal());
		return result;
	}
	/**
	 * @param stu 学生信息
	 * 
	 */
	@Override
	public void addStu(Stu stu) {
		// TODO Auto-generated method stub
		sm.addStu(stu);
	}
	
	@Override
	public void delStu(Long id) {
		// TODO Auto-generated method stub
		sm.delStu(id);
	}
	@Override
	public void updateStu(Stu stu,Long id) {
		// TODO Auto-generated method stub
		//Stu selectStyById = sm.selectStyById(id);
		sm.UpdateStu(stu, id);
		
	}
	@Override
	public Stu selectById(Long id) {
		// TODO Auto-generated method stub
		//sm.selectStyById(id);
		return sm.selectStyById(id);
	}

	
}
