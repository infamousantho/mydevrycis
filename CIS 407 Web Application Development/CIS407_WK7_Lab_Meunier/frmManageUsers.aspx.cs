using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmManageUsers : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["SecurityLevel"] != "A")
        {
            Response.Redirect("frmLogin.aspx");
        }
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        //test if the user was able to be added on button click
        if (clsDataLayer.SaveUser(Server.MapPath("PayrollSystem_DB.accdb"), txtUserName.Text, txtPassword.Text, ddlSecurityLevel.SelectedValue))
        {
            //update error message label if user was successfully bound
            lblError.Text = "The user was successfully added!";
            grdUsers.DataBind();
        }
        //if user was not able to be bound to the data grid update error message label
        else
        {
            lblError.Text = "The user was not added";
        }
    }
    protected void SqlDataSource2_Selecting(object sender, SqlDataSourceSelectingEventArgs e)
    {

    }
    protected void TextBox1_TextChanged(object sender, EventArgs e)
    {

    }
}