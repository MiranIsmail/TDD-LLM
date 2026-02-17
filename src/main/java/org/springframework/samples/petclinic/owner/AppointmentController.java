package org.springframework.samples.petclinic.owner;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AppointmentController {

	private final OwnerRepository owners;

	public AppointmentController(OwnerRepository owners) {
		this.owners = owners;
	}

	@GetMapping("/appointments")
	public String listOwnerAppointments(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		String username = userDetails.getUsername();
		Owner owner = owners.findByUsername(username)
			.orElseThrow(() -> new IllegalArgumentException("Owner not found for username: " + username));

		model.addAttribute("pets", owner.getPets());
		model.addAttribute("appointments", owner.getPets().stream().flatMap(pet -> pet.getVisits().stream()).toList());

		return "appointments/list";
	}

}
