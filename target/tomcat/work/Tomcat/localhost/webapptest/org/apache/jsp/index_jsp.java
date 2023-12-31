/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-12-01 17:14:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>Использование JavaServer Pages</TITLE>\r\n");
      out.write("<META NAME=\"author\" CONTENT=\"Marty Hall -- hall@apl.jhu.edu\">\r\n");
      out.write("<META NAME=\"keywords\"\r\n");
      out.write(" CONTENT=\"JSP,JavaServer Pages,servlets\">\r\n");
      out.write("<META NAME=\"description\"\r\n");
      out.write(" CONTENT=\" JSP.\">\r\n");
      out.write("<LINK REL=STYLESHEET\r\n");
      out.write(" HREF=\"My-Style-Sheet.css\"\r\n");
      out.write(" TYPE=\"text/css\">\r\n");
      out.write("</HEAD>\r\n");
      out.write("<body BGCOLOR=\"#FDF5E6\" TEXT=\"#000000\" LINK=\"#0000EE\"\r\n");
      out.write("       VLINK=\"#551A8B\" ALINK=\"#FF0000\" leftmargin=\"25\" topmargin=\"25\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      \r\n");

  // URL или путь к XML-файлу
  String xmlPath = "file:/C:/Sitaris/cinema.xml";

  try {
    // Создание фабрики для создания парсера
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // Создание парсера
    DocumentBuilder builder = factory.newDocumentBuilder();

    // Загрузка XML-документа
    Document document = builder.parse(new URL(xmlPath).openStream());

    // Получение списка элементов из XML
    NodeList nodeList = document.getElementsByTagName("c:film");
int fullCost=0;
int cost=0;
String title = null;
            String schedule = null;

            String description = null;
            String rating = null;
    // Обход списка элементов
   /**/  for (int i = 0; i < nodeList.getLength(); ++i) {
                        Element film = (Element) nodeList.item(i);
                        List<String> genres = new ArrayList();
                        String isbn = film.getAttribute("isbn");
                        /* */
                        NodeList props = film.getElementsByTagName("*");

                        for (int j = 0; j < props.getLength(); j++) {
                            Element prop = (Element) props.item(j);

                            if ("c:title".equals(prop.getTagName())) {
                                title = prop.getTextContent();

                            } else if ("c:genre".equals(prop.getTagName())) {
                                genres.add(prop.getTextContent());

                            } else if ("c:schedule".equals(prop.getTagName())) {
                                schedule = prop.getTextContent();

                            } else if ("c:description".equals(prop.getTagName())) {
                                description = prop.getTextContent();

                            } else if ("c:rating".equals(prop.getTagName())) {

                                rating = prop.getTextContent();

                            }

                            else if ("c:cost".equals(prop.getTagName())) {
cost= Integer.parseInt (prop.getTextContent());


                            }

                        }
     // String value = node.getTextContent();

      // Вывод информации на страницу
     out.println("Название: " + title + "<br>");
     out.println("Жанры: ");
      for (int k = 0; k < genres.size(); ++k) {
      out.println(genres.get(k));
      }
 out.println("<br>Расписание: " + schedule + "<br>");
 out.println("Рейтинг: " + rating + "<br>");
  out.println("Описание: " + description + "<br>");
   out.println("Цена за билет: " + cost + " р.<br><br>");
      // Извлечение информации из элемента
fullCost += cost;


    }
out.println("Общая стоимость  : " + fullCost + "р.<br>");
  } catch (Exception e) {
    e.printStackTrace();
    out.println("Ошибка загрузки XML: " + e.getMessage());
  }

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
