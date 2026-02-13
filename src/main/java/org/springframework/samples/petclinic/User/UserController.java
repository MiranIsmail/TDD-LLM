package org.springframework.samples.petclinic.User;

// CORRECT IMPORT: make sure it is org.springframework.ui.Model
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	private final UserRepository userRepository;

	// Inject the repository so we can save data later
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/admin")
	public String adminDashboard() {
		return "user/adminTest";
	}

	@GetMapping("/user")
	public String userProfile() {
		return "user/userPage";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		// FIX: Create a new instance so the form has an object to bind to
		// The name "User" here must match th:object="${User}" in your HTML
		model.addAttribute("User", new User());
		return "user/addUser";
	}

	// NEW: Handle the form submission
	@PostMapping("/register")
	public String processRegistration(User user) {
		// Save the user to the database
		userRepository.save(user);

		// Redirect to a success page or the home page
		return "redirect:/";
	}

}
