/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.14
 * Generated at: 2019-04-10 13:50:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.eshop.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.eshop");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
        return;
      }
    }

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Lucky Online EShop Store</title>\n");
      out.write("\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/css/app.css\">\n");
      out.write("\n");
      out.write("<!-- Bootstrap CSS -->\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("\tintegrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n");
      out.write("\tcrossorigin=\"anonymous\">\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<!-- Fontawesome Cdn -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Google Font Cdn -->\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<header>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<nav class=\"navbar fixed-top navbar-expand-lg navbar-light bg-light\">\n");
      out.write("\t\t\t<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\n");
      out.write("\t\t\t\tdata-target=\"#navbarTogglerDemo01\"\n");
      out.write("\t\t\t\taria-controls=\"navbarTogglerDemo01\" aria-expanded=\"false\"\n");
      out.write("\t\t\t\taria-label=\"Toggle navigation\">\n");
      out.write("\t\t\t\t<span class=\"navbar-toggler-icon\"></span>\n");
      out.write("\t\t\t</button>\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo01\">\n");
      out.write("\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li class=\"nav-item active\"><a class=\"nav-link\"\n");
      out.write("\t\t\t\t\t\thref=\"http://localhost:8080/Eshop/TestController\"><i class=\"fas fa-home\"></i></a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<a class=\"nav-link mr-sm-2\" href=\"#\"><i class=\"fas fa-shopping-cart\"></i></a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<!-- CARROUSEL CARROUSEL CARROUSEL -->\n");
      out.write("\n");
      out.write("\t\t<div id=\"carouselExampleControls\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("  <div class=\"carousel-inner\">\n");
      out.write("    <div class=\"carousel-item active\">\n");
      out.write("      <img src=\"images/samsung.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img src=\"images/samsung.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img src=\"images/samsung.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <a class=\"carousel-control-prev\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"prev\">\n");
      out.write("    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"sr-only\">Previous</span>\n");
      out.write("  </a>\n");
      out.write("  <a class=\"carousel-control-next\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"next\">\n");
      out.write("    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"sr-only\">Next</span>\n");
      out.write("  </a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<main class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<h1>Welcome to my Eshop Store</h1>\n");
      out.write("\n");
      out.write("\t<section class=\"row\">\n");
      out.write("\t\n");
      out.write("\t<form action=\"#\" method=\"get\" class=\"row\">\n");
      out.write("\n");
      out.write("\t\t");

			List<Product> prod = (ArrayList) request.getAttribute("produit");

			for (Product p : prod) {
		
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div class=\"card-deck\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"card\"  id=\"card_content\">\n");
      out.write("\n");
      out.write("\t\t\t\t<img src=");
      out.print("images/" + p.getImg());
      out.write(" class=\"card-img-top img-fluid\" id=\"images\" alt=");
      out.print(p.getName());
      out.write(">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"card-body\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<h5 class=\"card-title\">\n");
      out.write("\t\t\t\t\t\t");
      out.print(p.getName());
      out.write("</h5>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<p class=\"card-text\">");
      out.print(p.getDescription());
      out.write(".\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<p\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t class=\"card-text\">");
      out.print(p.getPrice());
      out.write("\n");
      out.write("\t\t\t\t\t\t€\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\n");
      out.write("\t            <div class=\"card-footer qte col\" ");
if(p.getQuantite()<5){
      out.write("style=\"color: red\"");
}
      out.write(">\n");
      out.write("\t           \n");
      out.write("\t\t\t\t\t\t");
      out.print(p.getQuantite());
      out.write("\n");
      out.write("\t\t\t\t\t\t- En stock\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-outline-success\" id=\"btn\" name=\"products\" value=");
      out.print(p.getName()+"&prix="+p.getPrice());
      out.write(">Ajouter au panier</button>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t\t");

			}
		
      out.write("\n");
      out.write("\t\t</form>\n");
      out.write("\t</section>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t");

	
	String t = (String)request.getAttribute("test");
	out.println(t);
	
      out.write("\n");
      out.write("\t</main>\n");
      out.write("\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}