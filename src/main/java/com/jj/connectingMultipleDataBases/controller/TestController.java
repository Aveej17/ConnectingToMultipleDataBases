package com.jj.connectingMultipleDataBases.controller;

import com.jj.connectingMultipleDataBases.service.TestService;
import com.jj.connectingMultipleDataBases.model.Testing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/insertTest")
    public int insertTest(@RequestBody Testing t){
        return testService.insertTest(t);
    }

    @GetMapping("/getTest")
    public List<Testing> getTest(){
        return testService.getTest();
    }

    @PutMapping("/updateTest")
    public int updateTest(@RequestParam int id, @RequestParam String value){
        return testService.updateTest(id, value);
    }

    @DeleteMapping("/deleteTest")
    public int updateTest(@RequestParam int id){
        return testService.deleteTest(id);
    }
}
