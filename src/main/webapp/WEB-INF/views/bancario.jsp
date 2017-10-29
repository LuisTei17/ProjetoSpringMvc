<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Pagina do bancario</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adicionation de bancario
</h1>

<c:url var="addAction" value="/bancario/add" ></c:url>

<form:form action="${addAction}" commandName="bancario">
<table>
	<c:if test="${!empty bancario.nome}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nome">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="nome" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty bancario.nome}">
				<input type="submit"
					value="<spring:message text="Editation do bancario"/>" />
			</c:if>
			<c:if test="${empty bancario.nome}">
				<input type="submit"
					value="<spring:message text="Adicionation do bancario"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Listation de bancarios</h3>
<c:if test="${!empty listaBancarios}">
	<table class="tg">
	<tr>
		<th width="80">ID do bancario</th>
		<th width="120">Nome do bancario</th>
		<th width="60">Editation</th>
		<th width="60">Deletation</th>
	</tr>
	<c:forEach items="${listaBancarios}" var="bancario">
		<tr>
			<td>${bancario.id}</td>
			<td>${bancario.nome}</td>
			<td><a href="<c:url value='/edit/${bancario.id}' />" >Editation</a></td>
			<td><a href="<c:url value='/remove/${bancario.id}' />" >Deletation</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
