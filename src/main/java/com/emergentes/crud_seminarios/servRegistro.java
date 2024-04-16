/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.crud_seminarios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class servRegistro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Estudiante> estudiantes = (ArrayList<Estudiante>) session.getAttribute("seminarios");

        String option = request.getParameter("op");
        int id;
        Estudiante estudiante = new Estudiante();

        int pos;

        switch (option) {
            case "create":
                if (!estudiantes.isEmpty()) {
                    id = estudiantes.get((estudiantes.size() - 1)).getId();
                } else {
                    id = estudiantes.size();
                    session.setAttribute("Estudiante", estudiante);
                }

                request.setAttribute("lastId", id);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                pos = findId(id, estudiantes);
                if (pos != -1) {
                    estudiante = estudiantes.get(pos);
                    request.setAttribute("lastId", id);
                    request.setAttribute("Estudiante", estudiante);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                }
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                pos = findId(id, estudiantes);
                if (pos != -1) {
                    estudiantes.remove(pos);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<Estudiante> estudiantes = (ArrayList<Estudiante>) session.getAttribute("seminarios");

        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellidos");
        String turno = request.getParameter("turno");
        String curso1 = request.getParameter("curso1");
        String curso2 = request.getParameter("curso2");
        String curso3 = request.getParameter("curso3");
        String curso4 = request.getParameter("curso4");
        
        Estudiante est = new Estudiante();
        ArrayList<String> cursos = new ArrayList<>();
        if(curso1 !=null ) cursos.add(curso1);
        if(curso2 !=null ) cursos.add(curso2);
        if(curso3 !=null ) cursos.add(curso3);
        if(curso4 !=null ) cursos.add(curso4);

        
        est.setId(id);
        est.setFecha(fecha);
        est.setNombre(nombre);
        est.setApellidos(apellido);
        
        est.setSeminarios(cursos);
        if(turno == null){
            est.setTurno("Temprano");
        }else{
            est.setTurno(turno);
        }

        if (findId(id, estudiantes) == -1) {
            estudiantes.add(est);
        } else {
            id = findId(id, estudiantes);
            estudiantes.set(id, est);
        }
        
        response.sendRedirect("index.jsp");

    }

    public int findId(int id, ArrayList<Estudiante> estudiantes) {
        int pos = 0;
        for (Estudiante estudiante : estudiantes) {
            if (id == estudiante.getId()) {
                return pos;
            }
            pos++;
        }

        return -1;
    }

}
