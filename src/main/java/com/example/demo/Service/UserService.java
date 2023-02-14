package com.example.demo.Service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validate(String email) {
        //Return boolean, True or False.
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setModiEd(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        updatedUser.setIsactive(user.getIsactive());
        userRepository.save(updatedUser);

    }

    public void deleteUser(Integer id, User user) {
        userRepository.deleteById(id);
    }

    public void changeIsActive(Integer id, User user) {
        User updatedUser = userRepository.findById(id).get();
        /*updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setModiEd(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));*/
        updatedUser.setIsactive(user.getIsactive());
        userRepository.save(updatedUser);
    }
}
