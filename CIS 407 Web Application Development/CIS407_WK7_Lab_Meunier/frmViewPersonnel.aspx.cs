using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmViewPersonnel : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

        if (Session["SecurityLevel"] != "A")
        {
            Response.Redirect("frmLogin.aspx");
        }

        if (!Page.IsPostBack)
        {
            //Declare the Dataset
            dsPersonnel myDataSet = new dsPersonnel();
            //Get the request item value and assign to string variable
            string strSearch = Request["txtSearch"];
            //Fill the dataset with shat is returned from the method.
            myDataSet = clsDataLayer.GetPersonnel(Server.MapPath("PayrollSystem_DB.accdb"), strSearch);
            //Set the DataGrid to the DataSource based on the table
            grdViewPersonnel.DataSource = myDataSet.Tables["tblPersonnel"];
            //Bind the DataGrid
            grdViewPersonnel.DataBind();
        }
    }
}