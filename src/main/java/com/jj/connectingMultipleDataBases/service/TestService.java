package com.jj.connectingMultipleDataBases.service;

import com.jj.connectingMultipleDataBases.repository.TestRepository;
import com.jj.connectingMultipleDataBases.model.Testing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;


    public List<Testing> getTest() {
        return testRepository.getTest();
    }
    public int insertTest(Testing t) {
        return testRepository.insertTest(t);
    }



    public int updateTest(int id, String value) {
        return testRepository.updateTest(id, value);
    }

    public int deleteTest(int id) {
        return testRepository.deleteTest(id);
    }
}
