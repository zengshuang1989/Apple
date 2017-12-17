package edu.zxy.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.bean.TestAnnotationTransationBean;
import edu.zxy.apple.bean.TestJDBCTransationBean;


@Controller
public class TestAnnotationTransationController
{
    @Autowired
    TestAnnotationTransationBean testAnnotationTransationBean;

    @RequestMapping(value = "/testAnno", method = RequestMethod.GET)
    public @ResponseBody void testOper()
    {
        testAnnotationTransationBean.testOperateDatabase();
    }
}
