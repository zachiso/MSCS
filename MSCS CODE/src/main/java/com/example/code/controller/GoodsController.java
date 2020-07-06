package com.example.code.controller;

import com.example.code.entity.Goods;
import com.example.code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods/index")
    public String index(Model model){

        model.addAttribute("goods",new Goods());
        return "goodsIndex";
    }

    @PostMapping("/goods/insert")
    public String insert(@ModelAttribute("goods") Goods goods){
        if(goods.getName() == "" || goods.getPri() == "" || goods.getType() == ""){
            return "InsertWrong";
        }else{
            goodsService.insert(goods);
            return "redirect:/goods/getAllGoods";
        }


    }

    @GetMapping("/goods/getAllGoods")
    public String getAllUser(Model model){
        model.addAttribute("goodsList",goodsService.getAllGoods());
        return "goodsList";
    }


    @GetMapping("/goods/delete")
    public String deleteByIdTwo(@RequestParam("id") Integer id){
        goodsService.deleteById(id);
        return "redirect:/goods/getAllGoods";
    }

    @GetMapping("/goods/update")
    public String updateGoods(@RequestParam("id") Integer id, Model model){
        model.addAttribute("goods",goodsService.getGoodsById(id));

        return "goodsIndex";
    }
}
