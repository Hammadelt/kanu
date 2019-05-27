package com.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserMessage;

@Repository
public interface MessageRepo extends CrudRepository<UserMessage, Long> {

	List<UserMessage> findByText(String text);
}
