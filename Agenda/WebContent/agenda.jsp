<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- este e um documento html que executa java -->
<!-- imports -->
<%@ page import="Model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
/*for(int i=0;i<lista.size();i++){
	out.println(lista.get(i).getIdcon());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getEmail());
	out.println(lista.get(i).getFone());
}*/
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="icon" href="imagens/fone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao1">Novo contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>nome</th>
				<th>fone</th>
				<th>email</th>
				<th>opções</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0;i<lista.size();i++){%>
			
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome() %></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
			    <td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="botao1">editar</a></td>
			</tr>
				
			<%}%>
		</tbody>
	</table>
</body>
</html>