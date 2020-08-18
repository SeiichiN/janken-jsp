package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.billies_works.janken.Janken;

@WebServlet("/Jadge")
public class Jadge extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost (
            HttpServletRequest request,
               HttpServletResponse response)
        throws ServletException, IOException {

        String user_hand = request.getParameter("userHand");
        System.out.println( "user_hand:" + user_hand );

        Janken janken = new Janken();
        String winner = janken.input( user_hand );
        System.out.println( "winner:" + winner );
        
        request.setAttribute( "winner", winner );
        request.setAttribute( "janken", janken );

        // forward
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/kekka.jsp");
        dispatcher.forward( request, response );
    }
}

// 修正時刻: Mon Aug 17 12:37:07 2020
