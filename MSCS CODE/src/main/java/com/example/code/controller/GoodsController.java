package com.example.code.controller;

import com.example.code.entity.Goods;
import com.example.code.entity.Vip;
import com.example.code.service.GoodsService;
import com.example.code.service.VipService;
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
    @Autowired
    private VipService vipService;

    @GetMapping("/goods/index")
    public String index(Model model){

        return "goodsIndex";
    }

    @GetMapping("/desk")
    public String Desk(){

        return "desk";
    }

    @GetMapping("/com")
    public String getGoods(@RequestParam("id") Integer id,
                           @RequestParam("num") int n,
                           @RequestParam("tol") String tol,
                           @RequestParam("vNum") String v,
                           @RequestParam("type") String vr,
                           Model model){int t;
        if(tol == ""){
            t = 0;
        }
        else{
            t = Integer.parseInt(tol);
        }Goods g = null;
        g = goodsService.getGoodsById(id);
        if(g == null){
            return "gwrong";
        }

        int t1 = Integer.parseInt(g.getPri());
        t1 *= n; Vip vip = null;
        vip = vipService.getVipById(Integer.parseInt(v));

        if(vip == null && "1".equals(vr)){
            return "vipwrong";
        }else if(vip != null && "1".equals(vr)) {
            t1 *= 0.8;
        }
        t += t1;
        model.addAttribute("goods",goodsService.getGoodsById(id));
        model.addAttribute("result", t);
        return "desk";
    }



    @PostMapping("/goods/insert")
    public String insert(@RequestParam("na") String na,
                         @RequestParam("pr") String pr,
                         @RequestParam("ty") String ty){
            Goods goods = new Goods();
            goods.setName(na);
            goods.setPri(pr);
            goods.setType(ty);
            goodsService.insert(goods);
            return "redirect:/goods/getAllGoods";
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
