package com.olaaref.webhook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "schoolData")
@Entity
@Table(name = "WEBHOOK_DETAILS")
public class WebhookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "EVENT_NAME", nullable = false)
    private String eventName;

    @Column(name = "URL", nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHOOL_ID", referencedColumnName = "ID")
    @JsonIgnore
    private SchoolData schoolData;

}
