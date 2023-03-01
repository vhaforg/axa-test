package jp.co.axa.apidemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.controllers.EmployeeController;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController controller;

	@Test
	public void testGetEmployeesByPage() {
        Mockito.doReturn(new ArrayList<Employee>()).when(employeeService).findEmployeesByPage(anyInt(), anyInt());
        List<Employee> resutl = controller.getEmployeesByPage(10, 10);
        assertEquals(resutl.size(),0);
	}

}
