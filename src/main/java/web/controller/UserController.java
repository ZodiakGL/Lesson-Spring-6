package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;

@Controller
@RequestMapping ("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String getAllUsers (Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
	@GetMapping("/new")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "newUser";
	}

	@PostMapping()
	public String create(@RequestParam("name") String name, @RequestParam("nickname") String nickname,
						 @RequestParam("mail") String mail, Model model) {
		userService.addUser(name, nickname, mail);
		return "redirect:/users";
	}
}
