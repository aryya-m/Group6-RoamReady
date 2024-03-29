package com.csis3275.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import com.csis3275.respository.UsersRepository;
@Service
public class ServiceDao {
	 private final UsersRepository usersRepository;

	 

	    public ServiceDao(UsersRepository usersRepository) {
	        this.usersRepository = usersRepository;
	     	    }

	    public void registerUser(String username, String password, String email) {
	        if (usersRepository.findByUsername(username) != null) {
	            throw new IllegalArgumentException("Username already exists");
	        }

	        Users newUser = new Users();
	        newUser.setUsername(username);

			String hashedPassword = hashPassword(password);
	        newUser.setPassword(hashedPassword); // Hash the password

	        newUser.setEmail(email);

	        usersRepository.save(newUser);
	    }

		private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

	public boolean checkPassword(String username, String password) {
		Users user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new IllegalArgumentException("User does not exist");
		}
	
		String hashedPassword = hashPassword(password); // Use the same hashPassword method as in registerUser
	
		return hashedPassword.equals(user.getPassword());
	}
}
