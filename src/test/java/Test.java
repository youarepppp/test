import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Ignore;
import org.mockito.Mockito;

import com.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import com.util.HttpUtils;

public class Test {

//	@Ignore
//	@org.junit.Test
//	public void testHan() {
//		Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true)
//				.enableOrganizationRecognize(true);
//		CustomDictionary.add("东信");
//		CustomDictionary.add("昆辰");
//		List<Term> terms1 = nShortSegment.seg("你好，欢迎使用HanLP汉语处理包！");
//		List<Term> terms2 = nShortSegment.seg("东信昆辰中李新伟国 提醒您");
//		List<Term> terms = StandardTokenizer.segment("你好，欢迎使用HanLP汉语处理包！");
//		System.out.println(HanLP.convertToSimplifiedChinese("用笔记本电能買士脑写程序"));
//		System.out.println(terms.toString());
//
//		System.out.println(terms1.toString());
//		System.out.println(terms2.toString());
//	}
//
//	@Ignore
//	@org.junit.Test
//	public void mytest() {
//
//	}
//
//	@org.junit.Test
//	public void mock() {
//		LinkedList mockedList = Mockito.mock(LinkedList.class);
//
//		 //stubbing
//		 when(mockedList.get(0)).thenReturn("first");
//		 when(mockedList.get(1)).thenThrow(new RuntimeException());
//		 when(mockedList.get(Mockito.anyInt())).thenReturn("element");
//		 //following prints "first"
//		 System.out.println(mockedList.get(0));
//
//		 //following throws runtime exception
//		 //System.out.println(mockedList.get(1));
//
//		 //following prints "null" because get(999) was not stubbed
//		 System.out.println(mockedList.get(999));
//		 Mockito.verify(mockedList).get( Mockito.anyInt());
//		 //Although it is possible to verify a stubbed invocation, usually it's just redundant
//		 //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
//		 //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
//		 Mockito.verify(mockedList).get(0);
//	}
//	
//	@org.junit.Test
//	public void mockHttp() {
//		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//		when(request.getParameter("bb")).thenReturn("222");  
//	}
//	
//	
//	@org.junit.Test
//	public void userTest() {
//		User user = new User();
//		user.setName("test");
//		user.setPassword("111");
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			HttpUtils.httpPostWithJSON("http://localhost:8080/test/springmvc/api/addUser", mapper.writeValueAsString(user));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
