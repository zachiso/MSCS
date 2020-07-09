package com.example.code.controller;

import com.example.code.entity.User;
import com.example.code.entity.Vip;
import com.example.code.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VipController {
    @Autowired
    private VipService vipService;

    @GetMapping("/vip/index")
    public String index(Model model){

        model.addAttribute("vip",new Vip());
        return "vipIndex";
    }

    @PostMapping("/vip/insert")
    public String insert(@RequestParam("na") String na,
                         @RequestParam("ph") String ph){
        Vip vip = new Vip();
        vip.setName(na);
        vip.setPh(ph);
        vipService.insert(vip);
        return "redirect:/vip/getAllVip";


    }

    @GetMapping("/vip/getAllVip")
    public String getAllVip(Model model){
        model.addAttribute("vipList",vipService.getAllVip());
        return "vipList";
    }


    @GetMapping("/vip/delete")
    public String deleteByIdTwo(@RequestParam("id") Integer id){
        vipService.deleteById(id);
        return "redirect:/vip/getAllVip";
    }

    @GetMapping("/vip/update")
    public String updateVip(@RequestParam("id") Integer id, Model model){
        model.addAttribute("vip",vipService.getVipById(id));
        return "vipIndex";
    }
}
