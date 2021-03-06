package ru.test.a03_query.db_room;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    // Все сотрудники
    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    // Поиск сотрудника по id
    @Query("SELECT * FROM employee WHERE id = :employeeId")
    Employee getById(long employeeId);

    // Поиск сотрудников с зарплатой больше заданного значения
    @Query("SELECT * FROM employee WHERE salary > :minSalary")
    List<Employee> getAllWithSalaryMoreThan(int minSalary);

    // Поиск сотрудников с зарплатой в заданном диапазоне
    @Query("SELECT * FROM employee WHERE salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> getAllWithSalaryBetween(int minSalary, int maxSalary);

    // Поиск сотрудников по имени или фамилии
    @Query("SELECT * FROM employee WHERE first_name LIKE :search OR last_name LIKE :search")
    List<Employee> getAllWithNameLike(String search);

    // Поиск сотрудников по списку id
    @Query("SELECT * FROM employee WHERE id IN (:idList)")
    List<Employee> getByIdList(List<Long> idList);

    // Вывод первого и второго имени для всех сотрудников
    @Query("SELECT first_name, last_name FROM employee")
    List<Name> getNames();

    // Обновление зарплат у сотрудников по списку id
    @Query("UPDATE employee SET salary = :newSalary WHERE id IN (:idList)")
    void updateSalaryByIdList(List<Long> idList, int newSalary);

    // ...

}
