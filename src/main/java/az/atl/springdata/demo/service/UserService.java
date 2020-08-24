package az.atl.springdata.demo.service;

import az.atl.springdata.demo.entity.User;
import az.atl.springdata.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail (String email){
        return userRepository.findByEmail(email);
    }

    public User getUserOne() {
        return userRepository.getUSerByIdOne();
    }

    public User getUserTwo() {
        return userRepository.getUSerByIdTwo();
    }

    public List<User> findAllUser() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Page<User> users() {
        Pageable pageable = PageRequest.of(0, 10);

        return userRepository.findAll(pageable);
    }
}
