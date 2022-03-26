package com.app.pointsystem.controllers;

import java.util.*;
import javax.validation.Valid;
import com.app.pointsystem.dtos.PointDTO;
import com.app.pointsystem.models.PointModel;
import com.app.pointsystem.services.PointService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PointController {
    final PointService pointService;

    PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/")
    public ModelAndView showPoints() {
        ModelAndView mav = new ModelAndView("show-points");
        List<PointModel> pointsList = pointService.findAll();
        mav.addObject("points", pointsList);
        
        return mav;
    }

    @GetMapping("/addPoint")
        public ModelAndView addPoint() {
        ModelAndView mav = new ModelAndView("register");
        PointModel eventModel = new PointModel();
        mav.addObject("point", eventModel);

        return mav;
    }

    @PostMapping("/savePoint")
    public String savePoint(@ModelAttribute @Valid PointDTO pointDTO, PointModel point) {
        if (this.pointService.validationName(point.getEmployee())) {
            return "redirect:/";
        }
        BeanUtils.copyProperties(pointDTO, point);
        pointService.save(point);
        return "redirect:/";
    }

    @GetMapping("/updatePoint")
    public ModelAndView updatePoint(@RequestParam UUID pointId) {
        ModelAndView mav = new ModelAndView("register");
        Optional<PointModel> pointModel = pointService.findById(pointId);
        mav.addObject("point", pointModel);

        return mav;
    }

    @GetMapping("/deletePoint")
    public String deletePoint(@RequestParam UUID pointId) {
        pointService.deleteById(pointId);
        return "redirect:/";
    }
    
}
