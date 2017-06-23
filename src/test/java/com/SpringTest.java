package com;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.controller.TestController;
import com.controller.UserController;
import com.entity.User;
import com.service.UserService;


//@RunWith(SpringJUnit4ClassRunner.class)  
//@WebAppConfiguration  
//@ContextConfiguration(locations = { "classpath:spring-mvc.xml" })
public class SpringTest {

//	private MockMvc mockMvc; 
//	
//	@InjectMocks  
//    private TestController testController;  
//	
//	@InjectMocks  
//    private UserController userController;  
//	
//	@Mock  
//    private UserService userService;  
//	
//	@Before  
//    public void setup() {  
//        MockitoAnnotations.initMocks(this);  
//        this.mockMvc = MockMvcBuilders.standaloneSetup(testController).build();  
//    }  
//	@Ignore
//	@Test
//	public void test() {
//		String bb = "+uuu";
//		String result = testController.test(bb);
//		System.out.println(result);
//		assertEquals("test+uuu",result);
//		System.out.println(111);
//	}
//	@Ignore
//	@Test
//	public void test2() {
//		System.out.println(222);
//	}
//	
//	@Ignore
//	@Test
//	public void testAddUser() {
//		String name = "邓海波";  
//        String password = "123456";  
//  
//        User user = new User();  
//        user.setName(name);  
//        user.setPassword(password);  
//		when(userService.addUser(user)).thenReturn(1000);
//		int restUser = userController.addUserInfo(user);
//		assertEquals(1, restUser);  
//		verify(userService).addUser(user);  
//	}
//	@Ignore
//	@Test
//	public void testUser() {
//		String name = "邓海波";  
//        String password = "123456";  
//  
//        User user = new User();  
//        user.setName(name);  
//        user.setPassword(password);  
//		when(userService.testUser(user)).thenAnswer(new Answer(){  
//	        public User answer(InvocationOnMock invocation) throws Throwable {  
//	        	String name = "ddd";  
//	            String password = "nnn";  
//	      
//	            User user = new User();  
//	            user.setName(name);  
//	            user.setPassword(password);  
//	            return user;
//	        }  
//	    });
//		int restUser = userController.testUserInfo(user);
//		assertEquals(1, restUser);  
//		verify(userService).testUser(user);  
//	}
}
