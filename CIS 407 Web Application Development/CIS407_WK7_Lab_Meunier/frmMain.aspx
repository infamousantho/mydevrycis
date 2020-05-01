<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmMain.aspx.cs" Inherits="frmMain" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
        <asp:Image ID="Image1" runat="server" ImageUrl="~/Images/CIS407A_iLab_ACITLogo.jpg" />
        <asp:Panel ID="Panel1" runat="server" Height="1248px" Width="504px">
            <asp:ImageButton ID="imgbtnCalculator" runat="server" Height="155px" ImageUrl="~/Images/Calculator_01.jpg" PostBackUrl="~/frmSalaryCalculator.aspx" Width="184px" OnClick="ImageButton1_Click" />
            <asp:LinkButton ID="linkbtnCalculator" runat="server" PostBackUrl="~/frmSalaryCalculator.aspx">Annual Salary Calculator</asp:LinkButton>
            <br />
            <br />
            <asp:ImageButton ID="imgbtnNewEmployee" runat="server" Height="155px" ImageUrl="~/Images/Employee_Wellness.jpg" PostBackUrl="~/frmPersonnel.aspx" Width="184px" />
            <asp:LinkButton ID="linkbtnNewEmployee" runat="server" PostBackUrl="~/frmPersonnel.aspx">Add New Employee</asp:LinkButton>
            <br />
            <br />
            <br />
            <asp:ImageButton ID="imgbtnViewUserActivity" runat="server" Height="155px" ImageUrl="~/Images/Web-Analytics.png" PostBackUrl="~/frmUserActivity.aspx" Width="188px" />
            <asp:LinkButton ID="linkbtnViewUserActivity" runat="server" PostBackUrl="~/frmUserActivity.aspx">View User Activity</asp:LinkButton>
            <br />
            <br />
            <asp:ImageButton ID="imgbtnViewPersonnel" runat="server" Height="155px" ImageUrl="~/Images/view_personnel.jpg" PostBackUrl="~/frmViewPersonnel.aspx" Width="188px" />
            <asp:LinkButton ID="linkbtnViewPersonnel" runat="server" PostBackUrl="~/frmViewPersonnel.aspx">View Personnel</asp:LinkButton>
            <br />
            <br />
            <asp:ImageButton ID="imgbtnSearch" runat="server" Height="155px" ImageUrl="~/Images/search_personnel.jpg" PostBackUrl="~/frmSearchPersonnel.aspx" Width="188px" />
            <asp:LinkButton ID="linkbtnSearch" runat="server" PostBackUrl="~/frmSearchPersonnel.aspx">Search Personnel</asp:LinkButton>
            <br />
            <br />
            <asp:ImageButton ID="imgbtnEditEmployees" runat="server" Height="155px" ImageUrl="~/Images/edit_employee.jpg" PostBackUrl="~/frmEditPersonnel.aspx" Width="188px" />
            <asp:LinkButton ID="linkbtnEditEmployees" runat="server" PostBackUrl="~/frmEditPersonnel.aspx">Edit Employees</asp:LinkButton>
            <br />
            <br />
            <asp:ImageButton ID="imgbtnManage" runat="server" Height="155px" ImageUrl="~/Images/manage_users.png" OnClick="imgbtnManage_Click" Width="188px" PostBackUrl="~/frmManageUsers.aspx" />
            <asp:LinkButton ID="linkbtnManage" runat="server" PostBackUrl="~/frmManageUsers.aspx">Manage Users</asp:LinkButton>
            <br />
        </asp:Panel>
    </form>
</body>
</html>
