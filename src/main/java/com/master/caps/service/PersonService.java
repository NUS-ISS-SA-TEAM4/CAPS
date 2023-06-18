package com.master.caps.service;

import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    boolean login(int roleType, String inName, String inPwd);
}
