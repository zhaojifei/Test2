package cn.itcast.utils;

import java.io.FileOutputStream;
import org.dom4j.Document;//该包是用来读取xml文档的
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//操作user.xml文件的工具类,工具类中的方法和变量声明成static类型
public class XmlUtils {
	private static String filepath;
	static{
		//在XmlUtils这个类的当前位置开始查找user.xml文件
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
	}
	
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
        Document document = reader.read(filepath);
        return document;
	}
	public static void write2Xml(Document document) throws Exception{
		//format是格式化输出器，获得一个prettyprint风格的格式对象
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath),format);
	    writer.write(document);
	    writer.close();
	}
}
