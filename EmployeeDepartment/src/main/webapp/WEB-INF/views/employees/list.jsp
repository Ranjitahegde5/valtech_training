<%@page import="com.valtech.EmployeeDepartment.models.DepartmentModels"%>
<%@page import="com.valtech.EmployeeDepartment.models.EmployeeModels"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of All Employees</title>
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }
 
        h1 {
            color: #333;
        }
 
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
 
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
 
        th {
            background-color: #4CAF50;
            color: white;
        }
 
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
 
        tfoot {
            background-color: #4CAF50;
            color: white;
        }
 
        tfoot td {
            padding: 15px;
            text-align: right;
        }
 
        form {
            display: inline-block;
        }
 
        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-right: 5px;
        }
 
        input[type="submit"]:hover {
            background-color: #45a049;
        }
 
        a {
            text-decoration: none;
            color: #3498db;
        }
 
        a:hover {
            text-decoration: underline;
        }
    </style>
<body>
	<h1>List of Employees</h1>
	<%
	List<EmployeeModels> employees = (List<EmployeeModels>) request.getAttribute("employees");
	%>
	<%
	/* List<DepartmentModels> departments = (List<DepartmentModels>) request.getAttribute("departments"); */
	DepartmentModels departmentModels = (DepartmentModels) request.getAttribute("departments");
	request.setAttribute("current", departmentModels.getId());
	%>
	<table>
		<tr>
			<th>Department_ID</th>
			<th>Department_Name</th>
			<th>Department_Location</th>
		</tr>
		<%-- <%
		for (DepartmentModels department : departments) {
			request.setAttribute("department", department);
		%> --%>
		<%
		request.setAttribute("department", departmentModels);
		%>
		<tr>
			<td>${department.id}</td>
			<td>${department.dname}</td>
			<td>${department.dlocation}</td>
		</tr>

		<%-- <%
		}
		%> --%>
		<tr>
			<td colspan="2">
				<form action="list" method="post">
					<input type="submit" name="submit" value="First" /> <input
						type="submit" name="submit" value="Previous" /> <input
						type="submit" name="submit" value="Next" /> <input type="submit"
						name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>Employee_ID</th>
			<th>Employee_Name</th>
			<th>Age</th>
			<th>Experience</th>
			<th>Seniority</th>
			<th>Salary</th>
			<th>Department_ID</th>
			<th>Actions</th>
		</tr>
		<%
		for (EmployeeModels employee : employees) {
			request.setAttribute("employee", employee);
		%>
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.age}</td>
			<td>${employee.experience}</td>
			<td>${employee.seniority}</td>
			<td>${employee.salary}</td>
			<td>${employee.department.id}</td>
			<td><a href="delete?id=${employee.id}">Delete</a> <a
				href="edit?id=${employee.id}">Edit</a></td>
		</tr>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="5" align="right">
					<form method="get" action="new">
						<input type="submit" name="submit" value="Add New Employee" />
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>