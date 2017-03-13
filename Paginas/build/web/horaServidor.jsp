<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE>Mostrando a data no Servidor</TITLE>
    </HEAD>
    <BODY>
        Bem-vindo. A hora no Servidor é 
        <%
            java.util.Calendar now = java.util.Calendar.getInstance();
            int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
            int minute = now.get(java.util.Calendar.MINUTE);
            if (hour<10)
                out.println("00" + hour);
            else
                out.println(hour);
                out.println(":");
            if (minute<10)
                out.println("00" + minute);
            else
                out.println(minute);
        %>
    </BODY>
</HTML>