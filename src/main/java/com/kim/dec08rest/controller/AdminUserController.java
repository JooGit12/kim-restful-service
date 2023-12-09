package com.kim.dec08rest.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.kim.dec08rest.bean.AdminUser;
import com.kim.dec08rest.bean.User;
import com.kim.dec08rest.dao.UserDaoService;
import com.kim.dec08rest.exception.UserNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    private UserDaoService service;

    public AdminUserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUserAdmin(@PathVariable int id){
        User user = service.findOne(id);

        AdminUser adminUser = new AdminUser();
        if (user == null) {
            throw  new UserNotFoundException(String.format("ID[%s] not found", id));
        } else {
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }
}
