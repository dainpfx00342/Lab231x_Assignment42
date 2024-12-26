package funix.lab231x_assignment42.service;

import funix.lab231x_assignment42.model.User;
import funix.lab231x_assignment42.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
         User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
       
}
