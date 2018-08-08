package ua.logos.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.logos.domain.UserDTO;
import ua.logos.domain.filter.SimpleFilter;
import ua.logos.entity.User;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;
import ua.logos.service.util.ObjectMapperUtils;

@Service

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ObjectMapperUtils modelMapper;

	@Override
	public void saveUser(UserDTO userDTO) {

		User userEntity = modelMapper.map(userDTO, User.class);
		
		userRepository.save(userEntity);
	}

	@Override
	public UserDTO findById(Long id) {
		User userEntity = userRepository.findById(id).get();
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		
		return userDTO;
	}

	@Override
	public List<UserDTO> findAllUsers() {
		
		List<User> usersEntity = userRepository.findAll();
		List<UserDTO> usersDTO = modelMapper.mapAll(usersEntity, UserDTO.class);
		return usersDTO;
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
		
	}

	@Override
	public List<UserDTO> findByPostId(Long id) {
		return modelMapper.mapAll(userRepository.findByPostId(id), UserDTO.class);
	}

	@Override
	public List<UserDTO> findAllUsersBySpecification(SimpleFilter filter) {
		return modelMapper.mapAll(userRepository.findAll(getSpecification(filter)), UserDTO.class);
	}
	
	private Specification<User> getSpecification(SimpleFilter filter){
		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				if(filter.getSearch().isEmpty()) {
					return null;
				}
				
				Expression<String> searchByFirstNameExp = root.get("firstName");
				Predicate searchByFirstNamePred = criteriaBuilder.like(searchByFirstNameExp, "%" + filter.getSearch() + "%");
				Expression<String> searchByLastNameExp = root.get("firstName");
				Predicate searchByLastNamePred = criteriaBuilder.like(searchByLastNameExp, "%" + filter.getSearch() + "%");
				return criteriaBuilder.or(searchByFirstNamePred, searchByLastNamePred);
			}
		};
		
	}

	@Override
	public List<UserDTO> findAllUsersByPages(Pageable pageble) {
		return null;
	}

}
