package org.springframework.samples.petclinic.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

	@GetMapping("/admin")
	public String adminDashboard() {
		return "user/adminTest";
	}

	@GetMapping("/user")
	public String userProfile() {
		return "user/userPage";
	}

}
