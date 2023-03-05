package com.mywebnotebook.notebook;

import com.mywebnotebook.notebook.controller.AuthenticationController;
import com.mywebnotebook.notebook.controller.NoteController;
import com.mywebnotebook.notebook.controller.NotebookController;
import com.mywebnotebook.notebook.controller.ToDoController;
import com.mywebnotebook.notebook.dto.NoteDto;
import com.mywebnotebook.notebook.entity.ToDo;
import com.mywebnotebook.notebook.service.impl.ToDoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
	@Test
	public void testWelcome() {
		// create controller
		NotebookController controller = new NotebookController(null);
		// call the method under test
		String viewName = controller.welcome();
		// verify that the view name is correct
		assertEquals("welcome_page", viewName);
	}
	@Test
	public void testGuestSearch() {
		// create controller
		NotebookController controller = new NotebookController(null);
		// call the method under test
		String viewName = controller.guestSearch();
		// verify that the view name is correct
		assertEquals("notebook/search", viewName);
	}
	@Test
	public void testNewNoteForm() {
		// create controller and model
		NoteController controller = new NoteController(null, null);
		Model model = new BindingAwareModelMap();
		// call the method under test
		String viewName = controller.newNoteForm(model);
		// verify that the view name and model attributes are correct
		assertEquals("admin/create_note", viewName);
		NoteDto noteDto = (NoteDto) model.asMap().get("note");
		assertNotNull(noteDto);
	}
}
