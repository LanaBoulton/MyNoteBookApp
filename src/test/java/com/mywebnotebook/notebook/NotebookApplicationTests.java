package com.mywebnotebook.notebook;

import com.mywebnotebook.notebook.controller.AuthenticationController;
import com.mywebnotebook.notebook.controller.ToDoController;
import com.mywebnotebook.notebook.entity.ToDo;
import com.mywebnotebook.notebook.service.impl.ToDoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NotebookApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testLoginPage() {
		AuthenticationController controller = new AuthenticationController();
		String viewName = controller.loginPage();
		assertEquals("login", viewName);
	}


}
