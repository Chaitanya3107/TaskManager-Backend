package com.example.TaskManager.repository;
import com.example.TaskManager.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer> {
}
