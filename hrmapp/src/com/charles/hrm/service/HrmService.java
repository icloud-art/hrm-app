package com.charles.hrm.service;

import com.charles.hrm.domain.User;

public interface HrmService {
    User login(String loginname, String password);
}
