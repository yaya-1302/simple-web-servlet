package com.enigma.servlet;

import com.enigma.enitity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("S1", "Alice", "Dep 1", 35));
        students.add(new Student("S2", "Bob", "Dep 1", 70));
        students.add(new Student("S3", "Charlie", "Dep 1", 60));
        students.add(new Student("S4", "David", "Dep 1", 90));
        students.add(new Student("S5", "Elly", "Dep 2", 30));
        students.add(new Student("S6", "Freya", "Dep 3", 32));
        students.add(new Student("S7", "Gian", "Dep 3", 70));
        students.add(new Student("S8", "Halley", "Dep 3", 20));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Double> passPercentages = new HashMap<>();
        Map<String, Integer> passCounts = new HashMap<>();
        Map<String, Integer> totalCounts = new HashMap<>();

        for (Student student : students) {
            String department = student.getDepartment();
            totalCounts.put(department, totalCounts.getOrDefault(department, 0) + 1);
            if (student.getMarks() >= 40) {
                passCounts.put(department, passCounts.getOrDefault(department, 0) + 1);
            }
        }

        for (String department : totalCounts.keySet()) {
            int total = totalCounts.get(department);
            int passed = passCounts.getOrDefault(department, 0);
            double passPercentage = ((double) passed / total) * 100;
            passPercentages.put(department, passPercentage);
        }

        request.setAttribute("students", students);
        request.setAttribute("passPercentages", passPercentages);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}