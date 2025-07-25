package com.example.studentmanager.service;

import com.example.studentmanager.converter.StudentConverter;
import com.example.studentmanager.dto.StudentDTO;
import com.example.studentmanager.entity.StudentEntity;
import com.example.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentConverter studentConverter;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        StudentEntity entity = studentConverter.DTOtoEntity(studentDTO);
        StudentEntity savedEntity = studentRepository.save(entity);
        StudentDTO savedDTO = studentConverter.EntitytoDTO(savedEntity);

        return savedDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> entities = studentRepository.findAll();
        List<StudentDTO> allStudent = new ArrayList<>();
        for (StudentEntity se : entities) {
            allStudent.add(studentConverter.EntitytoDTO(se));
        }

        return allStudent;
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        Optional<StudentEntity> optionalEntity = studentRepository.findById(id);

        if (optionalEntity.isPresent()) {
            StudentEntity entity = optionalEntity.get(); // Optional içinden al
            return studentConverter.EntitytoDTO(entity);  // DTO'ya çevir ve döndür
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            StudentEntity entityToUpdate = optionalStudent.get();

            // ID'nin değişmediğinden emin olmak için setId yapmıyoruz veya doğrudan DTO’dan gelen id'yi kullanmıyoruz.
            entityToUpdate.setName(studentDTO.getName());
            entityToUpdate.setAverage(studentDTO.getAverage());
            entityToUpdate.setAddresses(
            // Diğer alanları güncelle

            StudentEntity updatedEntity = studentRepository.save(entityToUpdate);

            return studentConverter.EntitytoDTO(updatedEntity);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }


    @Override
    public StudentDTO deleteStudent(Integer id) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return studentConverter.EntitytoDTO(optionalStudent.get());
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public List<StudentDTO> getAllStudentsSortedById() {
        List<StudentEntity> studentEntities = studentRepository.findAll(Sort.by("id"));
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (StudentEntity se : studentEntities) {
            studentDTOS.add(studentConverter.EntitytoDTO(se));
        }
        return studentDTOS;
    }

    @Override
    public List<StudentDTO> getAllStudentsSortedByAverage() {
        List<StudentEntity> studentEntities = studentRepository.findAll(Sort.by("average"));
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (StudentEntity se : studentEntities) {
            studentDTOS.add(studentConverter.EntitytoDTO(se));
        }
        return studentDTOS;
    }

    @Override
    public List<StudentDTO> sortedStudentByName() {
        List<StudentEntity> listedStudentEnt = studentRepository.findAll(Sort.by("name"));
        List<StudentDTO> listedStudentDTO = new ArrayList<>();
        for (StudentEntity se : listedStudentEnt) {
            listedStudentDTO.add(studentConverter.EntitytoDTO(se));
        }
        return listedStudentDTO;


    }

    public List<StudentDTO> sortedStudentByNameWithOrder() {
        List<StudentDTO> studentDTOS = sortedStudentByName(); // önce sıralı liste geliyor
        Collections.reverse(studentDTOS); // bu listeyi ters çevirir (in-place)
        return studentDTOS;
    }


    @Override
    public List<StudentDTO> filterByAverage(Double minAverage) {
        List<StudentDTO> studentDTOS = getAllStudentsSortedByAverage();
        List<StudentDTO> filteredStudentList = new ArrayList<>();
        for (StudentDTO studentDTO : studentDTOS) {
            if (studentDTO.getAverage() >= minAverage) {
                filteredStudentList.add(studentDTO);
            }
        }

        return filteredStudentList;


    }

    @Override
    public List<StudentDTO> filterByStudentName(String name) {
        List<StudentEntity> nameList = studentRepository.findByName(name);
        List<StudentDTO> nameByList = new ArrayList<>();
        for (StudentEntity se : nameList) {
            nameByList.add(studentConverter.EntitytoDTO(se));
        }
        return nameByList;
    }

    @Override
    public List<StudentDTO> searchByName(String name) {
        List<StudentEntity> studentEntities = studentRepository.findByNameContainingIgnoreCase(name);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        if (studentEntities.isEmpty()) {
            throw new RuntimeException("Aranan isimle: " + name + " eşleşen öğrenci bulunamadı");

        } else {

            for (StudentEntity se : studentEntities) {
                studentDTOList.add(studentConverter.EntitytoDTO(se));
            }
        }
        return studentDTOList;
    }
}
