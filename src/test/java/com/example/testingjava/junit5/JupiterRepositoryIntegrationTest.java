package com.example.testingjava.junit5;

import com.example.testingjava.Employee;
import com.example.testingjava.EmployeeRepository;
import com.example.testingjava.TestingJavaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@SpringBootTest(classes = TestingJavaApplication.class)
@ActiveProfiles("test")
@Testcontainers
public class JupiterRepositoryIntegrationTest extends AbstractDBTest{

    private static final Employee EMPLOYEE1 = new Employee(1L, "John");

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void givenEmployeeEntity_whenInsertWithSave_ThenEmployeeIsPersisted() {
        employeeRepository.save(EMPLOYEE1);
        assertEmployeePersisted(EMPLOYEE1);
    }

    private void assertEmployeePersisted(Employee input) {
        Employee employee = employeeRepository.getOne(input.getId());

        assertNotNull(employee);
        assertEquals(employee.getId(),input.getId());
    }
}
