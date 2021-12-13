package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import entity.Question;

public final class TakeQuizAnswer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/conponent/header.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <link href=\"css/generalCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/headerCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/takeQuizCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"timeRun(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${min}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(',');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(", onloadFirst(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numOfQuestion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")\">\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"../css/generalCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/headerCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/homeCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"header-top\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"header-bot\">\n");
      out.write("                <div class=\"header-bot-img\">\n");
      out.write("                    <div class=\"header-menu-text\"> \n");
      out.write("                        <a href=\"Login.jsp\" class=\"header-text\"> Home</a>\n");
      out.write("                        <a href=\"takeQuiz\" class=\"header-text\">Take Quiz</a>\n");
      out.write("                        <a href=\"makeQuiz\" class=\"header-text\"> Make Quiz</a>\n");
      out.write("                        <a href=\"manageQuiz\" class=\"header-text\"> Manage Quiz</a>\n");
      out.write("                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>     \n");
      out.write("                </div>    \n");
      out.write("            </div>    \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            <div class=\"content\">            \n");
      out.write("                <div class=\"wel-num-score\" ><span class=\"gen-text2\">Welcome<span> \n");
      out.write("                            <span class=\"gen-text3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></div>\n");
      out.write("                            <div class=\"time-takeQ\"> \n");
      out.write("\n");
      out.write("                                <span class=\"gen-text2\">Time remaining</span> \n");
      out.write("                                <span class=\"gen-text4\" id=\"minutes\"></span>\n");
      out.write("                                <span class=\"gen-text4\" id=\"minutes\">:</span>\n");
      out.write("                                <span class=\"gen-text4\" id=\"seconds\"></span>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            ");
int i = 0;
      out.write("\n");
      out.write("                            ");
String answer = "answer";
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <form id=\"forma\" action=\"TakeQuizController\" method=\"post\">\n");
      out.write("                                <input name=\"isSubmit\" value=\"1\" type=\"hidden\">\n");
      out.write("\n");
      out.write("                                ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lstQuestions}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("question");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("\n");
            out.write("                                    <div id=\"q");
            out.print(i);
            out.write("\" class=\"display\">\n");
            out.write("                                        <div><span id=\"content1\" class=\"gen-text2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${question.getContent()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</span></div>                \n");
            out.write("\n");
            out.write("                                        ");
            //  c:forEach
            org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
            _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
            _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
            _jspx_th_c_forEach_1.setBegin(0);
            _jspx_th_c_forEach_1.setEnd(3);
            _jspx_th_c_forEach_1.setVar("xx");
            int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
            try {
              int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
              if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("\n");
                  out.write("                                            <input type=\"checkbox\" name=\"answer\" value=\"");
                  out.print(i);
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${xx+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                  out.write("\"> \n");
                  out.write("                                            <span class=\"gen-text2\">\n");
                  out.write("                                                ");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${question.getOpt().get(xx)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                  out.write("\n");
                  out.write("                                            </span> \n");
                  out.write("                                            </br>    \n");
                  out.write("\n");
                  out.write("                                        ");
                  int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_c_forEach_1.doCatch(_jspx_exception);
            } finally {
              _jspx_th_c_forEach_1.doFinally();
              _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_1);
            }
            out.write("\n");
            out.write("                                    </div>\n");
            out.write("\n");
            out.write("                                    ");
i++;
            out.write("\n");
            out.write("                                ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("                                <p id=\"mess-submit\" class=\"display gen-text2\">Click next to start from question 1 or submit</p>\n");
      out.write("                                <button type=\"submit\" id=\"sub-but\" class=\"display\">submit</button>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                            <div id=\"div-next\">\n");
      out.write("                                <button type=\"button\" onclick=\"nextQuiz(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numOfQuestion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")\" name=\"next\" class=\"but-takeQ\">\n");
      out.write("                                    Next\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            </div>     \n");
      out.write("                            <script src=\"js/timer.js\" type=\"text/javascript\"></script>\n");
      out.write("                            <script src=\"js/question.js\" type=\"text/javascript\"></script>\n");
      out.write("                            </body>\n");
      out.write("                            </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty sessionScope.user}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <a href=\"logout\" class=\"header-text\"> Log Out</a> ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
