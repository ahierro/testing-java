package com.example.testingjava.junit4;

import com.example.testingjava.Employee;
import com.example.testingjava.EmployeeRepository;
import com.example.testingjava.TestingJavaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestingJavaApplication.class)
@ActiveProfiles({"tc", "tc-auto"})
public class VintageRepositoryIntegrationTest {

    private static final Employee EMPLOYEE1 = new Employee(1L, "John");
    private static final Employee EMPLOYEE2 = new Employee(2L, "Alice");

    @ClassRule
    public static PostgreSQLContainer<ConfigPostgresqlContainer> postgreSQLContainer = ConfigPostgresqlContainer.getInstance();

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
