package com.jdwhitaker.javaexample.service;

import java.util.List;

import com.jdwhitaker.javaexample.dao.WidgetDao;
import com.jdwhitaker.javaexample.model.Widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {
    private final WidgetDao widgetDao;

    @Autowired
    public WidgetService(@Qualifier("mysql") WidgetDao widgetDao){
        this.widgetDao = widgetDao;
    }

    public int addWidget(Widget widget){
        return widgetDao.addWidget(widget);
    }

    public int insertWidget(int id, Widget widget){
        return widgetDao.insertWidget(id, widget);
    }

    public List<Widget> listWidgets(){
        return widgetDao.listWidgets();
    }
}
