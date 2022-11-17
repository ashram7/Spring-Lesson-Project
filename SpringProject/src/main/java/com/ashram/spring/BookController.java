package com.ashram.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*@Controller ������̼��� �ִ� Ŭ������ �������� �������� ��û(request)�� �޾Ƶ��̴� ��Ʈ�ѷ���� �����ؼ� �ڹ� ��(java bean)���� ����ؼ� ����*/
@Controller
public class BookController {
	//���񽺸� ȣ���ϱ� ���� BookService �� �������� ����
	@Autowired
	BookService bookService;	
	/* @RequestMapping ������̼��� �������� ��û�� ����Ǵ� �ڹ� �޼ҵ带 ���� */
	/* value �Ӽ��� �������� �ּ�(URI)�� ���� */
	/* method �Ӽ��� http ��û �޼ҵ带 �ǹ� */
	/* �Ϲ����� �� ������ ���߿��� GET �޼ҵ�� �����͸� �������� �ʴ� ��쿡, POST �޼ҵ�� �����Ͱ� ����� ��� ��� */
	/* å ���� ȭ���� �� �������� ȭ���� ������ �� �������� ������ �Ͼ�� �����Ƿ� GET �޼ҵ带 ����Ѵ�. */
	/*
	 * ModelAndView�� ��Ʈ�ѷ��� ��ȯ�� �����͸� ����ϴ� ��(Model)�� (And) ȭ���� ����ϴ� ��(View)�� ��θ� ���ĳ���
	 * ��ü
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		/* ModelAndView�� �����ڿ� ���ڿ� Ÿ��(String type) �Ķ���Ͱ� �ԷµǸ� ���� ��ζ�� ���� */
	    return new ModelAndView("book/create");
	}	
	/* create �޼ҵ�� ���������� /create �ּҰ� GET ������� �ԷµǾ��� �� book/create ����� �並 �����ش�. */
	
	//�������� ����(�Է�)�� �Ͼ�Ƿ� http �޼ҵ�� POST ������� ó��	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	//@RequestParam ������̼��� ���� HTTP �Ķ���͸� map ������ �ڵ����� ���ε�
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String bookId = this.bookService.create(map);
	    //������ �Է��� ������ ��� �ٽ� �����͸� �Է¹޾ƾ� �ϹǷ� ���� ȭ������ �����̷�Ʈ
	    if (bookId == null) {
	        mav.setViewName("redirect:/create");
	    }else {
	    //������ �Է��� �����ϸ� �� �������� �̵�
	        mav.setViewName("redirect:/detail?bookId=" + bookId);	
	    }		

	    return mav;
	}	
	
}