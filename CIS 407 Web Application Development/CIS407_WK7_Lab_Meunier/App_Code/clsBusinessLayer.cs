using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
//Enables classes used to send electronic mail to SMTP server for delivery
using System.Net.Mail;

/// <summary>
/// Summary description for clsBusinessLayer
/// </summary>
public class clsBusinessLayer
{
	public clsBusinessLayer()
	{
		//
		// TODO: Add constructor logic here
		//
	}

    public static bool SendEmail(string Sender, string Recipient, string bcc, string cc,
string Subject, string Body)
    {
        try
        {
            //Create empty mail message
            MailMessage MyMailMessage = new MailMessage();
            //Create email address with the specified sender address string
            MyMailMessage.From = new MailAddress(Sender);
            //Create email address with the specified receipient address string
            MyMailMessage.To.Add(new MailAddress(Recipient));
            //Test if blind copy recipients field has been left blank
            if (bcc != null && bcc != string.Empty)
            {
                //Send mail message to specified blind copy recipients, if not blank
                MyMailMessage.Bcc.Add(new MailAddress(bcc));
            }
            //Test if copy recipients field has been left blank
            if (cc != null && cc != string.Empty)
            {
                //Send mail message to specified copy recipients, if not blank
                MyMailMessage.CC.Add(new MailAddress(cc));
            }
            //Set subject line for the mail message
            MyMailMessage.Subject = Subject;
            //Set body of the mail message
            MyMailMessage.Body = Body;
            //Indicates if the body of the message contains HTML
            MyMailMessage.IsBodyHtml = true;
            //Set mail message priority as normal
            MyMailMessage.Priority = MailPriority.Normal;
            //Create a client that can send email to the specified SMTP server
            SmtpClient MySmtpClient = new SmtpClient("localhost");
            //SMTP Port = 25;
            //Generic IP host = "127.0.0.1";
            //Send the specified MailMessage object
            MySmtpClient.Send(MyMailMessage);
            //Return true for SendEmail() function
            return true;
        }
        catch (Exception ex)
        {
            //If an exception is thrown then return false for SendEmail() function
            return false;
        }
    }

}