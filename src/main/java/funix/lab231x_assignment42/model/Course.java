package funix.lab231x_assignment42.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String courseAlias;

    @Column(unique = true)
    private String courseCode;

    @Column(nullable = false)
    private boolean courseStatus = true;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdTimes;
    @PrePersist
    protected void onCreate() {
        this.createdTimes = LocalDateTime.now();
    }

    @Column
    private LocalDateTime updatedTimes;
    @PreUpdate
    protected void onUpdate() {
        this.updatedTimes = LocalDateTime.now();
    }

    @Column
    private String updatedBy;

}
