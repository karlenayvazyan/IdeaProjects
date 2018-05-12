import am.ak.bean.wrapper.Company;
import am.ak.bean.wrapper.Employee;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by karlen on 5/27/17.
 */
public class BeanWrapperTest {

    @Test
    public void testBeanWrapper() {
        Company company = new Company();
        BeanWrapper beanWrapper = new BeanWrapperImpl(company);
        String companyName = "Some Company Inc.";
        beanWrapper.setPropertyValue("name", companyName);
        assertEquals(companyName, company.getName());
    }

    @Test
    public void testBeanWrapperPropertyValue() {
        BeanWrapper beanWrapper = new BeanWrapperImpl(new Company());
        String companyName = "Some Company Inc.";
        PropertyValue propertyValue = new PropertyValue("name", companyName);
        beanWrapper.setPropertyValue(propertyValue);
        Company company = (Company) beanWrapper.getWrappedInstance();
        assertNotNull(company);
        assertEquals(companyName, company.getName());
    }

    @Test
    public void testBeanWrapperCompanyAndEplpyee() {
        BeanWrapper beanWrapperCompany = new BeanWrapperImpl(new Company());
        String companyName = "Some Company Inc.";
        PropertyValue propertyValue = new PropertyValue("name", companyName);
        beanWrapperCompany.setPropertyValue(propertyValue);
        BeanWrapper beanWrapperEmployee = new BeanWrapperImpl(new Employee());
        String employeeName = "Jim Stravinsky";
        beanWrapperEmployee.setPropertyValue("name", employeeName);
        beanWrapperCompany.setPropertyValue("employee", beanWrapperEmployee.getWrappedInstance());
        Company company = (Company) beanWrapperCompany.getWrappedInstance();
        assertNotNull(company);
        assertEquals(companyName, company.getName());
        Employee employee = company.getEmployee();
        assertNotNull(employee);
        assertEquals(employeeName, employee.getName());
    }
}
