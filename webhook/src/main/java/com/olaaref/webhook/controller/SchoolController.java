package com.olaaref.webhook.controller;

import com.olaaref.webhook.model.SchoolData;
import com.olaaref.webhook.model.Student;
import com.olaaref.webhook.model.WebhookDetails;
import com.olaaref.webhook.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public SchoolData addSchool(@RequestParam String name) {
        return schoolService.addSchool(SchoolData.builder().name(name).build());
    }

    @PostMapping("/webhook/school/add/{schoolId}")
    public SchoolData addWebhookEvent(
            @PathVariable Long schoolId,
            @RequestBody WebhookDetails webhookDetails
            ) {
        Optional<SchoolData> schoolData =  schoolService.findById(schoolId);
        List<WebhookDetails> webhooks = new java.util.ArrayList<>();
        WebhookDetails webhook = WebhookDetails.builder()
                .eventName(webhookDetails.getEventName())
                .url(webhookDetails.getUrl())
                .schoolData(schoolData.get())
                .build();
        webhooks.add(webhook);
        schoolData.get().setWebhookDetails(webhooks);
        return schoolService.addSchool(schoolData.get());
    }

    @PostMapping("/webhook/student/add/{schoolId}")
    public SchoolData addWebhookEvent(
            @PathVariable Long schoolId,
            @RequestBody Student student
    ) {
        Optional<SchoolData> schoolData =  schoolService.findById(schoolId);
        List<Student> students = new java.util.ArrayList<>();
        Student studentModel = Student.builder()
                .name(student.getName())
                .age(student.getAge())
                .schoolData(schoolData.get())
                .build();
        students.add(studentModel);
        schoolData.get().setStudents(students);
        SchoolData savedSchoolData = schoolService.addSchool(schoolData.get());
        //send webhook notification to first-school
        WebhookDetails webhookDetails = savedSchoolData.getWebhookDetails()
                .stream()
                .filter(webhook -> webhook.getEventName().equals("add"))
                .findFirst()
                .orElse(null);
        if (webhookDetails != null && webhookDetails.getUrl() != null) {
            //send webhook notification to first-school
            sendWebhookNotification(webhookDetails.getUrl(), student);
        }
        return savedSchoolData;
    }

    private void sendWebhookNotification(String url, Student student) {
        String webhookUrl = url + "/" + student.getName();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(webhookUrl, String.class);
        System.out.printf("Webhook notification sent to %s with result: %s\n", webhookUrl, result);
    }

}
