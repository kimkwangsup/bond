package bond.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface BondInter {
	String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
