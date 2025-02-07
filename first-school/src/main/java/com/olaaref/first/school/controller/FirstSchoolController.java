package com.olaaref.first.school.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/webhook")
public class FirstSchoolController {

        @GetMapping("/student/{name}")
        public String  addedStudent(@PathVariable String name) {
            log.info("webhook notification received for student : " + name);
            return "webhook received student name: " + name;
        }
}
