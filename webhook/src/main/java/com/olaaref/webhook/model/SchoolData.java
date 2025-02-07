package com.olaaref.webhook.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCHOOL_DATA")
public class SchoolData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "schoolData", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WebhookDetails> webhookDetails;

    @OneToMany(mappedBy = "schoolData", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;
}
