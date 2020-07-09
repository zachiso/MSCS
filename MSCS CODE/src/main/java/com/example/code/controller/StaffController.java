package com.example.code.controller;


import com.example.code.entity.Staff;
import com.example.code.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/staff/index")
    public String index(Model model){

        model.addAttribute("staff",new Staff());
        return "staffIndex";
    }

    @PostMapping("/staff/insert")
    public String insert(@RequestParam("na") String na,
                         @RequestParam("ge") String ge,
                         @RequestParam("ph") String ph,
                         @RequestParam("po") String po){
            Staff staff = new Staff();
            staff.setName(na);
            staff.setPh(ph);
            staff.setGender(ge);
            staff.setPo(po);
            staffService.insert(staff);
            return "redirect:/staff/getAllStaff";
    }

    @GetMapping("/staff/getAllStaff")
    public String getAllStaff(Model model){
        model.addAttribute("staffList",staffService.getAllStaff());
        return "staffList";
    }


    @GetMapping("/staff/delete")
    public String deleteByIdTwo(@RequestParam("id") Integer id){
        staffService.deleteById(id);
        return "redirect:/staff/getAllStaff";
    }

    @GetMapping("/staff/update")
    public String updateStaff(@RequestParam("id") Integer id, Model model){
        model.addAttribute("staff",staffService.getStaffById(id));

        return "staffIndex";
    }
}
