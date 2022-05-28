package com.jdwhitaker.javaexample.dao;

import java.util.List;

import com.jdwhitaker.javaexample.model.Widget;

public interface WidgetDao {
    int insertWidget(int id, Widget widget);
    int addWidget(Widget widget);
    List<Widget> listWidgets();
}
