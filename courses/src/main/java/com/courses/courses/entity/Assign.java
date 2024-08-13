package com.courses.courses.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assign {

//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long courseId;
    private long userId;
}
