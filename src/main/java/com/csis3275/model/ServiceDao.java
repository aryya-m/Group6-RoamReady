package com.csis3275.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.csis3275.respository.UsersRepository;

@Service
public class ServiceDao {
	private final UsersRepository usersRepository;

	private static final Logger logger = LoggerFactory.getLogger(ServiceDao.class);

	public ServiceDao(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	/**
	 * registers user in database checks if username exists
	 *
	 * @param username the new users username
	 * @param password the new users password 
	 * @param email the new users password 
	 * @throws IllegalArgumentException if username already exists 
	 * 
	 */
	public void registerUser(String username, String email, String password) {
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

	/**
	 * Hashes a password using the SHA-256 algorithm.
	 * Hash will always be the same
	 *
	 * @param password the password to be hashed
	 * @return the hashed password as a hexadecimal string
	 * @throws Exception
	 * 
	 */
	private String hashPassword(String password) {
		//logger.info("Hashing password " + password);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
			BigInteger number = new BigInteger(1, hash);
			StringBuilder hexString = new StringBuilder(number.toString(16));
			while (hexString.length() < 32) {
				hexString.insert(0, '0');
			}
			//logger.info("password hashed " + hexString.toString());
			return hexString.toString();
		} catch (Exception e) {

			throw new RuntimeException(e);

		}
	}

	/**
	 * Checks if the provided username and password match the ones stored in the
	 * database.
	 *
	 * @param username the username of the user trying to log in
	 * @param password the password provided by the user trying to log in
	 * @return true if the provided password matches the one stored in the database
	 *         for the given username, false otherwise
	 * @throws IllegalArgumentException if the username does not exist in the
	 *                                  database
	 */
	public boolean checkLogin(String username, String password) {
		//logger.info(username,password);
		Users users = usersRepository.findByUsername(username);
		if (users == null) {
			throw new IllegalArgumentException("User does not exist");
		}

		String hashedPassword = hashPassword(password);
		//  logger.info("Hashed Pass" + hashedPassword);
		//  logger.info("User Password " + users.getPassword());
		// logger.info("" + hashedPassword.equals(users.getPassword()));

		return hashedPassword.equals(users.getPassword());
	}

	public Users loginUser(String username, String password) {
		if (checkLogin(username, password)) {
			logger.info("login successful");
			return usersRepository.findByUsername(username);
		} else {
			logger.info("Invalid username or password");
			throw new IllegalArgumentException("Invalid username or password");
		}
	}

}
