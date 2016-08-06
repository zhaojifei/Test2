package cn.itcast.utils;

import java.io.FileOutputStream;
import org.dom4j.Document;//�ð���������ȡxml�ĵ���
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//����user.xml�ļ��Ĺ�����,�������еķ����ͱ���������static����
public class XmlUtils {
	private static String filepath;
	static{
		//��XmlUtils�����ĵ�ǰλ�ÿ�ʼ����user.xml�ļ�
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
	}
	
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
        Document document = reader.read(filepath);
        return document;
	}
	public static void write2Xml(Document document) throws Exception{
		//format�Ǹ�ʽ������������һ��prettyprint���ĸ�ʽ����
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath),format);
	    writer.write(document);
	    writer.close();
	}
}
