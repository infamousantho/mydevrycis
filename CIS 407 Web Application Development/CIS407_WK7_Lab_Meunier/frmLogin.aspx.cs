using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmLogin : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
    {
        //Define dsUserLogin variable
        dsUser dsUserLogin;
        //Define SecurityLevel variable as string
        string SecurityLevel;
        //Assign path to check for login to know where to look in database
        dsUserLogin = clsDataLayer.VerifyUser(Server.MapPath("PayrollSystem_DB.accdb"),
        Login1.UserName, Login1.Password);
        //Tell authentication to deny any security level not defined in step below; set the default state of login to false authentication until we define cases later
        if (dsUserLogin.tblUserLogin.Count < 1)
        {
            e.Authenticated = false;

            //Invoke the SendEmail() function from clsBusinessLayer class and use defined values to send emails
            //via SMTP if the login name or password are incorrect; display faliure text informing email was sent.
            if (clsBusinessLayer.SendEmail("infamousantho@icloud.com",
            "infamousantho@gmail.com", "", "", "Login Incorrect",
            "The login failed for UserName: " + Login1.UserName +
            " Password: " + Login1.Password))
            {
                Login1.FailureText = Login1.FailureText +
                " Your incorrect login information was sent to infamousantho@gmail.com";
            }

            return;
        }
        //Assign security level variable
        SecurityLevel = dsUserLogin.tblUserLogin[0].SecurityLevel.ToString();
        //Switch statements to determine session security level based on user A or U
        switch (SecurityLevel)
        {
            case "A":
                //Set session security for case of A (admin)
                e.Authenticated = true;
                FormsAuthentication.RedirectFromLoginPage(Login1.UserName, false);
                Session["SecurityLevel"] = "A";
                break;
            case "U":
                //Set session security for case of U (user)
                e.Authenticated = true;
                FormsAuthentication.RedirectFromLoginPage(Login1.UserName, false);
                Session["SecurityLevel"] = "U";
                break;
            default:
                e.Authenticated = false;
                break;
        }
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {

    }
}