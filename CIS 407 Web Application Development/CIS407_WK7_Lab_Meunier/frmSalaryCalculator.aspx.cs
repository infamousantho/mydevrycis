using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmSalaryCalculator : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnCalculateSalary_Click(object sender, EventArgs e)
    {

        //Declare variables and convert values entered for respecitve text boxes to double

        double hours = Convert.ToDouble(txtAnnualHours.Text);
        double payRate = Convert.ToDouble(txtPayRate.Text);

        //Perform calculation of the numeric values entered into text boxes

        double salary = hours * payRate;

        //Display result by assigning calculated value to label

        lblAnnualSalary.Text = salary.ToString("C");

    }
}