/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/11.0.15
 * Generated at: 2024-12-21 11:54:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.frontEnd.Kepsek;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class UserList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/Lenovo/.m2/repository/org/glassfish/web/jakarta.servlet.jsp.jstl/2.0.0/jakarta.servlet.jsp.jstl-2.0.0.jar!/META-INF/c.tld", Long.valueOf(1602848772000L));
    _jspx_dependants.put("file:/C:/Users/Lenovo/.m2/repository/org/glassfish/web/jakarta.servlet.jsp.jstl/2.0.0/jakarta.servlet.jsp.jstl-2.0.0.jar", Long.valueOf(1734627456897L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"id\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Daftar Pengguna</title>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        /* Tambahkan style sidebar, content, dan tabel dari template */\n");
      out.write("        body {\n");
      out.write("            display: flex;\n");
      out.write("            height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar {\n");
      out.write("            width: 250px;\n");
      out.write("            background-color: #34495e;\n");
      out.write("            color: white;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            padding: 15px;\n");
      out.write("            position: fixed;\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar h4 {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a:hover {\n");
      out.write("            background-color: #628ab1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a i {\n");
      out.write("            margin-right: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .content {\n");
      out.write("            margin-left: 260px;\n");
      out.write("            padding: 20px;\n");
      out.write("            flex: 1;\n");
      out.write("            background-color: #f5f5f5;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .table-container {\n");
      out.write("            background: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table, th, td {\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- Sidebar -->\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <h4 class=\"mb-4 mt-2 px-2\">Dashboard Kepsek</h4>\n");
      out.write("        <a href=\"#\"><i class=\"bi bi-person-circle\"></i> Profile</a>\n");
      out.write("        <a href=\"#\"><i class=\"bi bi-house-door-fill\"></i> Beranda</a>\n");
      out.write("        <a href=\"#\"><i class=\"bi bi-list-check\"></i> Pembagian Kelas</a>\n");
      out.write("        <a href=\"#\"><i class=\"bi bi-clipboard2-check\"></i> Nilai Siswa</a>\n");
      out.write("        <a href=\"#\"><i class=\"bi bi-book\"></i> Pembagian Mapel</a>\n");
      out.write("        <hr>\n");
      out.write("        <a href=\"#setting\"><i class=\"bi bi-gear\"></i> Setting</a>\n");
      out.write("        <a href=\"#bantuan\"><i class=\"bi bi-question-circle\"></i> Bantuan</a>\n");
      out.write("        <a href=\"tampilanAwal.jsp\" style=\"margin-top: auto;\"><i class=\"bi bi-box-arrow-left\"></i> Logout</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Main Content -->\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <div class=\"table-container\">\n");
      out.write("            <h3>Daftar Pengguna</h3>\n");
      out.write("            <a href=\"frontEnd/Kepsek/AddUser.jsp\" class=\"btn btn-success btn-sm mb-3\">\n");
      out.write("                <i class=\"bi bi-plus\"></i> Tambah Pengguna\n");
      out.write("            </a>\n");
      out.write("            <table class=\"table table-striped\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Username</th>\n");
      out.write("                        <th>Role</th>\n");
      out.write("                        <th>Aksi</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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

  private boolean _jspx_meth_c_005fforEach_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /frontEnd/Kepsek/UserList.jsp(119,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("user");
      // /frontEnd/Kepsek/UserList.jsp(119,20) name = items type = jakarta.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/frontEnd/Kepsek/UserList.jsp(119,20) '${userList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${userList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("                        <tr>\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                            <td>\n");
            out.write("                                <a href=\"UserServlet?action=edit&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"btn btn-warning btn-sm\">\n");
            out.write("                                    <i class=\"bi bi-pencil\"></i> Edit\n");
            out.write("                                </a>\n");
            out.write("                                <a href=\"UserServlet?action=delete&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"btn btn-danger btn-sm\" onclick=\"return confirm('Apakah Anda yakin ingin menghapus pengguna ini?');\">\n");
            out.write("                                    <i class=\"bi bi-trash\"></i> Hapus\n");
            out.write("                                </a>\n");
            out.write("                            </td>\n");
            out.write("                        </tr>\n");
            out.write("                    ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
