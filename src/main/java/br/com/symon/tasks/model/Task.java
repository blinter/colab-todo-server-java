package br.com.symon.tasks.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Task {

	@Id
	private String id;
	private String description;
	private List<Task> tasks;

	public String getId() {
		return id;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
