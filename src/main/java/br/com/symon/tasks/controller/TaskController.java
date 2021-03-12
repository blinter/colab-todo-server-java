package br.com.symon.tasks.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.symon.tasks.model.Task;
import br.com.symon.tasks.persistence.TasksPersistence;

@RestController
public class TaskController {

	// How define produce and consume types only one time for all methods of
	// controller?

	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private TasksPersistence tasksPersistence;

	@PostMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void processar(@RequestBody @Validated Task task) {
		logger.debug("New task request received...");
		tasksPersistence.insert(task);
		return;
	}

	@GetMapping(value = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Task> listar() {
		logger.debug("Request for list taks received...");
		List<Task> results = tasksPersistence.findAll();
		return results;
	}

	@GetMapping(value = "/task/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task buscarPeloID(@PathVariable("id") String id) {
		logger.debug("Searching task by id [%s].", id);
		Optional<Task> task = tasksPersistence.findById(id);
		return task.get();
	}
}
