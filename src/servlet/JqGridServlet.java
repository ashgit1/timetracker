package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.JqGridModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class JqGridServlet
 */
public class JqGridServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqGridServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JqGridModel gridModel1 = new JqGridModel();
        gridModel1.setId(1);
        gridModel1.setFirstName("Mohaideen");
        gridModel1.setLastName("Jamil");
        gridModel1.setCity("Coimbatore");
        gridModel1.setState("TamilNadu");

        JqGridModel gridModel2 = new JqGridModel();
        gridModel2.setId(2);
        gridModel2.setFirstName("Ameerkhan");
        gridModel2.setLastName("Saffar");
        gridModel2.setCity("Thirunelveli");
        gridModel2.setState("Tamilnadu");

        List<JqGridModel> jqGridModels = new ArrayList<>();
        jqGridModels.add(gridModel1);
        jqGridModels.add(gridModel2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonArray = gson.toJson(jqGridModels);
        jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":"
                + jqGridModels.size() + ",\"rows\":" + jsonArray + "}";

        System.out.println(jsonArray);

        response.getWriter().print(jsonArray);
		
	}

}
