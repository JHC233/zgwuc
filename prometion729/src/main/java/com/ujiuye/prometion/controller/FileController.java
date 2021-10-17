package com.ujiuye.prometion.controller;


import com.ujiuye.prometion.service.EmployeeService;
import com.ujiuye.prometion.utils.MyFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/file")
public class FileController {
    @Value("${excel.url}")
    private String excelurl;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(int pageNum){

        File excel = employeeService.getExcel(pageNum);
        if (excel==null){
            return null;
        }
//下载
        return MyFileUtils.download(excel.getName(),excelurl);
    }
}
