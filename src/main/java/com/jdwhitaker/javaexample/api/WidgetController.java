package com.jdwhitaker.javaexample.api;

import java.util.List;

import com.jdwhitaker.javaexample.model.Widget;
import com.jdwhitaker.javaexample.service.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/widget")
@RestController
public class WidgetController {
    private final WidgetService widgetService;

    @Autowired
    public WidgetController(WidgetService widgetService){
        this.widgetService = widgetService;
    }

    @PostMapping
    public void addWidget(@RequestBody Widget widget){
        widgetService.addWidget(widget);
    }

    @GetMapping
    public List<Widget> listWidgets(){
        return widgetService.listWidgets();
    }
}