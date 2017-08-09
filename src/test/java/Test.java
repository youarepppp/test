import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@org.junit.Test
	public void test() {
		String test="dsfsafsdafsadfasdfasdfsadfsadfd";
		System.out.println(test.length()+0.00);
		System.out.println((int)Math.ceil((test.length()+0.00)/10));
	}
	
	@org.junit.Test
	public void test2() throws Exception{
		
		ObjectMapper map = new ObjectMapper();
		String xml="<?xml version=\"1.0\" encoding=\"utf-8\" ?><returnsms> <statusbox> <mobile>13857199949</mobile> <taskid>9193987</taskid> <status>10</status> <receivetime>2017/7/7 13:30:12</receivetime> <errorcode>DELIVRD</errorcode> <extno>649</extno> </statusbox> <statusbox> <mobile>18967159857</mobile> <taskid>9193987</taskid> <status>10</status> <receivetime>2017/7/7 13:30:12</receivetime> <errorcode>DELIVRD</errorcode> <extno>649</extno> </statusbox> </returnsms>";
		InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		SAXBuilder sb = new SAXBuilder();  
        Document doc = sb.build(stream);
        Element root = doc.getRootElement();
        iterateElement(root);
		
	}
	
	
	private static Map  iterateElement(Element element) {  
        List jiedian = element.getChildren();  
        Element et = null;  
        Map obj = new HashMap();  
        List list = null;  
        for (int i = 0; i < jiedian.size(); i++) {  
            list = new LinkedList();  
            et = (Element) jiedian.get(i);  
            if (et.getTextTrim().equals("")) {  
                if (et.getChildren().size() == 0)  
                    continue;  
                if (obj.containsKey(et.getName())) {  
                    list = (List) obj.get(et.getName());  
                }  
                list.add(iterateElement(et));  
                obj.put(et.getName(), list);  
                System.out.println(et.getName()+et.getValue());
            } else {  
                if (obj.containsKey(et.getName())) {  
                    list = (List) obj.get(et.getName());  
                }  
                list.add(et.getTextTrim());  
                obj.put(et.getName(), list);  
                System.out.println(et.getName()+et.getValue());
            }  
        }  
        return obj;  
    }  
}
