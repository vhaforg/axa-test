package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private EmployeeService employeeService;

    // @GetMapping("/employees")
    // this api has risk if there are millions of data in db
    // public List<Employee> getEmployees() {
    //     List<Employee> employees = employeeService.retrieveEmployees();
    //     return employees;
    // }
    
    @GetMapping("/employees/{page}/{pageSize}")
    public List<Employee> getEmployeesByPage(@PathVariable(name="page")Integer page,@PathVariable(name="pageSize")Integer pageSize) {
        List<Employee> employees = employeeService.findEmployeesByPage(page,pageSize);
        return employees;
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employee")
    public void saveEmployee(Employee employee){
    	logger.info("saveEmployee:"+employee.toString());
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        logger.info("deleteEmployee:{} Successfully",employeeId);
    }

    @PutMapping("/employee/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
    	logger.info("updateEmployee:"+employee.toString());
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
            employee.setId(employeeId);
            employeeService.updateEmployee(employee);
        }

    }

}
