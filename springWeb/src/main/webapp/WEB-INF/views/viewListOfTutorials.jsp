<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link href="common/style.css" rel="stylesheet" type="text/css"/> -->
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
    a:link{color:#7db223; text-decoration:underline; font-size:13px;}
    a:hover{color:#456314; text-decoration:underline; font-size:13px;}
    a:active{color:#7db223; text-decoration:underline; font-size:13px;}
    a:visited{color:#7db223; text-decoration:underline; font-size:13px;}
    #main {
        margin: 50px auto 50px auto;
        width: 1000px;
        min-height: 500px;
        padding: 0px 20px 0px 20px;
    }
  table {
  background:#e0e7d3;
  margin: 0;
  border: 4px solid #e0e7d3;
  border-collapse: collapse;
}

table table {
  margin: -5px 0;
  border: 0px solid #e0e7d3;
  width:100%;
}

table td, table th {
  padding:8px;
}

table th {
  font-size:12px;
  text-align: left;
  font-weight: bold;
}

table thead {
  font-weight:bold;
  font-style:italic;
  background-color:#c9d3b8;
}

caption { 
  caption-side: top; 
  width: auto;
  text-align: left;
  font-size:12px;
  color:#848f73;
  padding-bottom:4px;
}

  #tdAlt {
   background:white;
  }
</style>
<title>List Of Tutorials</title>
</head>
 <body>
 
	<h1>Here is a list of tutorials</h1>
	<table width="50%">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Description</th>

		</tr>
		<c:forEach items="${tutorialForm.listofTutorials}" var="tutorial"
			varStatus="status">
			<tr>
				<td>${tutorial.id}</td>
				<td>${tutorial.tutorialTitle}</td>
				<td>${tutorial.tutorialAuthor}</td>
				<td>${tutorial.tutorialDescription}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="addTutorial">Click here to add Tutorial</a>
	
	<a href="deleteTutorial">Click here to delete Tutorial</a>
	
	<a href="updateTutorial">Click here to update Tutorial</a>
 
    
</body>

</html>