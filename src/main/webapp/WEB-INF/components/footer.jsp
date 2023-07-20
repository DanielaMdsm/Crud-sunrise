<%-- 
    Document   : footer
    Created on : 16 jul. 2023, 16:05:36
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <footer class="p-2 mt-4 text-bg-dark " style="position: absolute; bottom:0">
    <div class="container">
       
      <br>
      <ul class="nav justify-content-center list-unstyled d-flex">
        <li class="ms-3"><a class="text-body-secondary" href="https://www.linkedin.com/in/daniela-smorales/"><img
              src="images/logo-linkedin.png" width="24" height="24"></a></li>
        <li class="ms-3"><a class="text-body-secondary" href="https://github.com/DanielaMdsm"><img
              src="images/logo-git.png" width="25" height="25" class="rounded"></a></li>

      </ul> 
       <p class="text-center pt-2"> Realizado por Daniela Morales  Copyright &copy; <%= java.time.LocalDate.now().getYear() %><p>
    </div>
  </footer>
</html>
