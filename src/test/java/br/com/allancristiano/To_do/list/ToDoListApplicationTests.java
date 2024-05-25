package br.com.allancristiano.To_do.list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.allancristiano.To_do.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testCreateTodoSucess(){
		var todo = new Todo("Todo 1", "Todo description 1", false, 1);
		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].name").isEqualTo(todo.getName())
			.jsonPath("$[0].description").isEqualTo(todo.getDescription())
			.jsonPath("$[0].realizated").isEqualTo(todo.isRealizated())
			.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
		

	}

	@Test
	public void testCreateTodoFail(){
		var todo = new Todo("", "", false, 1);
		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isBadRequest();
	}

}
