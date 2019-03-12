package sun.common.widget.utils;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

public class HtmlUtils {

	public static void main(String[] args) {
		//String ss = cc("http://www.baidu.com");
		String s = "<p style=\"text-align:center;\"><span style=\"font-size:22.0pt;font-family:����;\" class=\"Apple-style-span\">�������Ϸ�����Ϣ����������������</span></p><p style=\"text-align:center;\"><span style=\"font-size:22.0pt;\" class=\"Apple-style-span\">&#160;</span></p><h1><span style=\"font-family:����;\" class=\"Apple-style-span\">һ������</span></h1><p><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">�������������Ϸ������е���ȫ�����Ϸ��κ����ϵĹ�����Ϊ����������Ч���Լ���ǿ���깤���ķ���Ч�����������Ϸ�����ϣ��������Ϣ�������ֶ������ƹ�����������й����Ż㹤����Ʒ�Ĺ����ص㣬�ڴ˻��������Ӱ��Ϸ��ε�ר��ܿ�����</span></p><p><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">&#160;&#160;&#160;&#160; </span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">�㹤�����Ե�ú��߷�Ϊ���Ĺ��ܵ��ƶ�</span><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">APP</span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">Ӧ�ù�����Ϣ����ϵͳ���ṩ�л��ڿͻ���</span><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">CRM</span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">����������Ա�߷ú͵�ÿͻ�����Ա���ճ��칫�����Լ���ҵ</span><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">/</span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">��λ�ڲ������빵ͨ�����ڻ㹤�������У��������ĺ��������ģ��Ƚ����������԰��Ϸ��ε����󣬵����Ϸ����������������ص㣬������ǽ��飬��ϰ��Ϸ��ε������ϻ㹤��������ʵ�ֹ��ܽ������Ͽ�����һ���µĹ���ģ�飺���Ϸ��Ρ�</span></p><h1><span style=\"font-family:����;\" class=\"Apple-style-span\">������������</span></h1><p><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">���Ϸ���ģ����Ҫ�������¼���Ҫ��</span></p><p><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">1��</span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">����Ⱥ�ڵ绰��д�������󵥡�</span></p><p><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">2��</span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">�ַ�����֪ͨ���Ϲ�����Ա��</span></p><p><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">3��</span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">���Ϲ�����Ա�ӵ���ǰ���ֳ�����</span></p><p><span style=\"font-size:12.0pt;\" class=\"Apple-style-span\">4��</span><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">���Ϲ�����Ա������Ϻ���д���������������ֳ������д���ֳ������ϴ����ֳ�λ���Զ���¼��</span></p><span style=\"font-size:12.0pt;font-family:����;\" class=\"Apple-style-span\">��̨�ṩ���Ϸ��ι�����ͳ�Ʒ��񣨰���ͼ�ͱ���</span><br>";
		System.out.println(Html2Text(s));
	}

	public static String Html2Text(String inputString) {
		String htmlStr = inputString; //��html��ǩ���ַ���
		String textStr = "";
		Pattern p_script;
		java.util.regex.Matcher m_script;
		Pattern p_style;
		java.util.regex.Matcher m_style;
		Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //����script��������ʽ{��<script[^>]*?>[\\s\\S]*?<\\/script> }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //����style��������ʽ{��<style[^>]*?>[\\s\\S]*?<\\/style> }
			String regEx_html = "<[^>]+>"; //����HTML��ǩ��������ʽ

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); //����script��ǩ

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); //����style��ǩ

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); //����html��ǩ

			htmlStr = htmlStr.replace("&#160;", " ");

			textStr = htmlStr;
		} catch (Exception e) {
			e.printStackTrace();
			//Manager.log.debug("neiNewsAction", "Html2Text: " + e.getMessage());
		}
		return textStr;//�����ı��ַ���
	}

	public static String cc(String url) {
		StringBuffer temp = new StringBuffer();
		try {
			HttpURLConnection uc = (HttpURLConnection) new URL(url).openConnection();
			uc.setConnectTimeout(10000);
			uc.setDoOutput(true);
			uc.setRequestMethod("GET");
			uc.setUseCaches(false);
			//			DataOutputStream out = new DataOutputStream(uc.getOutputStream());
			//
			//			// Ҫ���Ĳ���  
			//			//String s = URLEncoder.encode("ra", "GB2312") + "=" + URLEncoder.encode(leibie, "GB2312");
			//			//s += "&" + URLEncoder.encode("keyword", "GB2312") + "=" + URLEncoder.encode(num, "GB2312");
			//			// DataOutputStream.writeBytes���ַ����е�16λ��unicode�ַ���8λ���ַ���ʽд��������  
			//			out.writeBytes(s);
			//			out.flush();
			//			out.close();
			InputStream in = new BufferedInputStream(uc.getInputStream());
			//			int c = 0;
			//			while ((c = rd.read()) != -1) {
			//				temp.append((char) c);
			//			}
			//			System.out.println(temp.toString());

			String s = "";//
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
			while ((s = reader.readLine()) != null) {
				temp.append(s);
			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp.toString();
	}

}
