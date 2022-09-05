
package th.ac.ku.restaurant.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.dto.SignupDto;
import th.ac.ku.restaurant.model.User;
import th.ac.ku.restaurant.repository.UserRepository;

import javax.validation.Valid;

@Service
public class SignupService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }

    public void createUser(SignupDto user) {
        User record = modelMapper.map(user, User.class);
        record.setFirstName(user.getFirstName());
        record.setLastName(user.getLastName());
        record.setRole(user.getRole());
        record.setUsername(user.getUsername());

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);

        repository.save(record);
    }


/*    public void createUser(@Valid SignupDto user) {
        User record = new User();
        record.setFirstName(user.getFirstName());
        record.setLastName(user.getLastName());
        record.setRole(user.getRole());
        record.setUsername(user.getUsername());

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);

        repository.save(record);
    }*/

    public User getUser(String username) {
        return repository.findByUsername(username);
    }
}

