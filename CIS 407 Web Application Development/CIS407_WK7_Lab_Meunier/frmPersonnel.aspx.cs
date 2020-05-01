using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmPersonnel : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

        if (Session["SecurityLevel"] != "A")
        {
            Response.Redirect("frmLogin.aspx");
        }

        //Check if user security level is set to administrator and set submit button to visible if so
        if (Session["SecurityLevel"] == "A")
        {
            btnSubmit.Visible = true;
        }
        //If user security level is not administrator then set submit button to not visible
        else
        {
            btnSubmit.Visible = false;
        }
    }



    protected void btnSubmit_Click(object sender, EventArgs e)
    {

        
        //Set variables for dates
        DateTime dt1;
        DateTime dt2;

        //Set lblError label to blank and set text box background colors to default
        lblError.Text = "";
        txtFirstName.BackColor = System.Drawing.Color.White;
        txtLastName.BackColor = System.Drawing.Color.White;
        txtPayRate.BackColor = System.Drawing.Color.White;
        txtStartDate.BackColor = System.Drawing.Color.White;
        txtEndDate.BackColor = System.Drawing.Color.White;

        //Check if text boxes are empty
        if (txtFirstName.Text.Trim() == "")
        {
            txtFirstName.BackColor = System.Drawing.Color.Yellow;
            lblError.Text = "The First Name must not be empty.";
            
        }
        if (txtLastName.Text.Trim() == "")
        {
            txtLastName.BackColor = System.Drawing.Color.Yellow;
            lblError.Text += "\n The Last Name must not be empty.";
           
        }
        if (txtPayRate.Text.Trim() == "")
        {
            txtPayRate.BackColor = System.Drawing.Color.Yellow;
            lblError.Text += "\n The Pay Rate must not be empty.";
            
        }
        if (txtStartDate.Text.Trim() == "")
        {
            txtStartDate.BackColor = System.Drawing.Color.Yellow;
            lblError.Text += "\n The Start Date must not be empty.";
            
        }
        if (txtEndDate.Text.Trim() == "")
        {
            txtEndDate.BackColor = System.Drawing.Color.Yellow;
            lblError.Text += "\n The End Date must not be empty.";
            
        }


        if (txtStartDate.Text.Trim() != "" & txtEndDate.Text.Trim() != "")
        {
            //Store information entered for dates into variables
            dt1 = DateTime.Parse(txtStartDate.Text);
            dt2 = DateTime.Parse(txtEndDate.Text);

            //Try/catch block with logic to prevent an invalid date from causing a server error
            try
            {
                if (DateTime.Compare(dt1, dt2) > 0)
                {
                    txtStartDate.BackColor = System.Drawing.Color.Yellow;
                    lblError.Text = "Start Date must not be greater than End Date.";
                }
                else
                {
                    lblError.Text = "Please enter valid data!";
                }
            }
            catch (Exception ex)
            {
                lblError.Text = "Please enter valid data!";
            }
            finally
            {
                Session["txtFirstName"] = txtFirstName.Text;
                Session["txtLastName"] = txtLastName.Text;
                Session["txtPayRate"] = txtPayRate.Text;
                Session["txtStartDate"] = txtStartDate.Text;
                Session["txtEndDate"] = txtEndDate.Text;
                Server.Transfer("frmPersonnelVerified.aspx");
            }

        }
    }
}