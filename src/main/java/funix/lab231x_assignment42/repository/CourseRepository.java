package funix.lab231x_assignment42.repository;

import funix.lab231x_assignment42.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseCode(String courseCode);
}
