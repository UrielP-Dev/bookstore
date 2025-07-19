package com.sivalabs.bookstore.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
class DashboardController {

    @GetMapping("")
    String dashboard(Model model) {
        return "admin/dashboard";
    }
}
