package jp.co.opst.spring.filter;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class DummyResponse extends HttpServletResponseWrapper {

//    private CharArrayWriter caw = new CharArrayWriter();

    public DummyResponse(HttpServletResponse response) {
        super(response);
    }

//    @Override
//    public PrintWriter getWriter() {
//        return new PrintWriter(caw);
//    }
//
//    @Override
//    public String toString() {
//        return caw.toString();
//    }
//
//    public char[] toCharArray() {
//        return caw.toCharArray();
//    }

}

