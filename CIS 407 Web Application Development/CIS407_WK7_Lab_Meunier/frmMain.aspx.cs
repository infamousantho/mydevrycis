using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmMain : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //Save user activity from frmPersonnel page to database according to server path
        clsDataLayer.SaveUserActivity(Server.MapPath("PayrollSystem_DB.accdb"), "frmPersonnel");

        //If session security level is equal to "A" / admin
        if (Session["SecurityLevel"] == "A")
        {
            //Make Add New Employee viewable
            linkbtnNewEmployee.Visible = true;
            imgbtnNewEmployee.Visible = true;
            //Make View User Activity viewable
            linkbtnViewUserActivity.Visible = true;
            imgbtnViewUserActivity.Visible = true;
            //Make Edit Employees viewable
            linkbtnEditEmployees.Visible = true;
            imgbtnEditEmployees.Visible = true;
            //Make Manage Employees viewable
            linkbtnManage.Visible = true;
            imgbtnManage.Visible = true;
        }
        //If session security level is not equal to "A" / admin
        else
        {
            //Make Add New Employee not viewable
            linkbtnNewEmployee.Visible = false;
            imgbtnNewEmployee.Visible = false;
            //Make View User Activity not viewable
            linkbtnViewUserActivity.Visible = false;
            imgbtnViewUserActivity.Visible = false;
            //Make Edit Employees not viewable
            imgbtnEditEmployees.Visible = false;
            linkbtnEditEmployees.Visible = false;
            //Make Manage Employees not viewable
            linkbtnManage.Visible = false;
            imgbtnManage.Visible = false;
        }

    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {

    }
    protected void imgbtnManage_Click(object sender, ImageClickEventArgs e)
    {

    }
}