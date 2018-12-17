package com.thucnh.minischoolsystem.services.servicesImpl;

import com.thucnh.minischoolsystem.dtos.CourseDTO;
import com.thucnh.minischoolsystem.dtos.StudentCardDTO;
import com.thucnh.minischoolsystem.dtos.StudentDTO;
import com.thucnh.minischoolsystem.dtos.TeacherDTO;
import com.thucnh.minischoolsystem.models.Course;
import com.thucnh.minischoolsystem.models.Student;
import com.thucnh.minischoolsystem.models.StudentCard;
import com.thucnh.minischoolsystem.models.Teacher;
import com.thucnh.minischoolsystem.repositories.StudentCardRepository;
import com.thucnh.minischoolsystem.repositories.StudentRepository;
import com.thucnh.minischoolsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final StudentCardRepository studentCardRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCardRepository studentCardRepository) {
        this.studentRepository = studentRepository;
        this.studentCardRepository = studentCardRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> result = new ArrayList<>();

        for (Student student : studentList
        ) {
            List<CourseDTO> courseDTOList = new ArrayList<>();
            for (Course course : student.getCourses()
            ) {
                courseDTOList.add(new CourseDTO(
                        course.getId(),
                        course.getName()
                ));
            }
            result.add(new StudentDTO(
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
                    ),
                    courseDTOList
            ));
        }

        return result;
    }

    @Override
    public StudentDTO findByID(Integer id) {
        Student student = studentRepository.findById(id).get();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (Course course : student.getCourses()
        ) {
            courseDTOList.add(new CourseDTO(
                    course.getId(),
                    course.getName()
            ));
        }
        StudentDTO studentDTO = new StudentDTO(
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
                ),
                courseDTOList
        );
        return studentDTO;
    }

    @Override
    public List<StudentDTO> findByName(String name) {
        List<Student> studentList = studentRepository.findStudentsByNameContains(name);
        List<StudentDTO> result = new ArrayList<>();
        for (Student student : studentList
        ) {
            result.add(new StudentDTO(
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
            ));
        }

        return result;
    }

    @Override
    public void add(StudentDTO dto) {
        Student student = new Student(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getAge(),
                new Teacher(dto.getTeacher().getId())

        );
        studentRepository.save(student);
    }

    @Override
    public void update(StudentDTO dto) {
        List<Course> courseList = new ArrayList<>();
        for (CourseDTO courseDTO : dto.getCourses()
        ) {
            courseList.add(new Course(
                    courseDTO.getId()
            ));
        }
        Student student = new Student(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getAge(),
                new Teacher(dto.getTeacher().getId()),
                new StudentCard(dto.getStudentCard().getId(),dto.getStudentCard().getNum()),
                courseList
        );

        studentRepository.save(student);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void addCourses(Integer id, List<CourseDTO> courseDTOList) {
        Student student = studentRepository.findById(id).get();
        List<Course> courseList = new ArrayList<>();
        for (CourseDTO dto : courseDTOList
        ) {
            courseList.add(new Course(
                    dto.getId(),
                    dto.getName()
            ));
        }
        student.setCourses(courseList);
        studentRepository.save(student);
    }
}
