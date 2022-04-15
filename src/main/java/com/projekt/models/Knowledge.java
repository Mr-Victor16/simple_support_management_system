package com.projekt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "knowledge_bases")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer knowledgeID;

    @Size(min = 2, max = 50) @NotBlank
    @Column(name = "knowledge_title", nullable = false)
    private String knowledgeTitle;

    @Size(min = 20, max = 360) @NotBlank
    @Column(name = "knowledge_content", nullable = false)
    private String knowledgeContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "knowledge_date", nullable = false)
    private LocalDate knowledgeDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "softwareID", nullable = false)
    private Software software;
}
