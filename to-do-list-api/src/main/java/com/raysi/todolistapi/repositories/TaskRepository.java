package com.raysi.todolistapi.repositories;

import com.raysi.todolistapi.entities.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @NativeQuery("select * from task where id = ?1")
    Task getTaskById(Long id);

    @Modifying
    @Transactional
    @NativeQuery("update task set status = ?2 where id = ?1")
    void updateTask(Long id, boolean status);

    @Modifying
    @Transactional
    @Query(value = "delete from task where id = ?1", nativeQuery = true)
    void deleteTaskById(Long id);


    @Modifying
    @Transactional
    @Query(value = "update task set task = ?2 where id = ?1", nativeQuery = true)
    void updateTitleById(Long id, String title);
}
