package org.example.atlasrh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
