package org.springframework.samples.petclinic.user;

import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UserController {

	private final UserRepository users;

	private final PasswordEncoder passwordEncoder;

	public UserController(UserRepository users, PasswordEncoder passwordEncoder) {
		this.users = users;
		this.passwordEncoder = passwordEncoder;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping("/users/new")
	public String initCreationForm(Map<String, Object> model) {
		User user = new User();
		model.put("user", user);
		return "users/createOrUpdateUserForm";
	}

	@PostMapping("/users/new")
	public String processCreationForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "users/createOrUpdateUserForm";
		}
		else {
			String encodedPassword = this.passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			this.users.save(user);
			return "redirect:/users";
		}
	}

	@GetMapping("/users")
	public String processFindForm(Model model) {
		// List all users
		model.addAttribute("listUsers", users.findAllExceptOwnersv2());
		return "users/userList";
	}

}
