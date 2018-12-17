package com.thucnh.minischoolsystem.services.servicesImpl;

import com.thucnh.minischoolsystem.dtos.CourseDTO;
import com.thucnh.minischoolsystem.dtos.StudentCardDTO;
import com.thucnh.minischoolsystem.dtos.StudentDTO;
import com.thucnh.minischoolsystem.dtos.TeacherDTO;
import com.thucnh.minischoolsystem.models.Course;
import com.thucnh.minischoolsystem.models.Student;
import com.thucnh.minischoolsystem.repositories.CourseRepository;
import com.thucnh.minischoolsystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        List<CourseDTO> result = new ArrayList<>();
        for (Course course: courseList
             ) {
            List<StudentDTO> studentDTOList =  new ArrayList<>();
            for (Student student: course.getStudents()
                 ) {
                studentDTOList.add(
                        new StudentDTO(
                                student.getId(),
                                student.getName(),
                                student.getAddress(),
                                student.getAge(),
                                new TeacherDTO(
                                        student.getTeacher().getId(),
                                        student.getTeacher().getName(),
                                        student.getTeacher().getAge()
                                        ),
                                new StudentCardDTO(
                                        student.getStudentCard().getNum()
                                        )
                                )
                );
            }
            result.add(new CourseDTO(
                    course.getId(),
                    course.getName(),
                    studentDTOList
            ));
        }
        return result;
    }

    @Override
    public CourseDTO findByID(String id) {
        return null;
    }

    @Override
    public void save(CourseDTO dto) {

    }

    @Override
    public void delete(String id) {

    }
}
