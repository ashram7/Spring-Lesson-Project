package com.ashram.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*�������� ���� Ŭ�������� �˷��ش�*/
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookDao bookDao;
	/* �����ͺ��̽� ������ ���� BookDao �ν��Ͻ��� ���� */
	
	@Override
	public String create(Map<String, Object> map) {
		//bookDao.insert �޼��带 ����
		//affectRowCount �������� ������� �� ���� ����.
	    int affectRowCount = this.bookDao.insert(map);
	    if (affectRowCount ==  1) {
	    	//map �ν��Ͻ��� book ���̺��� PK�� book_id�� ������� ���̴�. book_id ���� ����
	        return map.get("book_id").toString();
	    }
	    return null;
	}
	
	
}













