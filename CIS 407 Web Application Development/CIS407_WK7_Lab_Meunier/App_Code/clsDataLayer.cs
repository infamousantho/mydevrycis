using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

// Include namespaces to enable database access
using System.Data.OleDb;
using System.Net;
using System.Data;

/// <summary>
/// Summary description for clsDataLayer
/// </summary>
public class clsDataLayer
{
	public clsDataLayer()
	{
	}

    // This function saves the personnel data
    public static bool SavePersonnel(string Database, string FirstName, string LastName,
    string PayRate, string StartDate, string EndDate)
    {
        bool recordSaved;

        //Declare transaction to use later in function
        OleDbTransaction myTransaction = null;

        try
        {
            //Create connection string
            OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" +
            "Data Source=" + Database);
            conn.Open();
            OleDbCommand command = conn.CreateCommand();
            string strSQL;

            //Start transaction within database
            myTransaction = conn.BeginTransaction();
            //Assign transaction object for a pending transaction
            command.Transaction = myTransaction;

            //Add fields to database
            strSQL = "Insert into tblPersonnel " +
            "(FirstName, LastName) values ('" +
            FirstName + "', '" + LastName + "')";
            //Specify how command strings are interpreted
            command.CommandType = CommandType.Text;
            command.CommandText = strSQL;
            //Execute a transact statement against the connection and return rows affected
            command.ExecuteNonQuery();

            //Transaction to update inserted fields in database
            strSQL = "Update tblPersonnel " +
            "Set PayRate=" + PayRate + ", " +
            "StartDate='" + StartDate + "', " +
            "EndDate='" + EndDate + "' " +
            "Where ID=(Select Max(ID) From tblPersonnel)";
            //Specify how command strings are interpreted
            command.CommandType = CommandType.Text;
            command.CommandText = strSQL;
            //Execute a transact statement against the connection and return rows affected
            command.ExecuteNonQuery();

            //End transaction by committing changes
            myTransaction.Commit();

            //Close database connection and save the record
            conn.Close();
            recordSaved = true;
        }
        catch (Exception ex)
        {
            //Roll back changes to database if exception is thrown
            myTransaction.Rollback();

            recordSaved = false;
        }
        return recordSaved;
    }

    //This function gets the employee information from the tblPersonnel
    public static dsPersonnel GetPersonnel(string Database, string strSearch)
    {
        //Create variables
        dsPersonnel DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;
        //Create the connection string
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" + "Data Source=" + Database);
        //Defines sqlDA and what each will consist of and test if a value is entered for a search parameter
        if (strSearch == null || strSearch.Trim() == "")
        {
            sqlDA = new OleDbDataAdapter("select * from tblPersonnel", sqlConn);
        }
        else
        {
            sqlDA = new OleDbDataAdapter("select * from tblPersonnel where LastName = '" + strSearch + "'", sqlConn);
        }
        //Defines DS and what each will consist of
        DS = new dsPersonnel();
        //Outputs the results from the information gathered
        sqlDA.Fill(DS.tblPersonnel);
        //Starts over for a new user
        return DS;
    }

    // This function gets the user activity from the tblUserActivity
    public static dsUserActivity GetUserActivity(string Database)
    {
        //Create variables
        dsUserActivity DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;
        //Create the connection string
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" + "Data Source=" + Database);
        //Defines sqlDA and what each will consist of
        sqlDA = new OleDbDataAdapter("select * from tblUserActivity", sqlConn);
        //Defines DS and what each will consist of
        DS = new dsUserActivity();
        //Outputs the results from the information gathered
        sqlDA.Fill(DS.tblUserActivity);
        //Starts over for a new user
        return DS;
    }
    // This function saves the user activity
    public static void SaveUserActivity(string Database, string FormAccessed)
    {
        //Defines the connection to the database
        OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" +
        "Data Source=" + Database);
        conn.Open();
        OleDbCommand command = conn.CreateCommand();
        string strSQL;
        strSQL = "Insert into tblUserActivity (UserIP, FormAccessed) values ('" +
        GetIP4Address() + "', '" + FormAccessed + "')";
        command.CommandType = CommandType.Text;
        command.CommandText = strSQL;
        command.ExecuteNonQuery();
        conn.Close();
    }
    // This function gets the IP Address
    public static string GetIP4Address()
    {
        string IP4Address = string.Empty;
        foreach (IPAddress IPA in
        Dns.GetHostAddresses(HttpContext.Current.Request.UserHostAddress))
        {
            if (IPA.AddressFamily.ToString() == "InterNetwork")
            {
                IP4Address = IPA.ToString();
                break;
            }
        }
        if (IP4Address != string.Empty)
        {
            return IP4Address;
        }
        foreach (IPAddress IPA in Dns.GetHostAddresses(Dns.GetHostName()))
        {
            if (IPA.AddressFamily.ToString() == "InterNetwork")
            {
                IP4Address = IPA.ToString();
                break;
            }
        }
        return IP4Address;
    }

    // This function verifies a user in the tblUser table
    public static dsUser VerifyUser(string Database, string UserName, string UserPassword)
    {
        //Create variables
        dsUser DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;
        //Create the connection string
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" +
        "Data Source=" + Database);
        //Define sqlDA and what it will consist of
        sqlDA = new OleDbDataAdapter("Select SecurityLevel from tblUserLogin " +
        "where UserName like '" + UserName + "' " +
        "and UserPassword like '" + UserPassword + "'", sqlConn);
        //Define DS and what it will consist of
        DS = new dsUser();
        //Output results from information gathered from table
        sqlDA.Fill(DS.tblUserLogin);
        //Starts over for a new user
        return DS;
    }

    //This function saves the users created in Manage Users
    public static bool SaveUser(string Database, string UserName, string UserPassword, string SecurityLevel)
    {
        bool recordSaved;

        try
        {
            //Create connection string
            OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" +
            "Data Source=" + Database);
            conn.Open();
            OleDbCommand command = conn.CreateCommand();
            string strSQL;

            //Add values into tblUserLogin table
            strSQL = "Insert into tblUserLogin " +
                     "(UserName, UserPassword, SecurityLevel) values ('" +
                     UserName + "', '" + UserPassword + "', '" + SecurityLevel + "')";

            //Specify how command strings are interpreted
            command.CommandType = CommandType.Text;
            command.CommandText = strSQL;

            //Execute a transact statement against the connection and return rows affected
            command.ExecuteNonQuery();

            //Close database connection and save the record
            conn.Close();
            recordSaved = true;
        }
        catch (Exception ex)
        {
            recordSaved = false;
        }

        return recordSaved;

    }

}