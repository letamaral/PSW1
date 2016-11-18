import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Index extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Recuperao signo escolhido
        String signo =  request.getParameter("signo");

        Cookie novoCookie = new Cookie("MeuCookie", signo);
        response.addCookie(novoCookie);
        
        Cookie[] cookie = request.getCookies();
            for(int c = 0; c < cookie.length; c++){
                if (cookie[c].getName().equals("MeuCookie")){
                    signo = cookie[c].getValue();
                }
            }
        
        if(signo == null){
            //Se nao foi informado signo, direciona para a tela de selecao de signo
            request.getRequestDispatcher("escolher.html").forward(request, response);
        } else {
            
            //define o nome do signo para a view
            //request.setAttribute("signo", signo);
            
            //define a previsao correspondente.
            if(signo.equals("aries")){
                request.setAttribute("previsao", "Com a Lua em Câncer se opondo a Vênus e Plutão, hoje suas emoções podem ficar intensas demais! Se precisar, desabafe com uma amiga, isso sempre ajuda. No amor, os sentimentos ficam cada vez mais fortes e vai ser difícil disfarçar. Nas amizades, cuidado para não explodir com quem não merece. Na escola, as emoções podem atrapalhar um pouco os estudos e você terá que ser firme!");
            }
            if(signo.equals("touro")){
                request.setAttribute("previsao", "O dia promete muitas emoções, procure enfrentar tudo com calma e tranquilidade, como é o seu estilo. No amor, tente saber mais o que quer e agir de acordo. Nas amizades, sempre é bom pensar antes de agir e de falar, mas isso não é um problema pra você. Na escola, cuidado com pessoas manipuladoras.");
            }
            if(signo.equals("gemeos")){
                request.setAttribute("previsao", "Autocontrole nem sempre é fácil, ainda mais em dias de Lua em Câncer em oposição a Plutão, mas vale a pena tentar! No amor, você anda preferindo falar menos, ouvir mais e beijar mais ainda. Sábia decisão. Nas amizades, seja sincera e valorize as pessoas verdadeiras. Na escola, não tente trapacear ou colar, pois você poderia ser pega! ");
            }
            if(signo.equals("cancer")){
                request.setAttribute("previsao", "Com a Lua em seu signo se opondo a Vênus e Plutão em Capricórnio, o momento é de instabilidade emocional e nas relações. Tente agir de forma mais racional e evite brigas. Relacionar-se com as pessoas não é tarefa das mais fáceis, mas sempre vale a pena. No amor, a dica é a mesma: faça um esforço para superar os obstáculos, nem só de bons momentos se constrói uma relação. Nas amizades, você dará e receberá apoio. Na escola, faça o que tem que ser feito, mas sem se exigir demais. ");
            }
            if(signo.equals("leao")){
                request.setAttribute("previsao", "Cuide-se, ame-se, não pegue tão pesado consigo mesma. Sua saúde agradece, leonina! No amor, as coisas podem estar ficando cada vez mais sérias e intensas, mas vá com calma, pois hoje o clima pode pesar! Nas amizades, a dica é ter equilíbrio e usar sempre a franqueza. Na escola, com um pouquinho de esforço você conseguirá unir concentração e criatividade, alcançando ótimos resultados! ");
            }
            if(signo.equals("virgem")){
                request.setAttribute("previsao", "O momento é de instabilidade emocional e você precisará agir com a razão. No amor, podem rolar altos e baixos, brigas, intensidade. Nas amizades, só não aceite manipulações, na sua vida, manda você! Na escola, não tenha medo de criar e inovar. ");
            }
            if(signo.equals("libra")){
                request.setAttribute("previsao", "Em casa, procure agir de forma prática, seja objetiva e não bata de frente. No amor, deixe fluir os sentimentos, não fique se criticando e nem fazendo cobranças. Pense menos e sinta mais. Nas amizades, pode chegar gente nova na turma. Na escola, procure ficar numa boa com todo mundo, afinal, é sempre melhor estudar num clima de paz.    ");
            }
            if(signo.equals("escorpiao")){
                request.setAttribute("previsao", "Sua mente que já é profunda, hoje está indo muito mais além. No amor, se você quiser, fará acontecer, mas vá com calma, pois está tudo muito intenso! Nas amizades, cuidado apenas para não se diminuir demais perante os outros, valorize-se! Na escola, você tem tudo pra arrasar, já que está com uma capacidade de raciocínio ainda maior! ");
            }
            if(signo.equals("sagitario")){
                request.setAttribute("previsao", "Economizar às vezes é um grande desafio pra você e hoje as chances de gastar por impulso ou pra compensar as necessidades emocionais são maiores. Controle-se, tenha fé, você consegue! No amor, com um pouco de criatividade é possível driblar o tédio, pode apostar. Nas amizades, o momento é de equilíbrio e compreensão entre as pessoas da turma. Na escola, só não deixe o excesso de perfeccionismo te atrapalhar. ");
            }
            if(signo.equals("capricornio")){
                request.setAttribute("previsao", "As coisas em casa andam meio tensas e isso pode te deixar nervosa também. Procure ter calma, sair, se distrair. No amor, a sorte continua ao seu lado e as chances de coisas boas acontecerem continuam altas. Nas amizades, seja direta, não vale a pena tentar manipular as pessoas. Na escola, não deixe os problemas de casa atrapalharem seus estudos, redobre a concentração!  ");
            }
            if(signo.equals("aquario")){
                request.setAttribute("previsao", "O excesso de sinceridade pode fazer com que você acabe dando foras ou magoando alguém, vá com calma. No amor, não será preciso fazer nada, pois o destino anda trabalhando por você. Tudo está muito intenso. Nas amizades, tudo flui suavemente e estar na companhia da galera é pura diversão. Na escola, inteligência e boas ideias não te faltam, mas é preciso um pouquinho mais de organização. ");
            }
            if(signo.equals("peixes")){
                request.setAttribute("previsao", "Às vezes você fica meio atrapalhada e acaba confundindo as pessoas sem querer. No amor e nas amizades, cuidado para que isso não aconteça, tente ser mais objetiva. Nas amizades, queira por perto apenas pessoas sinceras, não vale a pena investir em quem não está a fim. Na escola, você vai se destacar por seu capricho e dedicação! ");
            }
            
            request.setAttribute("signo", signo);
            
            request.getRequestDispatcher("previsao.jsp").forward(request, response);
        }
    
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
