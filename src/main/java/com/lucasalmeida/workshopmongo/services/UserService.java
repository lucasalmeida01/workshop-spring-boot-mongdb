package com.lucasalmeida.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasalmeida.workshopmongo.domain.User;
import com.lucasalmeida.workshopmongo.repository.UserRepository;
import com.lucasalmeida.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired //notação para instanciar automaticamente um objeto no serviço, injeção de dependência automática
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
