package com.example.examplemodule4.service.City;

import com.example.examplemodule4.model.City;
import com.example.examplemodule4.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IService<City> {
    Page<City> findAllByName(Pageable pageable,String name);
}
