package com.example.serverside.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.serverside.model.PujaUser;
import com.example.serverside.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public PujaUser saveUser(PujaUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public PujaUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public List<PujaUser> findAllUsers(){
		return userRepository.findAll();
		
	}
	
	@Override
	public PujaUser updateUser(PujaUser user) {
		return userRepository.save(user);
		
	}

	@Override
	public Object getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}
}
