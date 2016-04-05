<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>SpringWeb-Add a tutorial</title>
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
	<h2>Add Tutorial</h2>
	<form:form method="post" action="addTutorial">

		<table>
			<tr>
				<td><form:label path="tutorialTitle">Tutorial Title</form:label></td>
				<td><form:input path="tutorialTitle" /></td>
			</tr>
			<tr>
				<td><form:label path="tutorialAuthor">Tutorial Author</form:label></td>
				<td><form:input path="tutorialAuthor" /></td>
			</tr>
			<tr>
				<td><form:label path="tutorialDescription">Tutorial Description</form:label></td>
				<td><form:input path="tutorialDescription" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Tutorial" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>