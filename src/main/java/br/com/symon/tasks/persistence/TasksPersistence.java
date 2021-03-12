package br.com.symon.tasks.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.symon.tasks.model.Task;

public interface TasksPersistence extends MongoRepository<Task, String> {

}
