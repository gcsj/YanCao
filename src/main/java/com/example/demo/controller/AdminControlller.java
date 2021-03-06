package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminControlller {

    private final static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    @Autowired
    HuaXueWeightRepository huaXueWeightRepository;
    @Autowired
    PingXiWeightRepository pingXiWeightRepository;
    @Autowired
    WaiGuanWeightRepository waiGuanWeightRepository;
    @Autowired
    YanCaoRoleRepository yanCaoRoleRepository;
    @Autowired
    YanCaoUserRepository yanCaoUserRepository;
    @Autowired
    YanNongRepository yanNongRepository;

    @Autowired
    QualityRepository qualityRepository;

    @RequestMapping("")
    public String init(Principal principal, Model model) {

        if (huaXueWeightRepository.count() == 0) {

            huaXueWeightRepository.save(new HuaXueWeight("上部叶烟碱", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("中部叶烟碱", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("下部叶烟碱", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("总糖", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("还原糖", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("钾", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("氯", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("尼古丁", 1,0));
            huaXueWeightRepository.save(new HuaXueWeight("氮", 1,0));

            pingXiWeightRepository.save(new PingXiWeight("香气质", "好", 1, 7));
            pingXiWeightRepository.save(new PingXiWeight("香气质", "较好", 2, 6));
            pingXiWeightRepository.save(new PingXiWeight("香气质", "中等+", 3, 5));
            pingXiWeightRepository.save(new PingXiWeight("香气质", "中等", 4, 4));
            pingXiWeightRepository.save(new PingXiWeight("香气质", "中等-", 5, 3));
            pingXiWeightRepository.save(new PingXiWeight("香气质", "较差", 6, 2));
            pingXiWeightRepository.save(new PingXiWeight("香气质", "差", 7, 1));
            pingXiWeightRepository.save(new PingXiWeight("香气量", "足", 1, 7));
            pingXiWeightRepository.save(new PingXiWeight("香气量", "较足", 2, 6));
            pingXiWeightRepository.save(new PingXiWeight("香气量", "尚充足+", 3, 5));
            pingXiWeightRepository.save(new PingXiWeight("香气量", "尚充足", 4, 4));
            pingXiWeightRepository.save(new PingXiWeight("香气量", "尚充足-", 5, 3));
            pingXiWeightRepository.save(new PingXiWeight("香气量", "较少", 6, 2));
            pingXiWeightRepository.save(new PingXiWeight("香气量", "差", 7, 1));
            pingXiWeightRepository.save(new PingXiWeight("杂气", "无", 1, 7));
            pingXiWeightRepository.save(new PingXiWeight("杂气", "较轻", 2, 6));
            pingXiWeightRepository.save(new PingXiWeight("杂气", "有+", 3, 5));
            pingXiWeightRepository.save(new PingXiWeight("杂气", "有", 4, 4));
            pingXiWeightRepository.save(new PingXiWeight("杂气", "有-", 5, 3));
            pingXiWeightRepository.save(new PingXiWeight("杂气", "较重", 6, 2));
            pingXiWeightRepository.save(new PingXiWeight("杂气", "重", 7, 1));
            pingXiWeightRepository.save(new PingXiWeight("刺激性", "无", 1, 7));
            pingXiWeightRepository.save(new PingXiWeight("刺激性", "微有", 2, 6));
            pingXiWeightRepository.save(new PingXiWeight("刺激性", "有+", 3, 5));
            pingXiWeightRepository.save(new PingXiWeight("刺激性", "有", 4, 4));
            pingXiWeightRepository.save(new PingXiWeight("刺激性", "有-", 5, 3));
            pingXiWeightRepository.save(new PingXiWeight("刺激性", "较大", 6, 2));
            pingXiWeightRepository.save(new PingXiWeight("刺激性", "大", 7, 1));
            pingXiWeightRepository.save(new PingXiWeight("余味", "舒适", 1, 7));
            pingXiWeightRepository.save(new PingXiWeight("余味", "较舒适", 2, 6));
            pingXiWeightRepository.save(new PingXiWeight("余味", "尚舒适+", 3, 5));
            pingXiWeightRepository.save(new PingXiWeight("余味", "尚舒适", 4, 4));
            pingXiWeightRepository.save(new PingXiWeight("余味", "尚舒适-", 5, 3));
            pingXiWeightRepository.save(new PingXiWeight("余味", "较苦辣", 6, 2));
            pingXiWeightRepository.save(new PingXiWeight("余味", "滞舌", 7, 1));
            pingXiWeightRepository.save(new PingXiWeight("燃烧性", "强", 1, 3));
            pingXiWeightRepository.save(new PingXiWeight("燃烧性", "中等", 2, 2));
            pingXiWeightRepository.save(new PingXiWeight("燃烧性", "差+", 3, 1));
            pingXiWeightRepository.save(new PingXiWeight("燃烧性", "熄火", 4, 0));
            pingXiWeightRepository.save(new PingXiWeight("灰度", "白", 1, 4));
            pingXiWeightRepository.save(new PingXiWeight("灰度", "灰白", 2, 3));
            pingXiWeightRepository.save(new PingXiWeight("灰度", "灰", 3, 2));
            pingXiWeightRepository.save(new PingXiWeight("灰度", "黑灰", 4, 1));
            pingXiWeightRepository.save(new PingXiWeight("浓度", "淡", 1, 5));
            pingXiWeightRepository.save(new PingXiWeight("浓度", "较淡", 2, 4));
            pingXiWeightRepository.save(new PingXiWeight("浓度", "中等", 3, 3));
            pingXiWeightRepository.save(new PingXiWeight("浓度", "较浓", 4, 2));
            pingXiWeightRepository.save(new PingXiWeight("浓度", "浓", 5, 1));
            pingXiWeightRepository.save(new PingXiWeight("劲头", "小", 1, 5));
            pingXiWeightRepository.save(new PingXiWeight("劲头", "较小", 2, 4));
            pingXiWeightRepository.save(new PingXiWeight("劲头", "适中", 3, 3));
            pingXiWeightRepository.save(new PingXiWeight("劲头", "较大", 4, 2));
            pingXiWeightRepository.save(new PingXiWeight("劲头", "大", 5, 1));
            pingXiWeightRepository.save(new PingXiWeight("成团性", "好", 1, 5));
            pingXiWeightRepository.save(new PingXiWeight("成团性", "较好", 2, 4));
            pingXiWeightRepository.save(new PingXiWeight("成团性", "中等", 3, 3));
            pingXiWeightRepository.save(new PingXiWeight("成团性", "较差", 4, 2));
            pingXiWeightRepository.save(new PingXiWeight("成团性", "差", 5, 1));
            pingXiWeightRepository.save(new PingXiWeight("细腻感", "细腻", 1, 5));
            pingXiWeightRepository.save(new PingXiWeight("细腻感", "较细腻", 2, 4));
            pingXiWeightRepository.save(new PingXiWeight("细腻感", "中等", 3, 3));
            pingXiWeightRepository.save(new PingXiWeight("细腻感", "稍粗糙", 4, 2));
            pingXiWeightRepository.save(new PingXiWeight("细腻感", "粗糙", 5, 1));
            pingXiWeightRepository.save(new PingXiWeight("回甜感", "强", 1, 5));
            pingXiWeightRepository.save(new PingXiWeight("回甜感", "较强", 2, 4));
            pingXiWeightRepository.save(new PingXiWeight("回甜感", "中等", 3, 3));
            pingXiWeightRepository.save(new PingXiWeight("回甜感", "弱", 4, 2));
            pingXiWeightRepository.save(new PingXiWeight("回甜感", "无", 5, 1));
            pingXiWeightRepository.save(new PingXiWeight("干燥感", "弱", 1, 5));
            pingXiWeightRepository.save(new PingXiWeight("干燥感", "较弱", 2, 4));
            pingXiWeightRepository.save(new PingXiWeight("干燥感", "中等", 3, 3));
            pingXiWeightRepository.save(new PingXiWeight("干燥感", "较强", 4, 2));
            pingXiWeightRepository.save(new PingXiWeight("干燥感", "强", 5, 1));

            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "深黄色", "8", 1, 1, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "深黄色", "9", 1, 2, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "深黄色", "10", 1, 3, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "深黄色", "11", 1, 4, 11));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "深黄色", "12", 1, 5, 12));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "深黄色", "13", 1, 6, 13));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "金黄色", "11", 2, 1, 11));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "金黄色", "12", 2, 2, 12));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "金黄色", "13", 2, 3, 13));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "金黄色", "14", 2, 4, 14));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "金黄色", "15", 2, 5, 15));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "正黄色", "10", 3, 1, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "正黄色", "11", 3, 2, 11));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "正黄色", "12", 3, 3, 12));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "正黄色", "13", 3, 4, 13));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "正黄色", "14", 3, 5, 14));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "淡黄色", "6", 4, 1, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "淡黄色", "7", 4, 2, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "淡黄色", "8", 4, 3, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "淡黄色", "9", 4, 4, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "淡黄色", "10", 4, 5, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "红棕色", "6", 5, 1, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "红棕色", "7", 5, 2, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "红棕色", "8", 5, 3, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "微带青", "4", 6, 1, 4));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "微带青", "5", 6, 2, 5));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "杂色", "2", 7, 1, 2));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "杂色", "3", 7, 2, 3));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "青黄", "1", 8, 1, 1));
            waiGuanWeightRepository.save(new WaiGuanWeight("颜色", "青黄", "2", 8, 2, 2));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "完熟", "18", 1, 1, 18));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "完熟", "19", 1, 2, 19));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "完熟", "20", 1, 3, 20));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "成熟", "16", 2, 1, 16));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "成熟", "17", 2, 2, 17));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "成熟", "18", 2, 3, 18));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "成熟", "19", 2, 4, 19));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "成熟", "20", 2, 5, 20));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "尚熟", "11", 3, 1, 11));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "尚熟", "12", 3, 2, 12));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "尚熟", "13", 3, 3, 13));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "尚熟", "14", 3, 4, 14));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "尚熟", "15", 3, 5, 15));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "欠熟", "4", 4, 1, 4));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "欠熟", "5", 4, 2, 5));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "欠熟", "6", 4, 3, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "欠熟", "7", 4, 4, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "欠熟", "8", 4, 5, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "欠熟", "9", 4, 6, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "欠熟", "10", 4, 7, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "假熟", "1", 5, 1, 1));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "假熟", "2", 5, 2, 2));
            waiGuanWeightRepository.save(new WaiGuanWeight("成熟度", "假熟", "3", 5, 3, 3));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "多", "21", 1, 1, 21));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "多", "22", 1, 2, 22));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "多", "23", 1, 3, 23));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "多", "24", 1, 4, 24));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "多", "25", 1, 5, 25));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "较多", "16", 2, 1, 16));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "较多", "17", 2, 2, 17));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "较多", "18", 2, 3, 18));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "较多", "19", 2, 4, 19));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "较多", "20", 2, 5, 20));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "有", "11", 3, 1, 11));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "有", "12", 3, 2, 12));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "有", "13", 3, 3, 13));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "有", "14", 3, 4, 14));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "有", "15", 3, 5, 15));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "稍有", "5", 4, 1, 5));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "稍有", "6", 4, 2, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "稍有", "7", 4, 3, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "稍有", "8", 4, 4, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "稍有", "9", 4, 5, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "稍有", "10", 4, 6, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "少", "1", 5, 1, 1));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "少", "2", 5, 2, 2));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "少", "3", 5, 3, 3));
            waiGuanWeightRepository.save(new WaiGuanWeight("油分", "少", "4", 5, 4, 4));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "疏松", "11", 1, 1, 11));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "疏松", "12", 1, 2, 12));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "疏松", "13", 1, 3, 13));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "疏松", "14", 1, 4, 14));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "疏松", "15", 1, 5, 15));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "尚疏松", "8", 2, 1, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "尚疏松", "9", 2, 2, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "尚疏松", "10", 2, 3, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "稍密", "4", 3, 1, 4));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "稍密", "5", 3, 2, 5));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "稍密", "6", 3, 3, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "稍密", "7", 3, 4, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "紧密", "1", 4, 1, 1));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "紧密", "2", 4, 2, 2));
            waiGuanWeightRepository.save(new WaiGuanWeight("结构", "紧密", "3", 4, 3, 3));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "中等", "8", 1, 1, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "中等", "9", 1, 2, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "中等", "10", 1, 3, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "稍薄", "5", 2, 1, 5));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "稍薄", "6", 2, 2, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "稍薄", "7", 2, 3, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "稍厚", "6", 3, 1, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "稍厚", "7", 3, 2, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "薄", "2", 4, 1, 2));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "薄", "3", 4, 2, 3));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "薄", "4", 4, 3, 4));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "厚", "3", 5, 1, 3));
            waiGuanWeightRepository.save(new WaiGuanWeight("身份", "厚", "4", 5, 2, 4));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "浓", "13", 1, 1, 13));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "浓", "14", 1, 2, 14));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "浓", "15", 1, 3, 15));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "强", "9", 2, 1, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "强", "10", 2, 2, 10));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "强", "11", 2, 3, 11));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "强", "12", 2, 4, 12));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "中", "6", 3, 1, 6));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "中", "7", 3, 2, 7));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "中", "8", 3, 3, 8));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "中", "9", 3, 4, 9));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "弱", "3", 4, 1, 3));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "弱", "4", 4, 2, 4));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "弱", "5", 4, 3, 5));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "淡", "1", 5, 1, 1));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "淡", "2", 5, 2, 2));
            waiGuanWeightRepository.save(new WaiGuanWeight("色度", "淡", "3", 5, 3, 3));
        }
        YanCaoRole adminrole = yanCaoRoleRepository.findByRolename("ROLE_ADMIN");
        boolean isAdmin = yanCaoUserRepository.findByUsername(principal.getName()).getRoles().get(0).getId() == adminrole.getId();
        model.addAttribute("isAdmin", isAdmin);
        return "index";
    }
    @RequestMapping("/editweight")
    public String editweight(Model model){
        List<HuaXueWeight> huaXueWeights=huaXueWeightRepository.findAll();
        List<PingXiWeight> pingXiWeights=pingXiWeightRepository.findAll();
        List<WaiGuanWeight> waiGuanWeights=waiGuanWeightRepository.findAll();
        model.addAttribute("huaXueWeights",huaXueWeights);
        model.addAttribute("pingXiWeights",pingXiWeights);
        model.addAttribute("waiGuanWeights",waiGuanWeights);
        return "editweight";
    }
    @RequestMapping("/editweight/edithuaxueweight")
    public @ResponseBody void edithuaxueweight(@RequestParam("name") String name,
                                               @RequestParam("high") double high,
                                               @RequestParam("low") double low
                                               ){
        HuaXueWeight huaXueWeight=huaXueWeightRepository.findByName(name);
        huaXueWeight.setHigh(high);
        huaXueWeight.setLow(low);
        huaXueWeightRepository.save(huaXueWeight);
    }
    @RequestMapping("/editweight/editpingxiweight")
    public @ResponseBody void editpingxiweight(@RequestParam("name") String name,
                                               @RequestParam("describes") String describes,
                                               @RequestParam("score") int score
    ){
        PingXiWeight pingXiWeight=pingXiWeightRepository.findByNameAndDescribes(name,describes);
        pingXiWeight.setScore(score);
        pingXiWeightRepository.save(pingXiWeight);
    }
    @RequestMapping("/editweight/editwaiguanweight")
    public @ResponseBody void editwaiguanweight(@RequestParam("name") String name,
                                               @RequestParam("describes") String describes,
                                                @RequestParam("values") String values,
                                               @RequestParam("score") int score
    ){
       WaiGuanWeight waiGuanWeight=waiGuanWeightRepository.findByNameAndDescribesAndValues(name, describes, values);
       waiGuanWeight.setScore(score);
       waiGuanWeightRepository.save(waiGuanWeight);
    }
    @RequestMapping("/findyannong")
    public String edityannong(Model model){

        List<YanNong> yannongList= yanNongRepository.selectDistinctYanNongName();
        model.addAttribute("yannongList",yannongList);
        return "findyannong";
    }
    @RequestMapping("/deleteyannong")
    @Transactional
    @ResponseBody
    public void deleteyannong(String yannongname){
        yanNongRepository.deleteByName(yannongname);
    }
    @RequestMapping("/edityannong")
    public String edityannong(Model model ,String yannongname){
        List<YanNong> yannongList= yanNongRepository.selectByYanNongName(yannongname);
        model.addAttribute("yannongList",yannongList);
        return  "edityannong";
    }
    @RequestMapping("/updateyannong")
    @ResponseBody
    public void updateyannong(Long yannongid,String yannongname){
        if (yannongid==0){
            YanNong yanNong=new YanNong();
            yanNong.setName(yannongname);
            yanNongRepository.save(yanNong);
        }else {
            Optional<YanNong> yanNong= yanNongRepository.findById(yannongid);
            YanNong yanNong1 =yanNong.get();
            String oldname=yanNong1.getName();

            List<YanNong> yanNongList=yanNongRepository.findAllByName(oldname);
            for (YanNong yanNonga: yanNongList
                 ) {
                yanNonga.setName(yannongname);
                // System.out.println("yaogengxindeid"+yanNong1.getId());
                yanNongRepository.save(yanNonga);
            }

            List<Quality> qualityList= qualityRepository.findAllByYannongname(oldname);
            //System.out.println("烟农名称："+yannongname+"有这么多个"+qualityList.size());
            for (Quality quality:qualityList
                 ) {
              //  System.out.println("正在更改这个quality的烟农："+quality.getQualityname());
                quality.setYannongname(yannongname);
                qualityRepository.save(quality);
            }
        }
    }
    @RequestMapping("/updateyantian")
    @ResponseBody
    public void updateyantian(Long yantianid,String yannongname, String yantian){

        if (yantianid==0){
            YanNong yanNong=new YanNong();
            yanNong.setYantian(yantian);
            yanNong.setName(yannongname);
            yanNongRepository.save(yanNong);
        }else {
            Optional<YanNong> yanNong=yanNongRepository.findById(yantianid);
            YanNong yanNong1 = yanNong.get();
            String oldname=yanNong1.getYantian();
            yanNong1.setYantian(yantian);
            yanNongRepository.save(yanNong1);
            List<Quality> qualityList= qualityRepository.findAllByYannongnameAndYantian(yannongname,oldname);
            for (Quality quality:qualityList
            ) {
                quality.setYantian(yantian);
                qualityRepository.save(quality);
            }
        }
    }
    @RequestMapping("/deleteyantian")
    @ResponseBody
    public void deleteyantian(Long yannongid){
        YanNong yanNong=new YanNong();
        yanNong.setId(yannongid);
        yanNongRepository.delete(yanNong);
    }
}
