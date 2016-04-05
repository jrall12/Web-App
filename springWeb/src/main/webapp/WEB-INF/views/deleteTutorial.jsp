<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>SpringWeb-Delete a tutorial</title>
	<style type="text/css" media="screen">
    body {
        background-color: #F9F9F9;
        background-image: url(../images/tutorial.png);
        background-position: center top;
        background-repeat: repeat;
        text-shadow: #FFFFFF 0px 1px 0px;
        font-family: "Georgia", "Times", serif;
        -webkit-font-smoothing: antialiased;
    }
    a {
        text-decoration: none;
    }
    #main {
        margin: 50px auto 50px auto;
        width: 1000px;
        min-height: 500px;
        padding: 0px 20px 0px 20px;
    }
</style>
</head>
<body>
<h2>Delete Tutorial</h2>
<form:form method="post" action="deleteTutorial">

	<table>
	<tr>
		<td><form:label path="id">Tutorial ID</form:label></td>
		<td><form:input path="id" /></td> 
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="Delete Tutorial"/>
		</td>
	</tr>
</table>	
	
</form:form>
  
</body>
</html>